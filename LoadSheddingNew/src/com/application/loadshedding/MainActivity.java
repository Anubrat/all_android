package com.application.loadshedding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends Activity {
	GridView view1;
	Intent goToGroup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		GridView view1=(GridView)findViewById(R.id.gridView1);
		String[] groups={"Group 1","Group 2","Group 3","Group 4","Group 5","Group 6","Group 7"};
		ArrayAdapter<String> group=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,groups);
		view1.setAdapter(group);
		view1.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				arg2+=1;
				goToGroup=new Intent(MainActivity.this,Group.class);
				String myGroup=String.valueOf(arg2);
				goToGroup.putExtra("myGroup", myGroup);
				startActivity(goToGroup);
			}
		});
	}
}
