package com.appliaction.thebachelors;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appliaction.thebachelors.Tabs.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar appBar;
    DrawerLayout dLayout;

    SlidingTabLayout mTabs;
    ViewPager mPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appBar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(appBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        navigationBar drawerFragment = (navigationBar) getSupportFragmentManager().findFragmentById(R.id.navigationDrawer);
        dLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerFragment.setUp(dLayout, appBar);

        mTabs = (SlidingTabLayout) findViewById(R.id.myTabs);
        mPage = (ViewPager) findViewById(R.id.myViewPager);
        mPage.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        mTabs.setViewPager(mPage);
    }

    public class MyPageAdapter extends FragmentPagerAdapter {
    String[] tabs;
        public MyPageAdapter(FragmentManager fm) {
            super(fm);
            tabs=getResources().getStringArray(R.array.tribhuwan);
        }

        @Override
        public Fragment getItem(int position) {
            MyFragment frag=MyFragment.getInstance(position);
            return frag;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public static class MyFragment extends Fragment {
        public static MyFragment getInstance(int position){
            MyFragment frag=new MyFragment();
            frag.setArguments(new Bundle());
            return frag;
        }
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View myView = inflater.inflate(R.layout.fragment_tribhuwan, container, false);
            return myView;
        }
    }
}
