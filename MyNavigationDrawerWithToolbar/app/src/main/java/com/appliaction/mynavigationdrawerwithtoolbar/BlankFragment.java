package com.appliaction.mynavigationdrawerwithtoolbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BlankFragment extends Fragment {
    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayouts;

    public BlankFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }


    public void setUp(DrawerLayout drawerLayout, Toolbar bar) {
        drawerLayouts=drawerLayout;
        drawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,bar,R.string.Open,R.string.Close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };
        drawerLayouts.setDrawerListener(drawerToggle);
        drawerLayouts.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });
    }

}