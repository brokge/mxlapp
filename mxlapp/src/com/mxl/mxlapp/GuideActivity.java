package com.mxl.mxlapp;

import Adapter.ViewPagerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Email:chenlw@dxyer.com
 * Created by User:陈林伟 on 2014/7/3.
 */
public class GuideActivity extends Activity {
    private ViewPager viewPager;
    private ViewPagerAdapter vpAdapter;
    private ArrayList<View> views;
    private View view1, view2, view3, view4, view5, view6;
    private ImageView pointImage0, pointImage1, pointImage2, pointImage3, pointImage4, pointImage5;
    private Button startBt;
    private int currIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initData();
    }
    private void initView() {
        LayoutInflater mLi = LayoutInflater.from(this);
        view1 = mLi.inflate(R.layout.guide_view01, null);
        view2 = mLi.inflate(R.layout.guide_view02, null);
        view3 = mLi.inflate(R.layout.guide_view03, null);
        view4 = mLi.inflate(R.layout.guide_view04, null);
        view5 = mLi.inflate(R.layout.guide_view05, null);
        view6 = mLi.inflate(R.layout.guide_view06, null);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        views = new ArrayList<View>();
        vpAdapter = new ViewPagerAdapter(views);
        pointImage0 = (ImageView) findViewById(R.id.page0);
        pointImage1 = (ImageView) findViewById(R.id.page1);
        pointImage2 = (ImageView) findViewById(R.id.page2);
        pointImage3 = (ImageView) findViewById(R.id.page3);
        pointImage4 = (ImageView) findViewById(R.id.page4);
        pointImage5 = (ImageView) findViewById(R.id.page5);
        startBt = (Button) view6.findViewById(R.id.startBtn);
    }
    private void initData() {
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
        viewPager.setAdapter(vpAdapter);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);
        views.add(view6);
        startBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton();
            }
        });
        vpAdapter.notifyDataSetChanged();
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    pointImage0.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_focused));
                    pointImage1.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_unfocused));
                    break;
                case 1:
                    pointImage1.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_focused));
                    pointImage0.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_unfocused));
                    pointImage2.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_unfocused));
                    break;
                case 2:
                    pointImage2.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_focused));
                    pointImage1.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_unfocused));
                    pointImage3.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_unfocused));
                    break;
                case 3:
                    pointImage3.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_focused));
                    pointImage4.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_unfocused));
                    pointImage2.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_unfocused));
                    break;
                case 4:
                    pointImage4.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_focused));
                    pointImage3.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_unfocused));
                    pointImage5.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_unfocused));
                    break;
                case 5:
                    pointImage5.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_focused));
                    pointImage4.setImageDrawable(getResources().getDrawable(R.drawable.page_indicator_unfocused));
                    break;
            }
            currIndex = position;
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }
    }

    private void startButton() {
        Intent intent = new Intent();
        intent.setClass(GuideActivity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }


}
