package com.mxl.mxlapp;

import Dialog.CustomerAlertDialog;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.w3c.dom.Text;

/**
 * Email:chenlw@dxyer.com
 * Created by User:陈林伟 on 2014/7/1.
 */
public class DialogActivity extends Activity {
    Button buttonDialog;
    Button buttonToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        buttonDialog=(Button)this.findViewById(R.id.dialog_btn_cus);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             final CustomerAlertDialog customerAlertDialog= new CustomerAlertDialog(DialogActivity.this,R.style.dialog,0);
                customerAlertDialog.show();
                customerAlertDialog.setCanceledOnTouchOutside(false);
                customerAlertDialog.setTitle("消息提醒");
                customerAlertDialog.setMessage("大不自多,海纳江河,惟学无际,际于天地\"参观浙江大学校史馆之后内心始终萦绕着这个词和旋律，犹如晃动的海洋内心集聚了无穷的力量。\n\"厚重，深沉感由心底而生！");
                customerAlertDialog.setokOnClick("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogActivity.this,"确定按钮的操作",1).show();
                    }
                });
                customerAlertDialog.setCancelOnClick("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customerAlertDialog.dismiss();
                       // Toast.makeText(DialogActivity.this,"取消按钮的操作",1).show();
                    }
                });
            }
        });
        buttonToast=(Button)this.findViewById(R.id.dialog_btn_toast);
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cusToast();

            }
        });
        buttonToast.setLongClickable(true);
        buttonToast.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                simpleToast();
                return  true;
            }
        });




    }
        private void simpleToast()
        {
            Toast toast = Toast.makeText(getApplicationContext(),"今日首次登陆，获得妙点奖励1分",Toast.LENGTH_LONG);
            //Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER, 0, 0);
            LinearLayout toastView = (LinearLayout) toast.getView();
                   /* ImageView imageCodeProject = new ImageView(getApplicationContext());
                    imageCodeProject.setImageResource(R.drawable.ic_launcher);
                    toastView.addView(imageCodeProject, 0);*/
            TextView txtView=new TextView(getApplicationContext());
            txtView.setText("");
            txtView.setShadowLayer(2, 1, 1, Color.RED);
            toastView.addView(txtView,0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.show();
        }
    private void cusToast()
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custoast,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView txtView=(TextView)layout.findViewById(R.id.custoast_txtview);
        txtView.setText("今日首次登陆，获得妙点奖励1分");
        txtView.setShadowLayer(2, 1, 1, Color.GRAY);
        Toast toast =new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}
