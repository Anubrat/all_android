package com.mobile.app.gingerbread;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Manandhar on 6/15/16.
 */
public class MyClass extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(),"hsdf",Toast.LENGTH_LONG).show();
        pushNotify(startId,"HELLO");
        return START_STICKY;
    }

    private void pushNotify(int Id,String Msg) {
        NotificationManager manager;
        manager=(NotificationManager)getSystemService(MyClass.NOTIFICATION_SERVICE);
        Intent noti=new Intent(MyClass.this,MainActivity.class);
        PendingIntent intent=PendingIntent.getActivity(getApplicationContext(),0,noti,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(MyClass.this);
        builder.setContentIntent(intent);
        builder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle("EL");
        manager.notify(Id,builder.build());

    }
}
