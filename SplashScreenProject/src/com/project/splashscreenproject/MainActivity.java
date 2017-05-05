package com.project.splashscreenproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView view1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn1=(Button)findViewById(R.id.button1);
		Button btn2=(Button)findViewById(R.id.button2);
		 view1=(ListView)findViewById(R.id.view1);
			btn1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String[] a={"Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh","Biesh","Ramesh"};
					ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, a);
					view1.setAdapter(adapter);
				}
			});
	
	btn2.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			String[] a={"Asdf","Many"};
			ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, a);
			view1.setAdapter(adapter);
		}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
