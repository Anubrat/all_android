package com.practise.loadsheddingnepal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Load extends Activity {
	ListView view1;
	String[] days,talika;
	CustomAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load_main);
		Intent int1=getIntent();
		String myString=int1.getStringExtra("Group");
		days=new String[]{
				"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"
			  };
		try{
			int group=Integer.parseInt(myString);
			switch(group){
			case 1:
				view1=(ListView)findViewById(R.id.loadShedding);
				talika=new String[]{
									"5:00 am - 2:00 pm\n6:00 pm - 10:00pm\n",
									"11:00 am - 7:00 pm\n",
									"3:00 am - 10:00 am\n2:00 pm - 8:00pm\n",
									"6:00 am - 3:00 om\n7:00 pm - 11:00 pm\n",
									"10:00 am - 4:00 pm\n8:00 pm - 11:59 pm\n",
									"4:00 am - 12:00 pm\n4:00 pm - 10:00 pm\n",
									"4:00 am - 11:00am\n3:00 pm - 9:00 pm\n"
								};
				adapter=new CustomAdapter(this,this.days,talika);
				view1.setAdapter(adapter);
				break;
				
			case 2:
				view1=(ListView)findViewById(R.id.loadShedding);
				talika=new String[]{
									"4:00 am - 11:00am\n3:00 pm - 9:00 pm\n",
									"5:00 am - 2:00 pm\n6:00 pm - 10:00pm\n",
									"11:00 am - 7:00 pm\n",
									"3:00 am - 10:00 am\n2:00 pm - 8:00pm\n",
									"6:00 am - 3:00 om\n7:00 pm - 11:00 pm\n",
									"10:00 am - 4:00 pm\n8:00 pm - 11:59 pm\n",
									"4:00 am - 12:00 pm\n4:00 pm - 10:00 pm\n"									
								};
				adapter=new CustomAdapter(this,this.days,talika);
				view1.setAdapter(adapter);
				break;
				
				
			case 3:
				view1=(ListView)findViewById(R.id.loadShedding);
				talika=new String[]{
									"4:00 am - 12:00 pm\n4:00 pm - 10:00 pm\n",
									"4:00 am - 11:00am\n3:00 pm - 9:00 pm\n",
									"5:00 am - 2:00 pm\n6:00 pm - 10:00pm\n",
									"11:00 am - 7:00 pm\n",
									"3:00 am - 10:00 am\n2:00 pm - 8:00pm\n",
									"6:00 am - 3:00 om\n7:00 pm - 11:00 pm\n",
									"10:00 am - 4:00 pm\n8:00 pm - 11:59 pm\n"
									
								};
				adapter=new CustomAdapter(this,this.days,talika);
				view1.setAdapter(adapter);
				break;
				
			case 4:
				view1=(ListView)findViewById(R.id.loadShedding);
				talika=new String[]{
									"10:00 am - 4:00 pm\n8:00 pm - 11:59 pm\n",
									"4:00 am - 12:00 pm\n4:00 pm - 10:00 pm\n",
									"4:00 am - 11:00am\n3:00 pm - 9:00 pm\n",
									"5:00 am - 2:00 pm\n6:00 pm - 10:00pm\n",
									"11:00 am - 7:00 pm\n",
									"3:00 am - 10:00 am\n2:00 pm - 8:00pm\n",
									"6:00 am - 3:00 om\n7:00 pm - 11:00 pm\n"
									
								};
				adapter=new CustomAdapter(this,this.days,talika);
				view1.setAdapter(adapter);
				break;
				
			case 5:
				view1=(ListView)findViewById(R.id.loadShedding);
				talika=new String[]{
									"6:00 am - 3:00 om\n7:00 pm - 11:00 pm\n",
									"10:00 am - 4:00 pm\n8:00 pm - 11:59 pm\n",
									"4:00 am - 12:00 pm\n4:00 pm - 10:00 pm\n",
									"4:00 am - 11:00am\n3:00 pm - 9:00 pm\n",
									"5:00 am - 2:00 pm\n6:00 pm - 10:00pm\n",
									"11:00 am - 7:00 pm\n",
									"3:00 am - 10:00 am\n2:00 pm - 8:00pm\n"
									
								};
				adapter=new CustomAdapter(this,this.days,talika);
				view1.setAdapter(adapter);
				break;
				
			case 6:
				view1=(ListView)findViewById(R.id.loadShedding);
				talika=new String[]{
									"3:00 am - 10:00 am\n2:00 pm - 8:00pm\n",
									"6:00 am - 3:00 om\n7:00 pm - 11:00 pm\n",
									"10:00 am - 4:00 pm\n8:00 pm - 11:59 pm\n",
									"4:00 am - 12:00 pm\n4:00 pm - 10:00 pm\n",
									"4:00 am - 11:00am\n3:00 pm - 9:00 pm\n",
									"5:00 am - 2:00 pm\n6:00 pm - 10:00pm\n",
									"11:00 am - 7:00 pm\n"
								
								};
				adapter=new CustomAdapter(this,this.days,talika);
				view1.setAdapter(adapter);
				break;
				
			case 7:
				view1=(ListView)findViewById(R.id.loadShedding);
				talika=new String[]{
									"11:00 am - 7:00 pm\n",
									"3:00 am - 10:00 am\n2:00 pm - 8:00pm\n",
									"6:00 am - 3:00 om\n7:00 pm - 11:00 pm\n",
									"10:00 am - 4:00 pm\n8:00 pm - 11:59 pm\n",
									"4:00 am - 12:00 pm\n4:00 pm - 10:00 pm\n",
									"4:00 am - 11:00am\n3:00 pm - 9:00 pm\n",
									"5:00 am - 2:00 pm\n6:00 pm - 10:00pm\n"
									
								};
				adapter=new CustomAdapter(this,this.days,talika);
				view1.setAdapter(adapter);
				break;
				
				
			}
		}catch(Exception err){
			Toast.makeText(this, err.getMessage(), Toast.LENGTH_LONG).show();
				
		}
	}
}
