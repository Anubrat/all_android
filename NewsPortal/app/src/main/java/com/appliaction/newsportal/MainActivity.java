package com.appliaction.newsportal;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView view;
    public CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(RecyclerView)findViewById(R.id.recycle);
        adapter=new CustomAdapter(MainActivity.this,getData());
        view.setAdapter(adapter);
        view.addItemDecoration(new Decorator(30));
        view.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        Snackbar.make(findViewById(android.R.id.content),"Welcome", Snackbar.LENGTH_LONG).show();

    }

    public List<Information> getData(){
        List<Information> data=new ArrayList<>();
        int[] image={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img1,R.drawable.img2,R.drawable.img3};
        String[] title={"Bibesh","Manandhar","Guitar","Bibesh","Manandhar","Guitar","Bibesh","Manandhar","Guitar","Bibesh","Manandhar","Guitar",};
        String[] heading={"Bibesh","Manandhar","Guitar","Bibesh","Manandhar","Guitar","Bibesh","Manandhar","Guitar","Bibesh","Manandhar","Guitar"} ;
        for(int i=0;i<title.length;i++){
            Information current =new Information();
            current.Image=image[i];
            current.Name=title[i];
            current.Heading=heading[i];
            data.add(current);
        }
        return data;
    }
}
