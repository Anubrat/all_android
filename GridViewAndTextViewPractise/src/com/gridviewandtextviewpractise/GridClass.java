package com.gridviewandtextviewpractise;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridClass extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_view);
		
		GridView view1=(GridView)findViewById(R.id.gridView);
		String[] names={
							"Bibesh","20","A",
							"Ramesh","40","B"
						};
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, names);
		view1.setAdapter(adapter1);
	}

}
