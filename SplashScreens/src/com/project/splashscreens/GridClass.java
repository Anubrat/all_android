package com.project.splashscreens;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridClass extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_activity);
		GridView view1=(GridView)findViewById(R.id.gridView);
		String[] array={"Name","age","Bibesh","21","Ramesh","23"};
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,array);
		view1.setAdapter(adapter1);
		
	}

}
