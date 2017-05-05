package com.appliaction.jsonparsing;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    TextView view;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.clickMe);
        view = (TextView)findViewById(R.id.image);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        AsyncTasks task = new AsyncTasks();
        task.execute("http://10.0.3.2/PHP/get.php");

    }

    public class AsyncTasks extends AsyncTask<String, String, String> {
        HttpURLConnection connection;
        StringBuilder sB;
        BufferedReader bR;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(10000);
                connection.setConnectTimeout(15000);
                connection.setRequestMethod("POST");
                connection.connect();
                int response = connection.getResponseCode();
                if (response == 200) {
                    sB = new StringBuilder();
                    bR = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = bR.readLine()) != null) {
                        sB.append(line).append("\n");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sB.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            list = new ArrayList();
            parseJson(s);
            for(int i=0;i<=1;i++){
                view.setText(list.get(i));
            }
        }
    }

    public void parseJson(String s) {
        try {
            JSONArray obj = new JSONArray(s);
            for (int i = 0; i < obj.length(); i++) {
                list.add(obj.getJSONObject(i).getString("ImageName"));
            }
        } catch (Exception err) {

        }
    }
}
