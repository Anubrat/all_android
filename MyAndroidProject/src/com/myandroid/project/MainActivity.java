package com.myandroid.project;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button myButton;
	WebView myWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myButton=(Button)findViewById(R.id.button1);
		myWebView=(WebView)findViewById(R.id.webView1);
		myButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new MyAsyncClass().execute("http://www.facebook.com");
			}
		});
	}
	
	public class MyAsyncClass extends AsyncTask<String, String, String>{
		protected String doInBackground(String... params) {
			//Toast.makeText(getApplicationContext(), "RUNNING", Toast.LENGTH_LONG).show();
			
			HttpClient client1=new DefaultHttpClient();
			HttpPost post=new HttpPost(params[0]);
			try{
				HttpResponse resp=client1.execute(post);
				int status=resp.getStatusLine().getStatusCode();
				if(status==200){
					HttpEntity ent=resp.getEntity();
					String data=EntityUtils.toString(ent);
					return data;
				}
			}catch(Exception err){
				Log.v("Error Message", err.getMessage());
				Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_LONG).show();
			}
			return null;
		}
		
		@Override
		protected void onPreExecute() {
		//	Toast.makeText(getApplicationContext(), "Started", Toast.LENGTH_LONG).show();
			super.onPreExecute();
		}
		
		@Override
		protected void onPostExecute(String result) {
			myWebView.loadUrl(result);
		//	Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
			super.onPostExecute(result);
		}
		
		@Override
		protected void onProgressUpdate(String... values) {
		
			super.onProgressUpdate(values);
		}
		
	}
}
