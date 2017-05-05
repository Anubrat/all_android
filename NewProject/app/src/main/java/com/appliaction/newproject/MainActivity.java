package com.appliaction.newproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView view;
    ArrayList<String> myImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        view=(ImageView)findViewById(R.id.imageView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task=new MyTask();
                task.execute("http://10.0.3.2/Practise/data.php");
            }
        });
    }

    private class MyTask extends AsyncTask<String,String,String> {
        HttpURLConnection con;
        @Override
        protected String doInBackground(String... params) {
            try{
                URL url=new URL(params[0]);
                con=(HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(10000);
                con.setReadTimeout(15000);
                con.connect();
                int res=con.getResponseCode();
                if(res==200){
                    StringBuilder build=new StringBuilder();
                    BufferedReader st=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line;
                    while((line=st.readLine())!=null){
                        build.append(line).append("\n");
                    }
                    return build.toString();
                }
            }catch(Exception err){
                return null;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            myImage=new ArrayList<String>();
            try {
                JSONArray arr=new JSONArray(s);
                for(int i=0;i<arr.length();i++){
                    myImage.add(arr.getJSONObject(i).getString("Image"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(),s+" "+myImage,Toast.LENGTH_LONG).show();
            Picasso.with(getApplicationContext()).load(myImage.get(1)).into(view);
        }
    }
}
