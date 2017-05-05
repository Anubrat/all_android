package com.practise.practiseprogramming;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	long holdTime=2000000000;
	long currentTime,lastPressed=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	//	getActionBar().setDisplayHomeAsUpEnabled(true);
		
		ListView view1=(ListView)findViewById(R.id.listView);
		String[] days={"sun","mon"};
		String[] talika={"5-8","5-3"};
		CustomAdapter adapter=new CustomAdapter(this,days,talika);
		view1.setAdapter(adapter);
	
	}
	/*
	@Override
	public void onBackPressed() {
		long currentTime=System.nanoTime();
		if(currentTime-lastPressed<holdTime)
			finish();
		else{
			lastPressed+=currentTime;
			Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id=item.getItemId();
		if(id==R.id.action_settings){
			Toast.makeText(getApplicationContext(), "Click again to quit", Toast.LENGTH_SHORT).show();
		}else if(id==android.R.id.home){
			Toast.makeText(getApplicationContext(), "Click again to quit", Toast.LENGTH_SHORT).show();	
		}
		return super.onOptionsItemSelected(item);
	}
	
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		return super.onMenuItemSelected(featureId, item);
	}*/
}
