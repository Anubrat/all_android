package com.practise.loadsheddingnepal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	Context context;
	String[] day;
	String[] talika;
	LayoutInflater inflater;
	
	public CustomAdapter(Context ctx,String[] days,String[] talikas) {
		this.day=days;
		this.talika=talikas;
		this.context=ctx;
		this.inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return this.day.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder h1;
		View vi=convertView;
		if(vi==null){
			vi=this.inflater.inflate(R.layout.design,null);
			h1=new Holder();
			h1.days=(TextView)vi.findViewById(R.id.day);
			h1.talika=(TextView)vi.findViewById(R.id.talika);
			vi.setTag(h1);
		}else{
			h1=(Holder) vi.getTag();
		}
		h1.days.setText(this.day[position]);
		h1.talika.setText(this.talika[position]);
		return vi;
	}
	
	public class Holder{
		TextView days;
		TextView talika;
	}
}
