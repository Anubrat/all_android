package com.manandharbibesh.loadsheddingapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Group1 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.group1);
		super.onCreate(savedInstanceState);
		ListView view1=(ListView)findViewById(R.id.listView1);
		String[] days={"1","2"};
		String[] morning={"12","23"};
		String[] night={"sd","sdf"};
		CustomAdapter customAdapter=new CustomAdapter();
		view1.setAdapter(customAdapter);
	}
}
