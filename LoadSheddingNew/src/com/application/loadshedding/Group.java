package com.application.loadshedding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

public class Group extends Activity {
	ListView viewList;
	Intent i;
	String group;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_group);
			viewList=(ListView)findViewById(R.id.listView1);
			 i=getIntent();
			 group=i.getStringExtra("myGroup");
			 Toast.makeText(getApplicationContext(), group, Toast.LENGTH_SHORT).show();
			Log.v("Message", group);
		}catch(Exception err){
			Log.v("Error", err.getMessage());
		}
	}
}
