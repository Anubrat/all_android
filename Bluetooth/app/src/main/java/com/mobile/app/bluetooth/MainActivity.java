package com.mobile.app.bluetooth;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4;
    BluetoothAdapter adap;
    Set<BluetoothDevice> dev;
    ArrayList<String> devices;
    ListView view;
    Dialog d1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        adap = BluetoothAdapter.getDefaultAdapter();
        devices = new ArrayList<>();

        if (v.getId() == R.id.button) {
            if (!adap.isEnabled()) {
                Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivity(enableBluetooth);
            }
        } else if (v.getId() == R.id.button2) {
            adap.startDiscovery();
            d1 = new Dialog(this);
            d1.setContentView(R.layout.choose);
            view = (ListView) d1.findViewById(R.id.list);
            ArrayList<String> str = new ArrayList<>();
            str.add("Hello");
            str.add("es");
            str.add("sd");

            BroadcastReceiver receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                        Log.v("Value", "" + device.getName());
                        devices.add(device.getName());
                        ArrayAdapter<String> strs = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, devices);
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "Helose", Toast.LENGTH_LONG).show();
                            }
                        });
                        strs.getCount();
                        view.setAdapter(strs);
                        d1.show();
                    }
                }
            };
            IntentFilter inf = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(receiver, inf);
            devices.clear();
        } else if (v.getId() == R.id.button3) {
            Intent in = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            in.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivity(in);
        } else if (v.getId() == R.id.button4) {
            adap.disable();
        }
    }

    private class AcceptThread extends Thread {
        private final BluetoothServerSocket mmServerSocket;


        private AcceptThread() {
            BluetoothServerSocket tmp=null;
            try{
                tmp=mBluetooth
            }
            mmServerSocket = null;
        }
    }

}
