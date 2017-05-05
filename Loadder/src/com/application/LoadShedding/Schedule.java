package com.application.LoadShedding;

import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class Schedule extends Activity {
	ArrayList<String> newList;
	ListView view1;
	SharedPreferences pref;
	SharedPreferences.Editor edit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule);
		pref=getSharedPreferences("pref", Context.MODE_PRIVATE);
		edit=pref.edit();
		String group=pref.getString("Group", "Default");
		if(group.equals("Default")){
			Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
		}else{
		MyAsync task=new MyAsync();
		task.execute();
	}

	public class MyAsync extends AsyncTask<String, String, String>{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
		@Override
		protected String doInBackground(String... params) {
			HttpClient client1=new DefaultHttpClient();
			HttpPost post=new HttpPost(params[0]);
			try{
				HttpResponse resp=client1.execute(post);
				int status=resp.getStatusLine().getStatusCode();
				if(status==200){
					HttpEntity entity=resp.getEntity();
					String data=EntityUtils.toString(entity);
					return data;
				}
			}catch(Exception err){
				Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_LONG).show();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String Result) {
			pref=getSharedPreferences("results", Context.MODE_PRIVATE);
			edit=pref.edit();
			edit.putString("Results", Result);
			edit.commit();
			
			String result=pref.getString("Results", "Default");
			if(!result.equals("Default")){
				newList=new ArrayList<String>();
				if(result!=null){
				try{
					Intent myIntent=getIntent();
					String group=myIntent.getStringExtra("GroupNumber");
					Toast.makeText(getApplicationContext(), group, Toast.LENGTH_LONG).show();
					JSONArray arr=new JSONArray(Result);
					newList.add(arr.getJSONObject(Integer.parseInt(group)).getString("Sunday"));
					newList.add(arr.getJSONObject(Integer.parseInt(group)).getString("Monday"));
					newList.add(arr.getJSONObject(Integer.parseInt(group)).getString("Tuesday"));
					newList.add(arr.getJSONObject(Integer.parseInt(group)).getString("Wednesday"));
					newList.add(arr.getJSONObject(Integer.parseInt(group)).getString("Thursday"));
					newList.add(arr.getJSONObject(Integer.parseInt(group)).getString("Friday"));
					newList.add(arr.getJSONObject(Integer.parseInt(group)).getString("Saturday"));	
					
					view1=(ListView)findViewById(R.id.listView1);
					ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1, newList);
					view1.setAdapter(adapter);
				}catch (JSONException e) {
					e.printStackTrace();
				}
				for(int i=0;i<newList.size();i++){
					Log.v("val", newList.get(i));
				}
			}else{
				Toast.makeText(getApplicationContext(), "HI", Toast.LENGTH_SHORT).show();
			}
			}
			super.onPostExecute(Result);
		}
		
	}
}
