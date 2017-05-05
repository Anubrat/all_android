package com.pack.loadshedding.nepal;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	Intent int1;
	String a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView view1=(ListView)findViewById(R.id.listView);
		String[] groups={
							"Group 1",
							"Group 2",
							"Group 3",
							"Group 4",
							"Group 5",
							"Group 6",
							"Group 7",
						};
		view1.setHapticFeedbackEnabled(true);
		
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, groups);
		view1.setAdapter(adapter1);
		int1=new Intent(MainActivity.this,Group.class);
		view1.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				position+=1;
				switch(position){
					case 1:
					int1=new Intent(MainActivity.this,Group.class);
					a=String.valueOf(position);
					int1.putExtra("Group", a);
					startActivity(int1);
					break;
					

					case 2:
						int1=new Intent(MainActivity.this,Group.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;
						
					case 3:
						int1=new Intent(MainActivity.this,Group.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;
					
					case 4:
						int1=new Intent(MainActivity.this,Group.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;
					case 5:
						int1=new Intent(MainActivity.this,Group.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;

					case 6:
						int1=new Intent(MainActivity.this,Group.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;
					case 7:
						int1=new Intent(MainActivity.this,Group.class);
						a=String.valueOf(position);
						int1.putExtra("Group", a);
						startActivity(int1);
						break;
				}
			}
		});
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id=item.getItemId();
		if(id==R.id.quit){
			customToast();
			//Toast.makeText(getApplicationContext(), "Designed and Developed by BIBESH MANANDHAR", Toast.LENGTH_LONG).show();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
		createDialgoBox();
	}
	
	public void createDialgoBox(){
		final AlertDialog.Builder dialog1=new AlertDialog.Builder(this);
		dialog1.setTitle("Exit");
		dialog1.setMessage("Do you really want to quit?");
		dialog1.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				MainActivity.this.finish();
			}
		});
		dialog1.setNegativeButton("No",new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		dialog1.show();
	}
	
	public void customToast(){
		LayoutInflater inflate=getLayoutInflater();
		View layout=inflate.inflate(R.layout.toast_design,(ViewGroup)findViewById(R.id.toast_layout_root));
		Toast custom = new Toast(this);
		custom.setGravity(Gravity.CENTER_VERTICAL, 0, 200);
		custom.setView(layout);
		custom.show();
	}
}
