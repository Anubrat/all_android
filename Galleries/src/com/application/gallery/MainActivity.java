package com.application.gallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

public class MainActivity extends Activity {
	Button clickMe;
	Button clickMe2;
	ImageView view1;
	public final int PICK_GALLERY=200;
	public final int requestCodes=500;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view1=(ImageView)findViewById(R.id.imageView1);
		clickMe=(Button)findViewById(R.id.button1);
		clickMe2=(Button)findViewById(R.id.button2);
		
		clickMe.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				try{
					Intent photoPick=new Intent(Intent.ACTION_PICK);
					photoPick.setType("image/*");
					startActivityForResult(photoPick, PICK_GALLERY);
				}catch(Exception err){
					Log.v("Error", err.getMessage());
				}
			}
		});	
		clickMe2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				try{
					Intent photoClick=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					photoClick.putExtra(MediaStore.EXTRA_OUTPUT,"img");
					startActivityForResult(photoClick, requestCodes);
				
				}catch(Exception err){
					Log.v("Error", err.getMessage());
				}
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch(requestCode){
			case PICK_GALLERY:
				if(resultCode==RESULT_OK){
					Uri imgURI=data.getData();
					view1.setImageURI(imgURI);
					break;
				}
			case requestCodes:
				if(resultCode==RESULT_OK){
					Bitmap bitmap=(Bitmap)data.getExtras().get("data");
					view1.setImageBitmap(bitmap);
				}
				
			
					
		}
	}
	
}
