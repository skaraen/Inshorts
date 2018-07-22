package com.example.android.myview;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class VerticlePagerAdapter extends PagerAdapter {

ArrayList<String> uris;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public VerticlePagerAdapter(Context context,ArrayList<String> uri) {
        mContext = context;
        this.uris=uri;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return uris.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView;
        View itemView = mLayoutInflater.inflate(R.layout.content_main, container, false);
        imageView=itemView.findViewById(R.id.imageView);
        imageView.setImageURI(Uri.parse(uris.get(position)));
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}