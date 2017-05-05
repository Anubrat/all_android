package com.appliaction.asynctask;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Manandhar on 4/30/16.
 */
public class MyService extends Service{
    NotificationManager NM;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void PushNotification(int id,String msg){
        NM=(NotificationManager)getSystemService(MyService.NOTIFICATION_SERVICE);
        Intent notifyIntent=new Intent(MyService.this,MainActivity.class);
        PendingIntent pending=PendingIntent.getActivity(getApplicationContext(),0,notifyIntent,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(MyService.this);
        builder.setContentIntent(pending);
    }
}
