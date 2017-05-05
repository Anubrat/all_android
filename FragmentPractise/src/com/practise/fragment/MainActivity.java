package com.practise.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	Button myButton;
	WebView myWebView;
	ProgressBar myProgressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(savedInstanceState==null){
			getFragmentManager().beginTransaction().add(R.id.container,new MyFragment()).commit();
		}
	}
}