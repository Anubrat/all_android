package com.practise.customadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try{
		String[] names={"Bibesh","Ramesh","Suresh"};
		String[] descriptions={"He is a good Student","He is an average student","He is a poor studnet"};
		int[] imageViews={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		ListView view1=(ListView)findViewById(R.id.listView);
		CustomeAdapter newCustomeAdapter=new CustomeAdapter(this,R.layout.list_main,names,descriptions,imageViews);
		view1.setAdapter(newCustomeAdapter);
		}catch(Exception err){
			Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_LONG).show();
		}
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
