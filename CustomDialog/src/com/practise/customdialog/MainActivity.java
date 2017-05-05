package com.practise.customdialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		customDialog();
	}
	
	
	public void customDialog(){
		Dialog myDialog=new Dialog(this);
		myDialog.setContentView(R.layout.design);
		myDialog.setTitle("Welcome");
		Button button1=(Button) myDialog.findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "hi",Toast.LENGTH_LONG).show();
			}
		});
		myDialog.show();
	}
}
