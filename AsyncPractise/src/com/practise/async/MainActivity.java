package com.practise.async;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button myButton;
    WebView myWebView;
    ProgressBar myProgressBar;
    ListView myListView;
    ArrayList<String> rollNumber;
    ArrayList<String>firstName;
    ArrayList<String>lastName;
    ArrayList<String> address;
    ArrayList<String>age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myProgressBar=(ProgressBar)findViewById(R.id.progressBar);
        myListView=(ListView)findViewById(R.id.listView1);
        myButton=(Button)findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new MyAsyncTask().execute("http://10.0.3.2/Android/value.php");
            }
        });
    }

    public class MyAsyncTask extends AsyncTask<String,String,String>{
        @Override
        protected void onPreExecute() {
            myProgressBar.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(),"Starting",Toast.LENGTH_LONG).show();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpClient clien1=new DefaultHttpClient();
            HttpPost post=new HttpPost(params[0]);
            try{
            	HttpResponse resp=clien1.execute(post);
            	int status=resp.getStatusLine().getStatusCode();
            	if(status==200){
            		HttpEntity ent=resp.getEntity();
            		String data=EntityUtils.toString(ent);
            		return data;
            	}
            }catch(Exception err){
            	Log.v("Error Message", err.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
        	rollNumber=new ArrayList<String>();
        	firstName=new ArrayList<String>();
        	lastName=new ArrayList<String>();
        	address=new ArrayList<String>();
        	age=new ArrayList<String>();
        	if(result!=null){
            	try {
					JSONArray arrays=new JSONArray(result);
					Log.v("Length", String.valueOf(arrays.length()));
					for(int i=0;i<arrays.length();i++){
						rollNumber.add(arrays.getJSONObject(i).getString("RollNumber"));
						firstName.add(arrays.getJSONObject(i).getString("FirstName"));
						lastName.add(arrays.getJSONObject(i).getString("LastName"));
						address.add(arrays.getJSONObject(i).getString("Address"));
						age.add(arrays.getJSONObject(i).getString("Age"));
						CustomView view1=new CustomView(MainActivity.this,rollNumber,firstName,lastName,address,age);
						myListView.setAdapter(view1);
						myProgressBar.setVisibility(View.INVISIBLE);
					}
				} catch (Exception e) {
					Log.v("Erros",e.getMessage());
					e.printStackTrace();
				}            
            }
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }
}