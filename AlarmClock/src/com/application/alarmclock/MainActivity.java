package com.application.alarmclock;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity{
	SharedPreferences pref;
	SharedPreferences.Editor edit;
	String group;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pref=getSharedPreferences("group", Context.MODE_PRIVATE);
		
		group=pref.getString("Name", "Default");
		Async myAsync=new Async();
		myAsync.execute("http://10.0.3.2/JSON/LoadShedding.php");
	}
	public class Async extends AsyncTask<String,String,String>{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
		@Override
		protected String doInBackground(String... params) {
			HttpClient client=new DefaultHttpClient();
			HttpPost post=new HttpPost(params[0]);
			try{
				HttpResponse resp=client.execute(post);
				int status=resp.getStatusLine().getStatusCode();
				if(status==200){
					HttpEntity ent=resp.getEntity();
					String data=EntityUtils.toString(ent);
					edit=pref.edit();
					edit.putString("Name", data);
					edit.commit();
					return data;
				}
			}catch(Exception err){
				
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			String check=pref.getString("Name", "Default");
			Toast.makeText(getApplicationContext(), check, Toast.LENGTH_LONG).show();
			if(check.equals("Default")){
				Toast.makeText(getApplicationContext(), "Old Sechedul", Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(getApplicationContext(), "New Sechedul", Toast.LENGTH_LONG).show();
			}
			super.onPostExecute(result);
		}
		
	}
}