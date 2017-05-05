package com.appliaction.socialsite;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(TextView)findViewById(R.id.myText);
        MyTask task = new MyTask();
        task.execute("");
    }

    public class MyTask extends AsyncTask<String, String, String> {
        HttpURLConnection connection;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                StringBuilder build;
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(10000);
                connection.setConnectTimeout(15000);
                connection.connect();
                int response = connection.getResponseCode();
                if (response == 200) {
                    build = new StringBuilder();
                    BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = read.readLine()) != null) {
                        build.append(line).append("\n");
                    }
                    return build.toString();
                }
            } catch (Exception err) {}
           return null;
        }

        @Override
        protected void onPostExecute(String s) {
            view.setText(s);
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        }
    }
}
