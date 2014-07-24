package com.mxl.mxlapp;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		// 在使�?SDK 各组间之前初始化 context 信息，传�?ApplicationContext
		SDKInitializer.initialize(this);
	}

}