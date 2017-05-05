package com.practise.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyService extends Service {
	public IBinder onBind(Intent arg0) {
		
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(getApplicationContext(), "Started", Toast.LENGTH_LONG).show();
		pushNotification(1,"Starting");
		return START_STICKY;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	public void pushNotification(int id,String Message){
		NotificationManager NM;
		NM=(NotificationManager)getSystemService(MyService.NOTIFICATION_SERVICE);
		Intent nofifyIntent=new Intent(MyService.this,MainActivity.class);
		PendingIntent pending=PendingIntent.getActivity(getApplicationContext(), 0, nofifyIntent, 0);
		Uri alarmSound=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		NotificationCompat.Builder builder=new NotificationCompat.Builder(MyService.this);
		builder.setContentIntent(pending).setSound(alarmSound).setSmallIcon(R.drawable.ic_launcher).setContentTitle("Norifiac").setContentText(Message);
		NM.notify(id,builder.build());
	}

}
