package com.mobile.app.valuefinder2;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    TabLayout layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layouts = (TabLayout) findViewById(R.id.layouts);
        pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new CustomAdapter(getSupportFragmentManager()));
        layouts.setupWithViewPager(pager);
        layouts.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(layouts.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private class CustomAdapter extends FragmentPagerAdapter {
        String[] titles = {"Value Finder", "PVIF By Years", "PVIF By Percent","VALUE"};

        public CustomAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ValueFragment();
                case 1:
                    return new ByYears();
                case 2:
                    return new ByPercent();
                case 3:
                    return new Percent();
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_meny, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.developer) {
            Snackbar.make(findViewById(android.R.id.content), "Developed by Bibesh Manandhar", Snackbar.LENGTH_LONG).show();
        }
        return true;
    }
}
