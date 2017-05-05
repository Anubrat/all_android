package com.appliaction.thebachelors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.appliaction.thebachelors.Tabs.VivzAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class navigationBar extends Fragment {
    public ListView listView;
    private VivzAdapter adapter;
    private RecyclerView recyclerView;
    ActionBarDrawerToggle toggle;
    DrawerLayout dlout;
    Toolbar tbs;

    public navigationBar() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFrag = inflater.inflate(R.layout.fragment_navigation_bar, container, false);
        recyclerView = (RecyclerView) myFrag.findViewById(R.id.drawerList);
        adapter = new VivzAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return myFrag;
    }

    public static List<Information> getData() {
        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.bulb_off, R.drawable.bulb_off, R.drawable.bulb_off};
        String[] title = {"Viv", "sd", "sdf"};
        for (int i = 0; i < title.length & i < icons.length; i++) {
            Information current = new Information();
            current.iconId = icons[i];
            current.title = title[i];
            data.add(current);
        }
        return data;
    }

    public void setUp(DrawerLayout dl, Toolbar tb) {
        dlout = dl;
        tbs = tb;
        toggle = new ActionBarDrawerToggle(getActivity(), dl, tb, R.string.Open, R.string.Close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset < 0.6)
                    tbs.setAlpha(1 - slideOffset);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        dl.setDrawerListener(toggle);
        dl.post(new Runnable() {
            @Override
            public void run() {
                toggle.syncState();
            }
        });
    }
}



