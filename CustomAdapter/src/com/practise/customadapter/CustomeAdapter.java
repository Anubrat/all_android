package com.practise.customadapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomeAdapter extends BaseAdapter {
	String[] name;
	String[] description;
	int[] imageView;
	LayoutInflater inflater;
	Context context;
	int resource;
	
	public CustomeAdapter(Context ctx,int res,String[] names,String[] descriptions,int[] imageViews) {
		this.name=names;
		this.description=descriptions;
		this.imageView=imageViews;
		this.context=ctx;
		this.inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		resource=res;
		
	}
	
	public Object getItem(int position) {		return null;}
	public long getItemId(int position) {		return 0;	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View vi=convertView;
		Holder holder;
		if(vi==null){
			vi=this.inflater.inflate(R.layout.list_main, null);
			 holder=new Holder();
			holder.name=(TextView)vi.findViewById(R.id.textView1);
			holder.description=(TextView)vi.findViewById(R.id.textView2);
			holder.thumb=(ImageView)vi.findViewById(R.id.imageView);
			vi.setTag(holder);
			
			
		}else{
			holder=(Holder)vi.getTag();
		}
		holder.name.setText(this.name[position]);
		holder.description.setText(this.description[position]);
		holder.thumb.setImageResource(this.imageView[position]);
		return vi;
		
	}
	public int getCount() {
		return this.name.length;
	}
	public static class Holder{
		public TextView name;
		public TextView description;
		public ImageView thumb;
	}
}

