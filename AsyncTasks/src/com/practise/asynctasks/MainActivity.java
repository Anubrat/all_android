package com.practise.asynctasks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button b1;
	WebView webview;
	ProgressBar p1;
	TextView v1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button)findViewById(R.id.button1);
		v1=(TextView)findViewById(R.id.textView);
		//webview = (WebView)findViewById(R.id.webView1);
		p1=(ProgressBar)findViewById(R.id.myProgressBar);
		b1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				new WebViews();
			}
		});
	}
public class WebViews extends WebViewClient{
	public boolean shouldOverrideUrlLoading(WebView view, String url){
		url="http://www.facebook.com";
		view=(WebView)findViewById(R.id.webView1);
		view.loadUrl(url);
		return true;
	}
}
}