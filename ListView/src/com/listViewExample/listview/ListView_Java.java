package com.listViewExample.listview;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListView_Java extends Activity{
	ListView view1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_activity);
		
		view1=(ListView)findViewById(R.id.listView);
		String[] str= {"Manchester United 1 - 0 Liverpoop ","Arsenal 0 - 0 Stroke City"};
		 
		ArrayAdapter<String> string1= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, str);
		view1.setAdapter(string1);
	}
}