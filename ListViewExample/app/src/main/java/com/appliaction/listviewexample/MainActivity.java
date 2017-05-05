package com.appliaction.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView myView;
    String[] myStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myStr = getResources().getStringArray(R.array.strings);
        myView = (ListView) findViewById(R.id.myListView);
        ArrayAdapter<String> arrays = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, myStr);
        myView.setAdapter(arrays);
    }
}
