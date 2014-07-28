package com.mxl.mxlapp;

import android.app.Activity;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.OnGestureListener;
import android.widget.Toast;

/**
 * Email:chenlw@dxyer.com
 * Created by User:陈林伟 on 2014/7/28.
 */
public class GestureActivity extends Activity implements OnGestureListener {
    public String TAG = this.getClass().getName();


    private static final int FLING_MIN_DISTANCE = 300;
    private static final double SIN45_VALUE=0.7071067811865475;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGestureDetector = new GestureDetector(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        mGestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(this, "长按的操作", 1).show();

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float xLength = Math.abs(e1.getX() - e2.getX());//x绝对值
        float yLength = Math.abs(e1.getY() - e2.getY());//y绝对值
        double mLength = Math.sqrt(xLength * xLength + yLength * yLength);//斜边长度
        double aAngle = yLength / mLength;
      /*  ∠A+∠B=90°
        sinA=∠A的对边/斜边
        cosA=∠A的邻边/斜边
        tanA=∠A的对边/∠A的邻边
        cotA=∠A的邻边/∠A的对边
        例：角A等于30°，角A的对边是4米，计算斜边C是多少？
        查表sin30°=0.5，斜边C=4/0.5=8米*/
        // double aAngle=Math.asin(yLength/mLength);
        // double aAngle1=Math.sin(yLength/mLength);
        // Log.i(TAG,yLength/mLength+"asin"+aAngle);
        // Log.i(TAG,yLength/mLength+"aAngle1"+aAngle1);
        if (aAngle <= SIN45_VALUE) {
            //Toast.makeText(this,aAngle+"",1).show();
            if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > 0) {
                Toast.makeText(this,aAngle+"向左边移动",0).show();

            } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > 0) {
                Toast.makeText(this,aAngle+"向右边移动",0).show();
            }
        }
        else
        {
            if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE && Math.abs(velocityX) > 0) {
                Toast.makeText(this,aAngle+"向上边移动",0).show();

            } else if (e2.getY() - e1.getY() > FLING_MIN_DISTANCE && Math.abs(velocityX) > 0) {
                Toast.makeText(this,aAngle+"向下边移动",0).show();
            }
        }
        return false;
    }
}
