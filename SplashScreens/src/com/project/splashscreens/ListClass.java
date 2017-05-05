package com.project.splashscreens;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListClass extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.list_activity);
		super.onCreate(savedInstanceState);
		ListView view1=(ListView)findViewById(R.id.listView);
		String[] listNames={
							"Bibesh","Ramesh","Suresh","Rikesh"
				
						};
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listNames);
		view1.setAdapter(adapter1);
	}

}
