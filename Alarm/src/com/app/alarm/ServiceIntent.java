package com.app.alarm;

import java.util.Calendar;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import android.support.v4.app.NotificationCompat;

public class ServiceIntent extends Service {
	SharedPreferences myPref;
	SharedPreferences.Editor edit;
	int getMinutes,currentMinutes,setMinutes,getHours,setHours,currentHours;
	boolean myVal;
	@Override
	public IBinder onBind(Intent intent) { 		return null; }
	
	public int onStartCommand(Intent intent, int flags, int startId) {
		myPref=getSharedPreferences("pref", Context.MODE_PRIVATE);
		getMinutes=myPref.getInt("minute", 0);
		getHours=myPref.getInt("hours",0);
		setMinutes=getMinutes;
		setHours=getHours;
		Toast.makeText(getApplicationContext(), "You set the alarm of "+getHours+":"+getMinutes,Toast.LENGTH_LONG).show();
		AsyncTasks async=new AsyncTasks();
		async.execute();
		return 0;
	}
	
	public class AsyncTasks extends AsyncTask<String,String,String>{
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}
		
		@Override
		protected String doInBackground(String... params) {
			Thread t1=new Thread(){
				public void run(){
					try{
						Calendar cal=Calendar.getInstance();
						currentMinutes=cal.get(Calendar.MINUTE);
						currentHours=cal.get(Calendar.HOUR);
						Log.v("current Time", String.valueOf(currentHours)+" "+String.valueOf(currentMinutes));
						sleep(500);
					}catch(Exception err){
						Log.v("Error in thread", err.getMessage());
					}
				}
			};
			myVal=true;
			while(myVal=true){
				t1.run();
				if(currentHours==setHours && currentMinutes==setMinutes){
					NotificationManage(1,"completed");
					break;
				}
			}
			return String.valueOf(currentMinutes);
		}
		
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getApplicationContext(), "The value is "+result, Toast.LENGTH_SHORT).show();
			Intent myInte=new Intent(ServiceIntent.this,NewIntent.class);
			myInte.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(myInte);
			super.onPostExecute(result);
			
		}
		
		
	}
	
	public void NotificationManage(int id,String text){
		NotificationManager NM;
		
		NM=(NotificationManager)getSystemService(ServiceIntent.NOTIFICATION_SERVICE);
		Intent inte=new Intent(ServiceIntent.this,MainActivity.class);
		PendingIntent pending=PendingIntent.getActivity(getApplicationContext(),0,inte,0);
		NotificationCompat.Builder builder=new NotificationCompat.Builder(ServiceIntent.this);
		Uri alarm=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		builder.setContentIntent(pending).setSmallIcon(R.drawable.ic_launcher).setSound(alarm).setContentTitle("My Alarm Clock").setContentText(text);
		NM.notify(id,builder.build());
	}
}

	
