package com.mxl.mxlapp;

import Dialog.MyFragmentDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Email:chenlw@dxyer.com
 * Created by User:陈林伟 on 2014/6/27.
 */
public class TestFragment extends Fragment {
      Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MyFragmentDialog dialog = MyFragmentDialog.newInstance();
        dialog.setCancelable(false);// 设置点击屏幕Dialog不消失
        dialog.setLx("String");
        dialog.setTitle("字符串");
        dialog.setShowsDialog(true);
        dialog.setDate("20140627");
        //  dialog.setDismissListener(MainActivity.this);
        dialog.show(getFragmentManager(),"tag");

    }
}
