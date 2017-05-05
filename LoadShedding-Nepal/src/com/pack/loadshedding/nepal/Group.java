	package com.pack.loadshedding.nepal;
	
	import java.util.Calendar;
	
	import android.app.Activity;
	import android.content.Intent;
	import android.os.Bundle;
	import android.view.Menu;
	import android.view.MenuItem;
	import android.widget.ImageView;
	import android.widget.ListView;
	import android.widget.TextView;
	import android.widget.Toast;
	
	public class Group extends Activity {
	
		
	
	ListView view1;
	int[] days;
	String[] talika;
	CustomAdapter adapter;
	ImageView view12;
	TextView tal,myText;
	Intent int1;
	String myString;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		view12=(ImageView)findViewById(R.id.day);
		tal=(TextView)findViewById(R.id.talika);
		myText=(TextView)findViewById(R.id.myText);
		Calendar myCal=Calendar.getInstance();
		int din=myCal.get(Calendar.DAY_OF_WEEK);
		switch(din){
			case 1:
				view12.setImageResource(R.drawable.sunday);
				break;
			case 2:
				view12.setImageResource(R.drawable.monday);
				break;
		
			case 3:
				view12.setImageResource(R.drawable.tuesday);
				break;
		
			case 4:
				view12.setImageResource(R.drawable.wednesday);
				break;
		
			case 5:
				view12.setImageResource(R.drawable.thursday);
				break;
		
			case 6:
				view12.setImageResource(R.drawable.friday);
				break;
		
			case 7:
				view12.setImageResource(R.drawable.saturday);
				break;
		}
		
		
		
		int1=getIntent();
		 myString=int1.getStringExtra("Group");
		days=new int[]{R.drawable.sunday,R.drawable.monday,R.drawable.tuesday,R.drawable.wednesday,R.drawable.thursday,R.drawable.friday,R.drawable.saturday
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
		setCurrentLoadSheddingSchedule(myString);
		}
	@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			int press=item.getItemId();
			if(press==android.R.id.home){
				finish();
			}
			return super.onOptionsItemSelected(item);
		}
	
	 void setCurrentLoadSheddingSchedule(String group){
		
		 Calendar c=Calendar.getInstance();
		 int day=c.get(Calendar.DAY_OF_WEEK);
		 int groups=Integer.parseInt(group);
		 try{
		 switch(groups){
		 	case 1:
		 		myText.setText("Group "+groups);
		 		switch(day){
		 			case 1:
		 				tal.setText("5:00 am - 2:00 pm \n6:00 pm - 10:00pm");
		 				break;

		 			case 2:
		 				tal.setText("11:00 am - 7:00 pm");
		 				break;

		 			case 3:
		 				tal.setText("3:00 am - 10:00 am\n2:00 pm - 8:00pm");
		 				break;

		 			case 4:
		 				tal.setText("6:00 am - 3:00 pm\n7:00 pm - 11:00 pm");
		 				break;

		 			case 5:
		 				tal.setText("10:00 am - 4:00 pm\n8:00 pm-11:59 pm");
		 				break;

		 			case 6:
		 				tal.setText("4:00 am - 12:00 om\n4:00 pm - 10:00 pm");
		 				break;

		 			case 7:
		 				tal.setText("4:00 am - 11:00 am\n3:00 pm - 9:00 pm");
		 				break;
		 		}
		 		break;
		 	case 2:
		 		myText.setText("Group "+groups);
		 		switch(day){
	 		

	 			case 3:
	 				tal.setText("11:00 am - 7:00 pm");
	 				break;

	 			case 4:
	 				tal.setText("3:00 am - 10:00 am\n2:00 pm - 8:00pm");
	 				break;

	 			case 5:
	 				tal.setText("6:00 am - 3:00 pm\n7:00 pm - 11:00 pm");
	 				break;

	 			case 6:
	 				tal.setText("10:00 am - 4:00 pm\n8:00 pm-11:59 pm");
	 				break;

	 			case 7:
	 				tal.setText("4:00 am - 12:00 om\n4:00 pm - 10:00 pm");
	 				break;

	 			case 1:
	 				tal.setText("4:00 am - 11:00 am\n3:00 pm - 9:00 pm");
	 				break;
	 			case 2:
	 				tal.setText("5:00 am - 2:00 pm \n6:00 pm - 10:00pm");
	 				break;
		 		}
			 	break;
		 	case 3:
		 		myText.setText("Group "+groups);
		 		switch(day){
	 			case 3:
	 				tal.setText("5:00 am - 2:00 pm \n6:00 pm - 10:00pm");
	 				break;

	 			case 4:
	 				tal.setText("11:00 am - 7:00 pm");
	 				break;

	 			case 5:
	 				tal.setText("3:00 am - 10:00 am\n2:00 pm - 8:00pm");
	 				break;

	 			case 6:
	 				tal.setText("6:00 am - 3:00 pm\n7:00 pm - 11:00 pm");
	 				break;

	 			case 7:
	 				tal.setText("10:00 am - 4:00 pm\n8:00 pm-11:59 pm");
	 				break;

	 			case 1:
	 				tal.setText("4:00 am - 12:00 om\n4:00 pm - 10:00 pm");
	 				break;

	 			case 2:
	 				tal.setText("4:00 am - 11:00 am\n3:00 pm - 9:00 pm");
	 				break;
	 		}
			 	break;
		 	case 4:
		 		myText.setText("Group "+groups);
		 		switch(day){
	 			case 4:
	 				tal.setText("5:00 am - 2:00 pm \n6:00 pm - 10:00pm");
	 				break;

	 			case 5:
	 				tal.setText("11:00 am - 7:00 pm");
	 				break;

	 			case 6:
	 				tal.setText("3:00 am - 10:00 am\n2:00 pm - 8:00pm");
	 				break;

	 			case 7:
	 				tal.setText("6:00 am - 3:00 pm\n7:00 pm - 11:00 pm");
	 				break;

	 			case 1:
	 				tal.setText("10:00 am - 4:00 pm\n8:00 pm-11:59 pm");
	 				break;

	 			case 2:
	 				tal.setText("4:00 am - 12:00 om\n4:00 pm - 10:00 pm");
	 				break;

	 			case 3:
	 				tal.setText("4:00 am - 11:00 am\n3:00 pm - 9:00 pm");
	 				break;
	 		}
			 	break;
		 	case 5:
		 		myText.setText("Group "+groups);
		 		switch(day){
	 			case 5:
	 				tal.setText("5:00 am - 2:00 pm \n6:00 pm - 10:00pm");
	 				break;

	 			case 6:
	 				tal.setText("11:00 am - 7:00 pm");
	 				break;

	 			case 7:
	 				tal.setText("3:00 am - 10:00 am\n2:00 pm - 8:00pm");
	 				break;

	 			case 1:
	 				tal.setText("6:00 am - 3:00 pm\n7:00 pm - 11:00 pm");
	 				break;

	 			case 2:
	 				tal.setText("10:00 am - 4:00 pm\n8:00 pm-11:59 pm");
	 				break;

	 			case 3:
	 				tal.setText("4:00 am - 12:00 om\n4:00 pm - 10:00 pm");
	 				break;

	 			case 4:
	 				tal.setText("4:00 am - 11:00 am\n3:00 pm - 9:00 pm");
	 				break;
	 		}
			 	break;
		 	case 6:
		 		myText.setText("Group "+groups);
		 		switch(day){
	 			case 6:
	 				tal.setText("5:00 am - 2:00 pm \n6:00 pm - 10:00pm");
	 				break;

	 			case 7:
	 				tal.setText("11:00 am - 7:00 pm");
	 				break;

	 			case 1:
	 				tal.setText("3:00 am - 10:00 am\n2:00 pm - 8:00pm");
	 				break;

	 			case 2:
	 				tal.setText("6:00 am - 3:00 pm\n7:00 pm - 11:00 pm");
	 				break;

	 			case 3:
	 				tal.setText("10:00 am - 4:00 pm\n8:00 pm-11:59 pm");
	 				break;

	 			case 4:
	 				tal.setText("4:00 am - 12:00 om\n4:00 pm - 10:00 pm");
	 				break;

	 			case 5:
	 				tal.setText("4:00 am - 11:00 am\n3:00 pm - 9:00 pm");
	 				break;
	 		}
			 	break;
		 	case 7:
		 		myText.setText("Group "+groups);
		 		switch(day){
	 			case 7:
	 				tal.setText("5:00 am - 2:00 pm \n6:00 pm - 10:00pm");
	 				break;

	 			case 1:
	 				tal.setText("11:00 am - 7:00 pm");
	 				break;

	 			case 2:
	 				tal.setText("3:00 am - 10:00 am\n2:00 pm - 8:00pm");
	 				break;

	 			case 3:
	 				tal.setText("6:00 am - 3:00 pm\n7:00 pm - 11:00 pm");
	 				break;

	 			case 4:
	 				tal.setText("10:00 am - 4:00 pm\n8:00 pm-11:59 pm");
	 				break;

	 			case 5:
	 				tal.setText("4:00 am - 12:00 om\n4:00 pm - 10:00 pm");
	 				break;

	 			case 6:
	 				tal.setText("4:00 am - 11:00 am\n3:00 pm - 9:00 pm");
	 				break;
	 		}
			 	break;
		 }}catch(Exception err){
			 Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_LONG).show();
		 }
	 }
	
		
	}
