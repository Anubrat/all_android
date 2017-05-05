package com.practise.sharedandpreference;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText myField;
	Button myButton;
	SharedPreferences shared;
	String pName;
	SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myField=(EditText)findViewById(R.id.myField);
		myButton=(Button)findViewById(R.id.myButton);
	
		shared=getSharedPreferences("myPref", Context.MODE_PRIVATE);
		editor=shared.edit();
		String pName=shared.getString("Name", "default");
		
		Toast.makeText(getApplicationContext(), pName, Toast.LENGTH_LONG).show();
		
		if(pName.equals("default")){		
			myButton.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					editor.putString("Name", myField.getText().toString());
					editor.commit();
					Intent makeIntent=new Intent(MainActivity.this,MainActivity2.class);
					startActivity(makeIntent);
					MainActivity.this.finish();
				}
			});
		}else{
			Intent makeIntent=new Intent(MainActivity.this,MainActivity2.class);
			startActivity(makeIntent);
		}
		
		
	}
}
		
		
		