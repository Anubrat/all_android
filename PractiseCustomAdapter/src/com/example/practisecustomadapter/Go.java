package com.example.practisecustomadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Go extends Activity {
	TextView hel;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.go);
		super.onCreate(savedInstanceState);
		
		Intent n1=new Intent(this,MainActivity.class);
		startActivityForResult(n1, 1);
		
		hel=(TextView)findViewById(R.id.textView1);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	if(requestCode==1){
		hel.setText("zhelo");
	}
		super.onActivityResult(requestCode, resultCode, data);
	}

}
