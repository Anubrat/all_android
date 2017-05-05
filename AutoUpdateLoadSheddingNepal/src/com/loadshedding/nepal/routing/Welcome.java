package com.loadshedding.nepal.routing;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class Welcome extends Activity {
	ProgressBar b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		b1=(ProgressBar)findViewById(R.id.progressBar1);
		MyStartAsync async=new MyStartAsync();
		async.execute(20);
	}
	
	class MyStartAsync extends AsyncTask<String, String	,String>  {
		protected void onPreExecute() {
			b1.setVisibility(View.VISIBLE);
			super.onPreExecute();
		}

		protected String doInBackground(int... params){
			try{
				Thread t1=new Thread(){
					public void run(){
						try{
							sleep(3000);
						}catch(Exception err){
							Log.v("Thread Excpetion", err.getMessage());
						}
					}
				};
				t1.run();
				return 0;	
			}catch(Exception err){
				Log.v("Do in Back Error message ", err.getMessage());
			}
			return 0;
		}
		
		protected void onPostExecute(int result) {
			Intent i1=new Intent(Welcome.this,MainActivity.class);
			startActivity(i1);
			Welcome.this.finish();
		}
	}
}
