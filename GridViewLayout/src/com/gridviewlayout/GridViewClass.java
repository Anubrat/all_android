package com.gridviewlayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridViewClass extends Activity{
	GridView view1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_activity);
		view1=(GridView)findViewById(R.id.grid);
		String[] a={	
							"name","age","roll","Bibesh","20","10"
					};
	
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, a);
		view1.setAdapter(adapter);
	}

}
