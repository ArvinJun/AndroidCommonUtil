package harvest.arvin.android.com.androidcommontool.util;


import android.util.Log;

/**
*@author arvin
*@date 2017/9/29
*@describe control is or not  print PROJECT  info
*@name LogUtils
*/

public class LogUtils {
    public static boolean isDebug = true;
    private static final String TAG = "LogUtils";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg){
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg){
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    public static void w(String msg) {
        if (isDebug)
            Log.w(TAG, msg);
    }


    public static void i(String tag, String msg){
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg){
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.v(tag, msg);
    }
    public static void w(String tag, String msg) {
        if (isDebug)
            Log.w(tag, msg);
    }


}
