package com.practise.fragments2;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Frag extends Fragment{
	Button btn;
	public int requestCode=500;
	
	public Frag() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View viewing=inflater.inflate(R.layout.fragment, null);
		btn=(Button)viewing.findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				try{
					Intent int1=new Intent(Intent.ACTION_CAMERA_BUTTON);
					startActivityForResult(int1, requestCode);
				}catch(Exception err){
					
				}
			}
		});
		return viewing;
		
	}
	


}
