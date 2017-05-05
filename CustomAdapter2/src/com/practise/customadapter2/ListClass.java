package com.practise.customadapter2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListClass extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_list);
		super.onCreate(savedInstanceState);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		String[] names={"Bibesh","Ramesh","Bibesh","Ramesh","Bibesh","Ramesh","Bibesh","Ramesh","Bibesh","Ramesh"};
		String[] clickButton={"Click me","Click me","Click me","Click me","Click me","Click me","Click me","Click me","Click me","Click me"};
		int[] imageView={R.drawable.man,R.drawable.monkey,R.drawable.man,R.drawable.monkey,R.drawable.man,R.drawable.monkey,R.drawable.man,R.drawable.monkey,R.drawable.man,R.drawable.monkey};
		
		ListView view1=(ListView)findViewById(R.id.listView);
		
		CustomAdapterClass class1=new CustomAdapterClass(this,R.layout.list_type,names,clickButton,imageView);
		view1.setAdapter(class1);
	}

}
