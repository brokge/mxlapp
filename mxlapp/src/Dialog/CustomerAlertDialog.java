package Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.mxl.mxlapp.R;

public class CustomerAlertDialog extends Dialog {
    Context mContext;
    Button btnok;
    Button btncancel;

    TextView messageTextView;
    TextView titleTextView;

    String messageString = "消息控件";

    // CustomerDialogInterface customerDialogInterface;
    protected CustomerAlertDialog(Context context) {
        super(context);
        mContext = context;
        // TODO Auto-generated constructor stub
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public CustomerAlertDialog(Context context, int theme, int displaypar) {
        super(context, theme);
        // TODO Auto-generated constructor stub
        mContext = context;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    /*	*/
    }

    public void setokOnClick(String text, android.view.View.OnClickListener onClickListener) {
        btnok.setText(text);
        btnok.setOnClickListener(onClickListener);
    }

    public void setCancelOnClick(String text,android.view.View.OnClickListener onClickListener) {
        btncancel.setText(text);
        btncancel.setOnClickListener(onClickListener);
    }

    /*
     * (non-Javadoc)
     *
     * @see android.app.Dialog#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.customer_alertdialog);
        // TODO Auto-generated method stub
    /*    LinearLayout parentLayout = (LinearLayout) this.findViewById(R.id.customer_dialog_parent);
        int width = mContext.getDisplayWidth() - 20;
        ViewGroup.LayoutParams lps = parentLayout.getLayoutParams();
        lps.width = width;
        parentLayout.setLayoutParams(lps);*/
		/*Window window = this.getWindow();
		LayoutParams lpLayoutParams = new LayoutParams();
	
		lpLayoutParams.width =LayoutParams.MATCH_PARENT;
		lpLayoutParams.height =LayoutParams.WRAP_CONTENT;
		lpLayoutParams.gravity = Gravity.FILL_HORIZONTAL;
		
		//lpLayoutParams.horizontalMargin=10;
		window.setAttributes(lpLayoutParams);*/

        btnok = (Button) this.findViewById(R.id.customer_alertdialog_ok);
        btncancel = (Button) this
                .findViewById(R.id.customer_alertdialog_cancel);
        messageTextView = (TextView) this
                .findViewById(R.id.customer_reg_message);
        titleTextView = (TextView) this.findViewById(R.id.customer_title);


}


    /**
     * 设置消息内容
     *
     * @param message
     */
    public void setMessage(String message) {
        if (messageTextView.getVisibility() == View.VISIBLE) {
            messageTextView.setText(message);
        }
    }

    /**
     * 这只消息标题
     *
     * @param title
     */
    public void setTitle(String title) {
        if (titleTextView.getVisibility() == View.VISIBLE) {
            titleTextView.setText(title);
        }
    }




}
