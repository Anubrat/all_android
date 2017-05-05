package com.practise.asynctaskproject;


import com.squareup.picasso.Picasso;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	Button myButton;
	WebView myWebView;
	ProgressBar myProgressBar;
	ImageView myImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myImage=(ImageView)findViewById(R.id.myImage);
		Picasso.with(this).load("http://10.0.3.2/Android/img.jpg").into(myImage);
		myButton=(Button)findViewById(R.id.myButton);
		myWebView=(WebView)findViewById(R.id.myWebView);
		myProgressBar=(ProgressBar)findViewById(R.id.myProgressBar);
		myButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
			//	new MyAsyncTask().execute("http://www.facebook.com");
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	class MyAsyncTask extends AsyncTask<String, String, String>{
	
		
		@Override
		protected String doInBackground(String... params) {
			
			HttpClient httpClient=new DefaultHttpClient();
			HttpPost httpPost=new HttpPost(params[0]);
			
			try{
				publishProgress("running");
				
				HttpResponse response=httpClient.execute(httpPost);
				
				int status=response.getStatusLine().getStatusCode();
				if(status==200){
					HttpEntity entity=response.getEntity();
					String data=EntityUtils.toString(entity);
					return data;
				}
			}catch(Exception err){
				Log.v("MYSERLC",err.getMessage());
			}
			return params[0];
		}
		
		@Override
		protected void onPreExecute() {
			myProgressBar.setVisibility(View.VISIBLE);
		}
		
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
			if(result!=null){
				myWebView.loadUrl(result);
			}
			myProgressBar.setVisibility(View.GONE);
		}
		
		@Override
		protected void onProgressUpdate(String... values) {
			Toast.makeText(getApplicationContext(), values[0], Toast.LENGTH_LONG).show();
		}
	}
	
	*/
}
