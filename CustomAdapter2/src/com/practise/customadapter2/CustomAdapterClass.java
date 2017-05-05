package com.practise.customadapter2;


import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class CustomAdapterClass extends BaseAdapter {
	String[] name;
	String[] clickButton;
	int[] imageView;
	Context context;
	LayoutInflater inflater;
	Resources resource;
	
	public CustomAdapterClass(Context ctx,int resource,String[] names,String[] clickButtons,int[] imageViews) {
		this.context=ctx;
		this.name=names;
		this.clickButton=clickButtons;
		this.imageView=imageViews;
		this.inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return this.name.length;
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
		View view1=convertView;
		Holder holder;
		if(view1==null){
			view1=this.inflater.inflate(R.layout.list_type,null);
			holder=new Holder();
			holder.name=(TextView)view1.findViewById(R.id.textView1);
			holder.button=(Button)view1.findViewById(R.id.button);
			holder.thumb=(ImageView)view1.findViewById(R.id.imageView1);
			view1.setTag(holder);
		}else{
			holder=(Holder)view1.getTag();
		}
		holder.name.setText(this.name[position]);
		holder.button.setText(this.clickButton[position]);
		holder.button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			}
		});
		holder.thumb.setImageResource(this.imageView[position]);
		return view1;
	}
	public static class Holder{
		public TextView name;
		public Button button;
		public ImageView thumb;
	}

}
