package com.mobile.app.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    public static class PlaceholderFragment extends Fragment {
        HttpURLConnection urlConnection;
        InputStream im;
        String[] forecast = {"Todat-sunny", "Todat-sunny", "Todat-sunny"};

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, forecast);

            View v = inflater.inflate(R.layout.fragment_main, container, false);
            ListView vi = (ListView) v.findViewById(R.id.listview_forecast);
            vi.setAdapter(arrayAdapter);

            try {
                URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/city?id=1283240&APPID=3d67131c0ffbf0aca52a6e0e0c9f2056");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(15000);
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                StringBuilder sB = new StringBuilder();
                InputStream stream = urlConnection.getInputStream();
                BufferedReader read = new BufferedReader(new InputStreamReader(stream));
                String line;
                while ((line = read.readLine()) != null) {
                    sB.append(line).append("\n");
                }
            } catch (Exception err) {
                Log.v("Eroor", err.getMessage() + " Is making error");
            }
            return v;
        }
    }
}
