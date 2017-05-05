package com.practise.adapter;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends Activity {
 @Override
	protected void onCreate(Bundle savedInstanceState) {
	 	setContentView(R.layout.activity_list);
	 	super.onCreate(savedInstanceState);
	 	
	 	String[] name=new String[]{"Bibesh","Ramesh","Suresh"};
	 	String[] des=new String[]{"Bibesh is","Ramesh is","Suresh is"};
	 	int[] image=new int[]{R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
	 	
	 	ListView view1=(ListView)findViewById(R.id.listView);
	 	CustomerAdapter adapter = new CustomerAdapter(this,name,des,image);
	 	view1.setAdapter(adapter);
 	}
}
