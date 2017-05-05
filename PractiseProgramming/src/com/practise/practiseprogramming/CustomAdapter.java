package com.practise.practiseprogramming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
	Context context;
	String[] day;
	String[] talika;
	LayoutInflater inflater;
	
	
	public CustomAdapter(Context ctx,String[] days,String[] talikas) {
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
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi=convertView;
		Holder hold;
		if(vi==null){
			vi=this.inflater.inflate(R.layout.design, null);
			hold=new Holder();
			hold.b=(Button)vi.findViewById(R.id.button1);
			hold.tv=(TextView)vi.findViewById(R.id.textView1);
			vi.setTag(hold);
		}else{
			hold=(Holder) vi.getTag();
		}
		hold.b.setText(this.day[position]);
		hold.tv.setText(this.talika[position]);
		
		return null;
	}
	
	public class Holder{
		Button b;
		TextView tv;
	}
}
