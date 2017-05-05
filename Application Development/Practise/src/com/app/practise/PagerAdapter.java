package com.app.practise;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PagerAdapter extends FragmentStatePagerAdapter{
	int mNumOfTabs;
	
	public PagerAdapter(FragmentManager fm,int NumOfTabs) {
		super(fm);
		this.mNumOfTabs=NumOfTabs;
	}

	@Override
	public Fragment getItem(int arg0) {
		switch(arg0){
		case 0:
			Fragment1 tab1=new Fragment1();
			return tab1;
			
		case 1:
			Fragment1 tab2=new Fragment1();
			return tab2;
			
		case 2:
			Fragment1 tab3=new Fragment1();
			return tab3;
		
		default:
			return null;
		}
	}

	@Override
	public int getCount() {
		return mNumOfTabs;
	}

}
