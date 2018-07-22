package com.example.android.myview;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class VerticleViewPagerActivity extends AppCompatActivity {

    VerticalViewPager verticalViewPager;
    ArrayList<String> uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        uri=new ArrayList<>();
        loadData();
        verticalViewPager = (VerticalViewPager) findViewById(R.id.verticleViewPager);
        verticalViewPager.setAdapter(new VerticlePagerAdapter(this,uri));
    }
    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("uri list", null);
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        uri = gson.fromJson(json, type);
        if (uri == null) {
            uri = new ArrayList<>();
        }

    }
}