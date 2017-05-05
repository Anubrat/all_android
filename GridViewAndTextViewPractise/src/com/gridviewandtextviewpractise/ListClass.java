package com.gridviewandtextviewpractise;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListClass extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);
		try{
		ListView view1=(ListView)findViewById(R.id.listView);
	
		String[] Stringss={
			"Hello","Hi	","Bye"
				
		};
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, Stringss);
		view1.setAdapter(adapter1);
		int a=adapter1.getCount();
		Toast.makeText(getApplicationContext(),String.valueOf(a),Toast.LENGTH_LONG).show();
			
		}catch(Exception err){
			Toast.makeText(getApplicationContext(),err.getMessage(),Toast.LENGTH_LONG).show();
		}
	}
}	
