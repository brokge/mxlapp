package Dialog;


import Interface.Fragment_Dialog_Listener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.mxl.mxlapp.R;

/**
 * Email:chenlw@dxyer.com
 * Created by User:陈林伟 on 2014/6/27.
 */
public class MyFragmentDialog extends DialogFragment {
    protected final String TAG =getArguments().getClass().getName();
    private String title=null;
    private String date=null;
    private String lx=null;
    private Fragment_Dialog_Listener dismissListener=null;

    public static MyFragmentDialog newInstance() {
        return new MyFragmentDialog();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context=getActivity();
        LayoutInflater inflater=getActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);

        View v=inflater.inflate(R.layout.fragment_dialog, (ViewGroup)((Activity) context).findViewById(R.id.dialog_string));
        final EditText editText=(EditText) v.findViewById(R.id.dialog_string_edittext);
        editText.setText(date);

        builder.setView(v);

        builder.setPositiveButton("确认",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                        date=editText.getText().toString();
                        close(true);

                    }
                });
        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                        close(false);// 删除
                    }
                });
        Dialog dialog = builder.create();
       // logh.d(TAG);
        return dialog;
    }

    public void setDismissListener(Fragment_Dialog_Listener dismissListener) {
        this.dismissListener=dismissListener;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    private void close(boolean isupdate) {
        // TODO Auto-generated method stub
        Bundle args=new Bundle();
        args.putBoolean("result", isupdate);
        args.putString("lx", lx);
        args.putString("date", date);
        MyFragmentDialog.this.dismiss();
        dismissListener.onFragment_Dialog_Listener(args);
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
