package com.practise.myandroid;

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
		String[] days={"Sundaysadfjlkasdjflkasjflkdjaslfkasdif alsiufil asufaisluf aisfu ","Monday"};
		String[] talika={"3-4","3-7"};
		CustomerAdapter adapter=new CustomerAdapter(this,days,talika);
		view1.setAdapter(adapter);
		
	}
	
}
