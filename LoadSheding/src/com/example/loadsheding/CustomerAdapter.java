package com.example.loadsheding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomerAdapter extends BaseAdapter {
	public String[] nam;
	public int[] img;
	public Context context;
	public LayoutInflater layout;
	
	public CustomerAdapter(Context ctx,int[] images,String[] names) {
	 this.nam=names;
	 this.img=images;
	 this.context=ctx;
	 this.layout=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	public int getCount() {
		return this.img.length;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi=convertView;
		Holder h1;
		if(vi==null){
			vi=this.layout.inflate(R.layout.design,null);
			h1=new Holder();
			h1.imageView=(ImageView)vi.findViewById(R.id.imageView);
			h1.textView=(TextView)vi.findViewById(R.id.textView);
			vi.setTag(h1);
		}else{
			h1=(Holder)vi.getTag();
		}
		h1.imageView.setImageResource(this.img[position]);
		h1.textView.setText(this.nam[position]);
		return vi;
	}
	
	public class Holder{
		public ImageView imageView;
		public TextView textView;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Object getItem(int position) {
		return null;
	}
	public long getItemId(int position) {
		return 0;
	}

}
