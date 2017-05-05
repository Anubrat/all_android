package com.appliaction.mypr;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView view;
    Button btn;
    String name;
    EditText text;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        view = (TextView) findViewById(R.id.view);
        text = (EditText) findViewById(R.id.edi);
        bar = (ProgressBar) findViewById(R.id.pbar);
        name=text.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
                MyAsync async=new MyAsync();
                async.execute("http://10.0.3.2/myjason.php?na1me="+name+"&submit=Submit+Query");
            }
        });
    }

    public class MyAsync extends AsyncTask<String,String,String>{
        HttpURLConnection con;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            bar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url=new URL(params[0]);
                con=(HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(10000);
                con.setReadTimeout(15000);
                con.connect();
                int res=con.getResponseCode();
                if(res==200){
                    StringBuilder builder=new StringBuilder();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line;
                    while((line=reader.readLine())!=null){
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
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            bar.setVisibility(View.INVISIBLE);
        }

    }
}
