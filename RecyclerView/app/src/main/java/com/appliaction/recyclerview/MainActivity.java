package com.appliaction.recyclerview;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView view;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAsync tasks = new MyAsync();
        tasks.execute("http://10.0.3.2/Banker/data.php");
        view = (RecyclerView) findViewById(R.id.view);
    }

    public class MyAsync extends AsyncTask<String, String, String> {
        HttpURLConnection con;

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(10000);
                con.setReadTimeout(15000);
                con.connect();
                int res = con.getResponseCode();
                if (res == 200) {
                    StringBuilder builder = new StringBuilder();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line).append("\n");
                    }
                    return builder.toString();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                final List<Information> dataVal = new ArrayList<>();
                JSONArray more = new JSONArray(s);
                for (int i = 0; i < more.length(); i++) {
                    Information classInfo = new Information();
                    classInfo.textView = more.getJSONObject(i).getString("SwiftKey");
                    classInfo.imageView = more.getJSONObject(i).getString("BankLogo");
                    dataVal.add(classInfo);
                 }
                adapter = new CustomAdapter(MainActivity.this, dataVal);
                view.setAdapter(adapter);
                view.addItemDecoration(new Decorator(10));
                view.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            } catch (Exception err) {
                Log.v("Exception", err.getMessage());
            }
        }
    }
}