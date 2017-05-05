package com.appliaction.asynctask;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn,btn2;
    EditText username, password;
    ArrayList<String> group;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.clickMe);
        btn2 = (Button) findViewById(R.id.notify);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }

        });
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        tv=(TextView)findViewById(R.id.tV);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    MyAsyncTask task = new MyAsyncTask();
                    task.execute(username.getText().toString());
                } catch (Exception err) {
                    Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void start() {
        startService(new Intent(this,MyService.class));
    }

    public class MyAsyncTask extends AsyncTask<String, String, String> {
        HttpURLConnection conn;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... params) {
            InputStream is = null;
            Reader reader = null;
            int len = 50000;
            try {
                URL url = new URL(params[0]);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setDoInput(true);
                conn.connect();
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bR=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while((line=bR.readLine())!=null){
                    stringBuilder.append(line).append("\n");
                }
                return stringBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            String ab=null;
            super.onPostExecute(s);
            tv.setText(s);try {
                JSONArray arr = new JSONArray(s);
                ab=arr.getJSONObject(0).getString("Group");
            }catch (Exception err){}
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), ab, Toast.LENGTH_SHORT).show();

        }

    }

}