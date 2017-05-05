package com.application.LoadShedding;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	RadioGroup group;
	Button button;
	Dialog myDialog;
	GridView mainView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mainView=(GridView)findViewById(R.id.gridView1);
		String[] group={"Group 1","Group 2","Group 3","Group 4","Group 5","Group 6","Group 7",};
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, group);
		mainView.setAdapter(adapter);
		mainView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int groupNumber, long arg3) {
				Intent newIntent=new Intent(MainActivity.this,Schedule.class);
				newIntent.putExtra("GroupNumber", String.valueOf(groupNumber));
				startActivity(newIntent);
				
			}
			
		});
		
		/*myDialog=new Dialog(this);
		myDialog.setContentView(R.layout.group_select);
		myDialog.setTitle("Select group");
		myDialog.show();
	
		group=(RadioGroup)myDialog.findViewById(R.id.radioGroup1);
		button=(Button)myDialog.findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				String a=radioValue();
				Toast.makeText(getApplicationContext(),a, Toast.LENGTH_SHORT).show();
				myDialog.dismiss();
			}
		});*/
		
		
	}
	
	 public String radioValue(){
	        int valueOfGroup=group.getCheckedRadioButtonId();
	        RadioButton btn1=(RadioButton)myDialog.findViewById(valueOfGroup);
	        String values=btn1.getText().toString();
	        return values;
	    }
}
