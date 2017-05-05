package com.practise.themepractise;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button b1;
	ProgressBar p1;
	WebView v1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button)findViewById(R.id.button1);
		p1=(ProgressBar)findViewById(R.id.progressBar1);
		v1=(WebView)findViewById(R.id.webView1);
		b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Async().execute("Hello");
			}
		});
	}
	
	public class Async extends AsyncTask<String,String,String>{
		@Override
		protected String doInBackground(String... params) {
			Thread t1=new Thread(){
				public void run(){
					try{
						sleep(5000);
					
					}catch(Exception err){
						Log.v("MainActivity",err.getMessage());
					}
				}
			};
			t1.run();
			t1.start();
			return params[0];
		}
		
		
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
			p1.setVisibility(View.INVISIBLE);
			v1.loadUrl("http://www.facebook.com");
			super.onPostExecute(result);
		}
		
		
		@Override
		protected void onPreExecute() {
			p1.setVisibility(View.VISIBLE);
			
			Toast.makeText(getApplicationContext(), "Hellos", Toast.LENGTH_LONG).show();
			super.onPreExecute();
		}
		
		
		@Override
		protected void onProgressUpdate(String... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
	}
}
