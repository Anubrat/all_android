package com.mobile.app.changingbutton;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by Manandhar on 6/24/16.
 */
public class SystemService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Calendar calendar = Calendar.getInstance();
        int minute = calendar.get(Calendar.MINUTE);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(10000);
                    Log.v("Checking", "Checking");
                } catch (Exception err) {

                }
            }
        };
        while (true) {
            if (minute == intent.getIntExtra("KEY", 10)) {
                Log.v("Finale", String.valueOf(minute));
                break;
            }
            t1.run();
            Log.v("Message", String.valueOf(minute));
            Log.v("V Message", String.valueOf(intent.getIntExtra("KEY", 10)));
        }
        return 0;
    }
}