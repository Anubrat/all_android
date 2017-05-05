package com.bijuliCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class MainActivity extends Activity {
	EditText previousReading,currentReading,resultField;
    RadioGroup radioGroup;
    RadioButton b1,b2,b3,b4,b5;
    CheckBox checkYes;
    Button calculateButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 previousReading=(EditText)findViewById(R.id.previousReading);
	        currentReading=(EditText)findViewById(R.id.currentReading);
	        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
	        checkYes=(CheckBox)findViewById(R.id.day5);
	        calculateButton=(Button)findViewById(R.id.calculateButton);
	        resultField=(EditText)findViewById(R.id.resultText);
	        b1=(RadioButton)findViewById(R.id.radio5);
	        b2=(RadioButton)findViewById(R.id.radio15);
	        b3=(RadioButton)findViewById(R.id.radio30);
	        b4=(RadioButton)findViewById(R.id.radio60);
	        b5=(RadioButton)findViewById(R.id.radio3p);
	        calculateButton.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {

	                try{
	                    double amount;
	                    String totalUnits=totalUnits();
	                    if(Integer.parseInt(totalUnits)<0){
	                        Toast.makeText(getApplicationContext(),"Value Error",Toast.LENGTH_LONG).show();
	                    }else {
	                        String radioValues = radioValue();
	                        double units = calculate(totalUnits, radioValues);
	                        if (checkYes.isChecked()) {
	                            amount = units - 0.03 * units;
	                        } else {
	                            amount = units;
	                        }
	                        resultField.setText("Your total amount is Rs. "+String.valueOf(amount));
	                    }
	                }catch(Exception err){
	                    Toast.makeText(getApplicationContext(),"Value Error",Toast.LENGTH_LONG).show();
	                }

	            }
	        });
	    }
	
	    public String totalUnits(){
	        int pR=Integer.parseInt(previousReading.getText().toString());
	        int cR=Integer.parseInt(currentReading.getText().toString());
	        int unit=cR-pR;
	        String units=String.valueOf(unit);
	        return  units;
	    }

	    public String radioValue(){
	        int valueOfGroup=radioGroup.getCheckedRadioButtonId();
	        RadioButton btn1=(RadioButton)findViewById(valueOfGroup);
	        String values=btn1.getText().toString();
	        return values;
	    }

	    public double calculate(String units,String radioBtn){
	        double amount=0;
	        if(radioBtn.equals("5A")){
	        	amount=80;
	            if(Integer.parseInt(units)<=20){
	                amount=80;
	            }else if(Integer.parseInt(units)>20 && Integer.parseInt(units)<=50){
	                double b=Integer.parseInt(units)*7.30;
	                amount+=b;
	            }else if(Integer.parseInt(units)>50 && Integer.parseInt(units)<=150){
	                double b=Integer.parseInt(units)*8.6;
	                amount+=b;
	            }else if(Integer.parseInt(units)>150 && Integer.parseInt(units)<=250){
	                double b=Integer.parseInt(units)*9.5;
	                amount+=b;
	            }else if(Integer.parseInt(units)>250){
	                double b=Integer.parseInt(units)*11;
	                amount+=b;
	            }
	        }else if(radioBtn.equals("15A")){
	          amount=365;
	            if(Integer.parseInt(units)<=50){
	                amount=365;
	            }else if(Integer.parseInt(units)>50 && Integer.parseInt(units)<=150){
	                double b=Integer.parseInt(units)*8.6;
	                amount+=b;
	            }else if(Integer.parseInt(units)>150 && Integer.parseInt(units)<=250){
	                double b=Integer.parseInt(units)*9.5;
	                amount+=b;
	            }else if(Integer.parseInt(units)>250){
	                double b=Integer.parseInt(units)*11;
	                amount+=b;
	            }
	        }else if(radioBtn.equals("30A")){
	            amount=795;
	            if(Integer.parseInt(units)<=100){
	                amount=795;
	            }else if(Integer.parseInt(units)>100 && Integer.parseInt(units)<=150){
	                double b=Integer.parseInt(units)*8.6;
	                amount+=b;
	            }else if(Integer.parseInt(units)>150 && Integer.parseInt(units)<=250){
	                double b=Integer.parseInt(units)*9.5;
	                amount+=b;
	            }else if(Integer.parseInt(units)>250){
	                double b=Integer.parseInt(units)*11;
	                amount+=b;
	            }
	        }else if(radioBtn.equals("60A")){
	            amount=1765;
	            if(Integer.parseInt(units)<=200){
	                amount=1765;
	            }else if(Integer.parseInt(units)>200 && Integer.parseInt(units)<=250){
	                double b=Integer.parseInt(units)*9.5;
	                amount+=b;
	            }else if(Integer.parseInt(units)>250){
	                double b=Integer.parseInt(units)*11;
	                amount+=b;
	            }
	        }else if(radioBtn.equals("3-P")){
	            amount=4400;
	            if(Integer.parseInt(units)<400){
	                amount=3244;
	            }
	            else if(Integer.parseInt(units)>400){
	                double b=Integer.parseInt(units)*12;
	                amount+=b;
	            }
	        }
	        return amount;
	    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
