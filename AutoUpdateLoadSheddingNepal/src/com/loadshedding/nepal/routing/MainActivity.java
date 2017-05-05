package com.loadshedding.nepal.routing;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView view1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view1=(ListView)findViewById(R.id.listView1);
		String[] arr={"Group 1","Group 2","Group 3","Group 4","Group 5","Group 6","Group 7"};
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,arr);
		view1.setAdapter(adapter);
	}
}
