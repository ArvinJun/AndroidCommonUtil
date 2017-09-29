package harvest.arvin.android.com.androidcommontool.util;

import android.content.Context;
import android.util.TypedValue;

/**
*@author arvin
*@date 2017/9/29
*@describe TO DO
*@name DensityUtils
*/


public class DensityUtils {
    /**
     * dp2px
     *
     */
    public static int dp2px(Context context, float dp)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, context.getResources().getDisplayMetrics());
    }

    /**
     * sp2px
     *
     */
    public static int sp2px(Context context, float sp)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp, context.getResources().getDisplayMetrics());
    }

    /**
     * px2dp
     *
     * @return
     */
    public static float px2dp(Context context, float px)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (px / scale);
    }

    /**
     * px2sp
     *
     * @param
     * @param px
     * @return
     */
    public static float px2sp(Context context, float px)
    {
        return (px / context.getResources().getDisplayMetrics().scaledDensity);
    }

}
