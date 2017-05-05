package com.application.alarmalarm;

import java.util.Calendar;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class CheckAlarm extends Service{
	int minute;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//Toast.makeText(getApplicationContext(), "Hellow", Toast.LENGTH_LONG).show();
		Calendar cal=Calendar.getInstance();
		minute=cal.get(Calendar.MINUTE);
		Thread t1=new Thread(){
			public void run(){
				try{
					sleep(20000);
					Log.v("Message", String.valueOf(minute));
					Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_LONG).show();
				}catch(Exception err){
		
				}
			}
		};
		while(true){
			if(minute==42){
				Log.v("Finale", String.valueOf(minute));
				t1.run();
				break;
			}
			Log.v("Message", String.valueOf(minute));
		}
		return 0;
	}
}
