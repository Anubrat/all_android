package com.application.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
	Toolbar myToolbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myToolbar=(Toolbar)findViewById(R.id.myToolbar);
		setSupportActionBar(myToolbar);
	}
}