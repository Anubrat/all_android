package com.manager.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveXmlActivity extends Activity {
	EditText contactName,contactNumber;
	Button submit,upload;
	public int PICK_GALLERY=200;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.save_xml);
		
		contactName=(EditText)findViewById(R.id.name);
		contactNumber=(EditText)findViewById(R.id.number);
		submit=(Button)findViewById(R.id.submit);
		upload=(Button)findViewById(R.id.Upload);
		submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i=new Intent();
				String name=contactName.getText().toString();
				String contact=contactNumber.getText().toString();
				i.putExtra("Name", name);
				i.putExtra("Number", contact);
				i.putExtra("returnValue", "value");
				setResult(RESULT_OK,i);
				finish();
			}
		});
		
		upload.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Intent myGallery=new Intent(Intent.ACTION_PICK);
				//StartActivityForResult(myGallery,PICK_GALLERY);
			}
			
		});
		
	}
}
