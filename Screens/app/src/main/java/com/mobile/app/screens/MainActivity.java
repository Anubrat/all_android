package com.mobile.app.screens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    ImageView view;
    EditText text1, text2;
    final String TEXT1VAL = "text1";
    final String TEXT2VAL = "text2";

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        text1 = (EditText) findViewById(R.id.editText);
        text2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);
        view = (ImageView) findViewById(R.id.images);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 100);
            }
        });
        if(savedInstanceState!=null){
            text1.setText(savedInstanceState.getInt(TEXT1VAL));
            text2.setText(savedInstanceState.getInt(TEXT2VAL));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bm = (Bitmap) extras.get("data");
            view.setImageBitmap(bm);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(TEXT1VAL, text1.getText().toString());
        savedInstanceState.putString(TEXT2VAL, text2.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }
}
