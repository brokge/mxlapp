package com.mxl.mxlapp;

import Dialog.MyFragmentDialog;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DialerFilter;

import java.util.Date;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, LocationDemo.class);
				MainActivity.this.startActivity(intent);
			}
		});
        //FragmentDialog
        findViewById(R.id.buttonFragment).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            //TestFragment testFragment=new TestFragment();
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.buttonGesture).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GestureActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });



	}
}