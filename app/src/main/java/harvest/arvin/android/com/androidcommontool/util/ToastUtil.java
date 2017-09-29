package harvest.arvin.android.com.androidcommontool.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
*@author arvin
*@date 2017/9/29
*@describe 此处设置单例是为了防止出现多个Toast 后，toast不消失的问题
*@name ToastUtil
*/


public class ToastUtil {

    private static Toast toast = null;
    private static TextView textView = null;
    private static boolean isShowToast = false;

    private static Toast getToast(Context context) {
        //此处按自己需求变化
        if (toast == null) {
            toast = new Toast(context);
            textView = new TextView(context);
            LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            textView.setPadding(15, 15, 15, 15);
            int roundRadius = 15; // 8dp 圆角半径
            int fillColor = Color.BLACK;//内部填充颜色
            GradientDrawable gd = new GradientDrawable();//创建drawable
            gd.setColor(fillColor);
            gd.setCornerRadius(roundRadius);
            textView.setBackground(gd);
            textView.setAlpha(0.7f);
            textView.setTextColor(Color.WHITE);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(textView);
        }
        return toast;
    }

    public static void showToast(Context context, String str) {
        getToast(context);
        textView.setText(str);
        toast.show();
        isShowToast = true;
    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, CharSequence message) {
        getToast(context);
        textView.setText(message);
        toast.show();
        isShowToast = true;
    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message) {
        getToast(context);
        textView.setText(message);
        toast.show();
        isShowToast = true;
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        getToast(context);
        textView.setText(message);
        toast.show();
        isShowToast = true;
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message) {
        getToast(context);
        textView.setText(message);
        toast.show();
        isShowToast = true;
    }


    public static void cancle() {
        if (isShowToast == true) {
            if (toast != null) {
                isShowToast = false;
                toast.cancel();
                toast = null;
            }
        }
    }
}
