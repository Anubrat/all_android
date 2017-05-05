package com.mobile.app.staggred;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    RequestQueue u;
ProgressBar bar;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button);
        bar=(ProgressBar)findViewById(R.id.progressBar);
        u = Volley.newRequestQueue(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override//http://nathmtourismfestival.com/Bank/data.php
            public void onClick(View v) {
                bar.setVisibility(View.VISIBLE);
               JsonArrayRequest value=getQueue("http://nathmtourismfestival.com/Bank/data.php");
                u.add(value);
            }
        });
    }

    private JsonArrayRequest getQueue(String s) {
        JsonArrayRequest queue = new JsonArrayRequest(Request.Method.GET, "http://nathmtourismfestival.com/Bank/data.php", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        Log.v("Values", response.getJSONObject(i).getString("Name"));
                    }
                } catch (Exception err) {
                }finally {
                    bar.setVisibility(View.GONE);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        return queue;
    }
}