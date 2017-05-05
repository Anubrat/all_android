package com.practise.progressbar;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;


public class MainActivity extends Activity {
	Button button1;
	ProgressBar bar1;
	WebView view1;
	MainActivity obj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		obj=this;
		
		button1=(Button)findViewById(R.id.button1);
		view1=(WebView)findViewById(R.id.webView1);
		bar1=(ProgressBar)findViewById(R.id.progressBar1);
		view1.getSettings().setJavaScriptEnabled(true);
		view1.setInitialScale(80);
		WebSettings webSetting=view1.getSettings();
		
		view1.setWebViewClient(new WebViewClient());
		view1.setScrollBarStyle(view1.SCROLLBARS_INSIDE_OVERLAY);
		button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				new MyAsynTask().execute("http://sujanmaharjan.com.np/bpl/json.php?query=news&v=202");
			}
		});
	}
	
	public class MyAsynTask extends AsyncTask<String, String,String>{
		private String[] arrayTeamName;
		
		@Override
		protected void onPreExecute(){
			bar1.setVisibility(View.VISIBLE);		
		}

		@Override
		protected String doInBackground(String... params) {
			HttpClient httpclient=new DefaultHttpClient();
			HttpPost httppost=new HttpPost(params[0]);
			try{
				publishProgress("AsyncTask Running");
				
				HttpResponse response=httpclient.execute(httppost);
				
				int status=response.getStatusLine().getStatusCode();
				if(status==200){
					HttpEntity entity=response.getEntity();
					String data=EntityUtils.toString(entity);
					return data;
				}
			
			}catch(Exception err){
				Log.v("MainActivity", err.getMessage());
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
			if(result!=null){
				view1.loadUrl(result);
			}
			bar1.setVisibility(View.GONE);
			
		}
		
		@Override
		protected void onProgressUpdate(String... values) {
		
		}
		
	}
}
