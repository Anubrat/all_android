package com.example.loadsheding;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView view1=(ListView)findViewById(R.id.listView);
		int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		String[] names={"Bibesh","SUbesh","Ramesh"};
		CustomerAdapter adapter=new CustomerAdapter(this,images,names);
		view1.setAdapter(adapter);
	}

}
