package com.manager.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button createContact;
	TextView contactName,contactNumber;
	ImageView contactImage;
	public final int ACTIVITY_CODE=200;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		contactName=(TextView)findViewById(R.id.textView1);
		contactNumber=(TextView)findViewById(R.id.textView2);
		contactImage=(ImageView)findViewById(R.id.imageView1);
		createContact=(Button)findViewById(R.id.createContact);
		createContact.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intentSave=new Intent(MainActivity.this,SaveXmlActivity.class);
				intentSave.putExtra("myVar", "myValue");
				startActivityForResult(intentSave, ACTIVITY_CODE);
			}
		});
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch(requestCode){
			case ACTIVITY_CODE:	
				if(resultCode==RESULT_OK){
					String name=data.getStringExtra("Name");
					String number=data.getStringExtra("Number");
					contactName.setText(name);
					contactNumber.setText(number);
				//	Toast.makeText(getApplicationContext(), String.valueOf(rd), Toast.LENGTH_LONG).show();
					//contactName.setText();
				
			}
		}
	}
}
