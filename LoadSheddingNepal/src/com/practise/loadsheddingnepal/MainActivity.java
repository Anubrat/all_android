package com.practise.loadsheddingnepal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Intent int1;
	String a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView view1=(ListView)findViewById(R.id.listView);
		String[] groups={
							"Group 1",
							"Group 2",
							"Group 3",
							"Group 4",
							"Group 5",
							"Group 6",
							"Group 7",
						};
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, groups);
		view1.setAdapter(adapter1);
		int1=new Intent(MainActivity.this,Load.class);
		view1.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				position+=1;
				switch(position){
					case 1:
					int1=new Intent(MainActivity.this,Load.class);
					a=String.valueOf(position);
					int1.putExtra("Group", a);
					startActivity(int1);
					break;
					

					case 2:
						int1=new Intent(MainActivity.this,Load.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;
						
					case 3:
						int1=new Intent(MainActivity.this,Load.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;
					
					case 4:
						int1=new Intent(MainActivity.this,Load.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;
					case 5:
						int1=new Intent(MainActivity.this,Load.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;

					case 6:
						int1=new Intent(MainActivity.this,Load.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;
					case 7:
						int1=new Intent(MainActivity.this,Load.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;
				}
			}
		});
		
	}
}
