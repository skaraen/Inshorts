package com.example.android.myview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SelectImageActivity extends AppCompatActivity {
Button select,view;
ArrayList<String> uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);
        uri=new ArrayList<>();
        select=findViewById(R.id.select);
        view=findViewById(R.id.view);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(pickPhoto, 10);
                }

        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SelectImageActivity.this,VerticleViewPagerActivity.class);
                startActivity(intent);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    uri.add( selectedImage.toString());
                    Toast.makeText(SelectImageActivity.this, "Image Selected to be viewed", Toast.LENGTH_SHORT).show();

                    saveData();


                    Log.e("uri"," "+uri.size());

                }
                break;
            case 11:
                if (resultCode == RESULT_OK) ;

                break;


        }
    }
    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(uri);
        editor.putString("uri list", json);
        editor.apply();

    }



}
