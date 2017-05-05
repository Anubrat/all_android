package com.mobile.app.playingwithdatabase;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder dia = new AlertDialog.Builder(this);
        dia.setTitle("click");
        dia.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Save(findViewById(android.R.id.content));
            }
        });
        dia.setNegativeButton("Show", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show(findViewById(android.R.id.content));

            }
        });
        dia.show();
    }

    public void Save(View v) {
        String[] rollNumber = {"1","2"};
        String[] names = {"BIbesh","sd"};
        ContentValues cv = new ContentValues();
        for(int i=0;i<names.length;i++) {
            cv.put(DbConstant.rollNumber, rollNumber[i]);
            cv.put(DbConstant.name, names[i]);
            DbAdapter adapter = new DbAdapter(this);
            adapter.insert(cv);
        }
    }

    public void show(View v) {
        DbAdapter data = new DbAdapter(this);
        Cursor c = data.showFuncton();
        int[] rolls = new int[c.getCount()];
        int i = 0;
        while (c.moveToNext()) {
            rolls[i] = c.getInt(c.getColumnIndex(DbConstant.rollNumber));
            Log.v("RollNumber", "" + rolls[i]);
            i++;
        }

    }
}
