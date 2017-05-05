package com.practise.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try{
			getFragmentManager().beginTransaction().add(R.id.menuFragment, new MenuClass()).commit();
			getFragmentManager().beginTransaction().add(R.id.containerFragment, new ContainerClass()).commit();
		}catch(Exception err){
			Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_SHORT).show();
		}
		
	}
}