package com.appliaction.fblogin;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    WebView view;
    Button korea, china;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        korea = (Button) findViewById(R.id.korea);
        china = (Button) findViewById(R.id.china);
        korea.setOnClickListener(this);
        china.setOnClickListener(this);
        view = (WebView) findViewById(R.id.web);
        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setTextZoom(100);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.china) {
            view.loadUrl("http://tang.csair.com/EN/WebFace/Tang.WebFace.Cargo/AgentAwbBrower.aspx");
        } else if (id == R.id.korea) {
            view.loadUrl("http://cargo.koreanair.com/eng/main/iMain.jsp#div_1");
        }
    }
}
