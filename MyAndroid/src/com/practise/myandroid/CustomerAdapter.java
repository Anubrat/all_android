package com.practise.myandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CustomerAdapter extends BaseAdapter{
	Context context;
	String[] day;
	String[] talika;
	LayoutInflater inflater;
	public CustomerAdapter(Context ctx, String[] days, String[] talikas) {
		this.context=ctx;
		this.day=days;
		this.talika=talikas;
		this.inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public int getCount() {
		return this.day.length;
	}
	@Override
	public Object getItem(int position) {
		return null;
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi=convertView;
		Holder h1;
		if(vi==null){
			vi=this.inflater.inflate(R.layout.design, null);
			h1=new Holder();
			h1.b1=(Button)vi.findViewById(R.id.button1);
			h1.v1=(TextView)vi.findViewById(R.id.textView1);
			vi.setTag(h1);
		}else{
			h1=(Holder)vi.getTag();
		}
		h1.b1.setText(this.day[position]);
		h1.v1.setText(this.talika[position]);
		return vi;
	}
	class Holder{
		Button b1;
		TextView v1;
	}
}
