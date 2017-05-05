package com.app.countdown;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView view1;
	WebView web;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view1=(TextView)findViewById(R.id.myText);
		web=(WebView)findViewById(R.id.webView1);
		web.loadUrl("file:///android_asset/HTML Form/index.html");
		CountDownTimer c1=new CountDownTimer(1000,1){
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTick(long millisUntilFinished) {
				view1.setText(String.valueOf(millisUntilFinished));
			}
		}; 
		c1.start();
	}
}
