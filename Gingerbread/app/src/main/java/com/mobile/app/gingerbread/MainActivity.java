package com.mobile.app.gingerbread;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.light);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startServices();
            }
        });
    }

    private void startServices() {
        Toast.makeText(getApplicationContext(), "SDF", Toast.LENGTH_LONG).show();
        Intent inte = new Intent(this, MyClass.class);
        startService(inte);
    }

}