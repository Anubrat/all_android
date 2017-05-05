package com.practise.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CustomerAdapter extends BaseAdapter {

	String[] name;
	String[] desc;
	int[] img;
	Context context;
	LayoutInflater inflater;
	
	public CustomerAdapter(Context ctx,String[] names, String[] descs, int[] imgs) {
		this.context=ctx;
		this.name=names;
		this.desc=descs;
		this.img=imgs;
		this.inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return this.name.length;
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
		if(vi==null){
			vi=this.inflater.inflate(R.layout.activity_list, null);
			Holder holder=new Holder();
			holder.title=(TextView)vi.findViewById(R.id.text1);
		}
		return vi;
	}

}
