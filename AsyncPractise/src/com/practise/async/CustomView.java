package com.practise.async;


import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomView extends BaseAdapter {
	Context ctx;
	LayoutInflater inflater;
	ArrayList<String>  rollnumber,firstname,lastname,address,age;

	public CustomView(Context myContext, ArrayList<String> rollNumber, ArrayList<String>  firstName, ArrayList<String>  lastName,
			ArrayList<String>  address, ArrayList<String> age) {
		this.ctx=myContext;
		this.rollnumber=rollNumber;
		this.firstname=firstName;
		this.lastname=lastName;
		this.address=address;
		this.age=age;
		this.inflater=(LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return this.firstname.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		View vi=arg1;
		Handler h1;
		if(vi==null){
			vi=this.inflater.inflate(R.layout.design,null);
			h1=new Handler();
			h1.view1=(TextView)vi.findViewById(R.id.textView1);
			h1.view2=(TextView)vi.findViewById(R.id.textView2);
			h1.view3=(TextView)vi.findViewById(R.id.textView3);
			h1.view4=(TextView)vi.findViewById(R.id.textView4);
			h1.view5=(TextView)vi.findViewById(R.id.textView5);
			vi.setTag(h1);
		}else{
			h1=(Handler)vi.getTag();
		}
		h1.view1.setText(this.rollnumber.get(arg0));
		h1.view2.setText(this.firstname.get(arg0));
		h1.view3.setText(this.lastname.get(arg0));
		h1.view4.setText(this.address.get(arg0));
		h1.view5.setText(this.age.get(arg0));
		return vi;
	}
	
	public static class Handler{
		public TextView view1,view2,view3,view4,view5;
	}

}
