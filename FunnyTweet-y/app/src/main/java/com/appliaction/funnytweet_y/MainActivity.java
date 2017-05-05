package com.appliaction.funnytweet_y;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        view = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task = new MyTask();
                String a="http://sujanmaharjan.com.np/bpl/json.php?query=match";
                task.execute(a);
            }
        });
    }

    private class MyTask extends AsyncTask<String, String, String> {
        HttpURLConnection connection;

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(10000);
                StringBuilder builder = new StringBuilder();
                BufferedReader myInput = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = myInput.readLine()) != null) {
                    builder.append(line).append("\n");
                }
                return builder.toString();
            } catch (Exception err) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
            view.setText(s);
        }
    }
}
