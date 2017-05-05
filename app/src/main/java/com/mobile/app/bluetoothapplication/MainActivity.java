package com.mobile.app.bluetoothapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button click, save;
    ImageView image;
    EditText text;
    public final int CAMERA_ID = 100;
    public final int GALLERY_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity act = (MainActivity) getLastCustomNonConfigurationInstance();
        click = (Button) findViewById(R.id.image);
        save = (Button) findViewById(R.id.save);
        image = (ImageView) findViewById(R.id.imageView);
        text = (EditText) findViewById(R.id.editText);
        click.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Get Image through");
                alert.setPositiveButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, CAMERA_ID);
                    }
                });
                alert.setNegativeButton("Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent, GALLERY_ID);
                    }
                });
                alert.show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_ID) {
            Bundle extras = data.getExtras();
            Bitmap images = (Bitmap) extras.get("data");
            image.setImageBitmap(images);
        } else if (requestCode == GALLERY_ID) {
            Uri img = data.getData();
            image.setImageURI(img);
        }
    }
}