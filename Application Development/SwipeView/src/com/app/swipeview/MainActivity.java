package com.app.swipeview;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {
	PagerAdapter adap;
	ViewPager pate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		adap=new PagerAdapter(getSupportFragmentManager());
		pate=(ViewPager)findViewById(R.id.pager);
		pate.setAdapter(adap);
		final ActionBar bar=getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.TabListener listener =new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
			}
		};
		for(int i=0;i<3;i++){
			bar.addTab(bar.newTab().setText("rab "+i+1).setTabListener(listener));
		}
	}
	
	public class PagerAdapter extends FragmentStatePagerAdapter{

		public PagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			Fragment fragment=new MainFragment();
			return fragment;
		}

		@Override
		public int getCount() {
			return 100;
		}
		
		@Override
		public CharSequence getPageTitle(int position) {
			return "OBJECT "+(position+1);
		}
	}
	
	public class MainFragment extends Fragment{
		MainFragment(){
			
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			return inflater.inflate(R.layout.fragment, null);
		}
	}
}
