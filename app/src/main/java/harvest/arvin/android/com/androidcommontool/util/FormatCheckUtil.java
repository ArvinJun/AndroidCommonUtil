package harvest.arvin.android.com.androidcommontool.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*@author arvin
*@date 2017/9/29
*@describe  正则表达式
*@name FormatCheckUtil
*/


public class FormatCheckUtil {

    public static final String REGEX_ID_CARD18     = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9Xx])$";

    /**检测是否为手机号码
     * */
    public static boolean isMobileNumber(String mobiles) {
        Pattern p = Pattern.compile("^[1]+\\d{10}$");         //高文鹏：手机号码只限定为1开头，不对第二个数做限定
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


    /**检测是否为座机号码
     * */
    public static boolean isDeskPhone(String phoneNum){
        Pattern p = Pattern.compile("^([0-9]{3,4})?[0-9]{7,8}$");         //高文鹏：手机号码只限定为1开头，不对第二个数做限定
        Matcher m = p.matcher(phoneNum);
        return m.matches();
    }


    /**检测是否为邮箱
     * **/
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**检查是否为身份证号码
     * */
    public static boolean isCardNo(String carNo) {
        return isMatch(REGEX_ID_CARD18, carNo);
    }

    public static boolean isMatch(String regex, CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }
}
