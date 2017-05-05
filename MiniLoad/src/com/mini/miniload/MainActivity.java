package com.mini.miniload;

import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {
	List<String> day1,day2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MyAsync st1=new MyAsync();
		st1.execute("http://10.0.3.2/JSON/LoadShedding.php");
		
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
				HttpResponse res=client1.execute(post);
				int status=res.getStatusLine().getStatusCode();
				if(status==200){
					HttpEntity ent=res.getEntity();
					String data=EntityUtils.toString(ent);
					return data;
				}
			}catch(Exception err){
				Log.v("Post",err.getMessage());
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			//Calendar c=Calendar.getInstance();
			//int asd=c.get(Calendar.DAY_OF_WEEK);
		//	Log.v("asd", String.valueOf(asd));
			try {
				JSONArray ar=new JSONArray(result);
				for(int i=0;i<result.length();i++){
					String a=ar.getJSONObject(i).getString("Group");
					
					if(a.equals("1")){
						String as=ar.getJSONObject(1).getString("Sunday");
						Log.v("Bibesh", as);
						Toast.makeText(getApplicationContext(), as, Toast.LENGTH_LONG).show();
					}
				}
			} catch (Exception e) {
			
			}	
			super.onPostExecute(result);
		}
		
		@Override
		protected void onProgressUpdate(String... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
	}
}
