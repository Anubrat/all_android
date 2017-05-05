package com.mobile.app.databasemanagement;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name, age;
    Button read, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        save = (Button) findViewById(R.id.save);
        read = (Button) findViewById(R.id.read);
        save.setOnClickListener(this);
        read.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                saveToDatabase(name.getText().toString(), age.getText().toString());
                break;
            case R.id.read:
                getValue();
                break;

        }
    }

    private void getValue() {
        DbAdapter adapter = new DbAdapter(this);
        Cursor cv = adapter.show();
        int[] age = new int[cv.getCount()];
        int i = 0;
        while (cv.moveToNext()) {
            age[i] = cv.getInt(cv.getColumnIndex(DbConstant.age));
            i++;

        }
        for (int j = 0; j < age.length; j++) {
            Log.v("Values", String.valueOf(age[j]));
        }
    }

    private void saveToDatabase(String name, String age) {
        ContentValues cv = new ContentValues();
        cv.put(DbConstant.name, name);
        cv.put(DbConstant.age, age);
        Log.v("Valsdfues", "" + cv.get(DbConstant.name));
        DbAdapter adapter = new DbAdapter(this);
        adapter.insert(cv);
    }


}
