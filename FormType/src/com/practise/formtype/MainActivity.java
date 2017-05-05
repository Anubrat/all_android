package com.practise.formtype;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	Spinner mySpinner;
	ListView myListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mySpinner=(Spinner)findViewById(R.id.mySpinner);
		try{
			mySpinner.setOnItemSelectedListener(new OnItemSelectedListener(){
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					position+=1;
					showRoutine(position);
				}
				public void onNothingSelected(AdapterView<?> parent) {
				}
			});
		}catch(Exception err){
			Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}
	
	public void showRoutine(int group){
		switch(group){
		case 1:
			myListView=(ListView)findViewById(R.id.myListView);
			String[] days={"Sun","mon"};
			
			CustomeAdapter adapter=new CustomeAdapter(this,days,schedule)
			myListView.setAdapter(adapter);
			break;
		
		case 2:
			makeToast(group);
			break;
		
		case 3:
			makeToast(group);
			break;
		
		case 4:
			makeToast(group);
			break;
		
		case 5:
			makeToast(group);
			break;
			
		case 6:
			makeToast(group);
			break;
	
		case 7:
			makeToast(group);
			break;
		}
	}
	
	public void makeToast(int group){
		String a=String.valueOf(group);
		Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
	}

}
