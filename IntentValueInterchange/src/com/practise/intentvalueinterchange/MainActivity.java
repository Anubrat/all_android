package com.practise.intentvalueinterchange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	protected static final int PICK_GALLERY = 200;
	Button b1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent i=new Intent(Intent.ACTION_PICK);
				startActivityForResult(i, PICK_GALLERY);
			}
		});
	}
}
