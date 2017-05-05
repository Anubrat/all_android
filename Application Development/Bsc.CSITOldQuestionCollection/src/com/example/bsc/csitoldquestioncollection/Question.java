package com.example.bsc.csitoldquestioncollection;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class Question extends Activity {
	Button questions;
	SharedPreferences sp;
	SharedPreferences.Editor edits;
	WebView views;
	String u;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		sp=getSharedPreferences("myPref",Context.MODE_PRIVATE);
		edits=sp.edit();
		u=sp.getString("URL","myURL");
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		views=(WebView)findViewById(R.id.myWeb);
		views.getSettings().setDisplayZoomControls(false);
		views.getSettings().setBuiltInZoomControls(true);
		Log.v("url", u);
		questions=(Button)findViewById(R.id.myq);
	}

	public void question(View v){
		DbAdapter adapter=new DbAdapter(this);
		Cursor a=adapter.onDisplay();
		String[] mysty = new String[a.getCount()];
		int i=0;
		while(a.moveToNext()){
			Log.v("Values", " "+a.getString(a.getColumnIndex(DbConstant.SITE)));
			mysty[i]=a.getString(a.getColumnIndex(DbConstant.SITE));
			i++;
		}
		String url=mysty[3];
		Log.v("Hello", url);
		edits.putString("URL", url);
		edits.commit();
		Log.v("url", sp.getString("URL", "Hello"));
		views.loadUrl("http://stackoverflow.com/questions/30598560/problems-with-webviewclient-and-onkeydown");
	}
}