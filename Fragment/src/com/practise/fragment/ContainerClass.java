package com.practise.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContainerClass extends Fragment {
	String[] arg;
	ListView cont;
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view1=inflater.inflate(R.layout.container, null);
		arg=new String[]{
			"Bibesh","Bibesh","Suresh"
		};
		ArrayAdapter<String> str=new ArrayAdapter<String>(view1.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1,arg);
		cont=(ListView)view1.findViewById(R.id.ContainerListView);
		cont.setAdapter(str);
		
		
		return view1;
	}
	ContainerClass(){}
}
