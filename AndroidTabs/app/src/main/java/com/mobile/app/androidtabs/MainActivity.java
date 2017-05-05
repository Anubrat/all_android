package com.mobile.app.androidtabs;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    TabLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.viewPager);
        layout=(TabLayout)findViewById(R.id.tab);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        layout.setupWithViewPager(pager);
        layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        String[] a = {"hello", "world","hello", "world","hello", "world","hello", "world","hello", "world"};

        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);

        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HClass();
                case 1:
                    return new HClass();
                case 2:
                    return new HClass();
                case 3:
                    return new HClass();
                case 4:
                    return new HClass();
                case 5:
                    return new HClass();
                case 6:
                    return new HClass();
                case 7:
                    return new HClass();
                case 8:
                    return new HClass();
                case 9:
                    return new HClass();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return a[position];
        }
    }
}