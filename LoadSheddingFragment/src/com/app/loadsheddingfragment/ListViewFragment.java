package com.app.loadsheddingfragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewFragment extends Fragment{
	ListView view;
	ListViewFragment(){
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View myView=inflater.inflate(R.layout.listview_fragment, null);
		String[] myArray={"Bibeesh","Ramesh","suresh","mahesh","chyangba","maichang","Maicha","baucha"};
		view=(ListView)myView.findViewById(R.id.listView);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, myArray);
		view.setAdapter(adapter);
		return myView;
	}
}
