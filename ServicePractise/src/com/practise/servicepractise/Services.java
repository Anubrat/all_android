package com.practise.servicepractise;
import java.util.Calendar;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class Services extends Service{
	public IBinder onBind(Intent arg0){
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Calendar myCal=Calendar.getInstance();
		int b=myCal.get(Calendar.MINUTE);
		if(b==19){
			Toast.makeText(getApplicationContext(), "Wake Up", Toast.LENGTH_LONG).show();	
		}
		Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
		return START_STICKY;
	}

}
