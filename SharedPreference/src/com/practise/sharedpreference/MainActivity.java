package com.practise.sharedpreference;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Dialog dialog;
	EditText view1;
	TextView myTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myTextView=(TextView)findViewById(R.id.myTextView);
		myDialog();
	}
	
	public void myDialog(){
		dialog=new Dialog(this);
		dialog.setContentView(R.layout.design);
		dialog.setTitle("Name");
		view1=(EditText)dialog.findViewById(R.id.myField);
		Button b1=(Button)dialog.findViewById(R.id.button);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				String name=view1.getText().toString();
				myTextView.setText(name);
				dialog.dismiss();
			}
		});
		dialog.show();
	}
}
