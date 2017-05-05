package com.manandharbibesh.loadsheddingapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends Activity {
	ListView view1;
	ArrayAdapter<String> adapter;
	String[] objects;
	int my;
	public int ctx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		view1=(ListView)findViewById(R.id.listView);
		objects=new String[]{"Group 1","Group 2","Group 3","Group 4","Group 5","Group 6","Group 7"};
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, objects);
		view1.setAdapter(adapter);
		
		try{
			view1.setOnItemClickListener(new AdapterView.OnItemClickListener() {		
				@Override
				public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
					try{
						if(position==0){
							Intent int1=new Intent(Main.this,Group1.class);
							startActivity(int1);
						}
					}catch(Exception err){
						Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_SHORT).show();
					}
				}
			});
		}catch(Exception err){
			Toast.makeText(this, err.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
}
