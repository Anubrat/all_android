package com.appliaction.mynavigationdrawerwithtoolbar;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar=(Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        BlankFragment fragment=new BlankFragment();
        fragment.setUp((DrawerLayout)findViewById(R.id.drawerLayout),myToolbar);
    }
}
