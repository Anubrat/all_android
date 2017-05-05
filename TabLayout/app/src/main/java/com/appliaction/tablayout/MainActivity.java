package com.appliaction.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {
    ViewPager page;
    PagerTitleStrip title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page=(ViewPager)findViewById(R.id.viewpager);
        title=(PagerTitleStrip)findViewById(R.id.titles);
        page.setAdapter(new CustomAdapter(getSupportFragmentManager()));

    }

    public class CustomAdapter extends FragmentPagerAdapter{
        String[] title={"Title 1", "Title 2"};
        public CustomAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return new FragmentA();
            }else if(position==1){
                return new FragmentA();
            }
                return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
