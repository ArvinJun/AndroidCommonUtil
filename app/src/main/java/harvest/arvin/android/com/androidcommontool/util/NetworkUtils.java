package harvest.arvin.android.com.androidcommontool.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * Created by oeasy on 2017/9/29.
 */
public class NetworkUtils {

    /***
     * network util
     * you should add some Permission {<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />  android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE} in AndroidManifest.xml
     **/
    public static final String TAG = "NetworkUtils";


    /** Unknown network class. */
    private static final int NETWORK_CLASS_UNKNOWN = 0;
    /** Class of broadly defined "2G" networks. */
    private static final int NETWORK_CLASS_2_G = 1;
    /** Class of broadly defined "3G" networks. */
    private static final int NETWORK_CLASS_3_G = 2;
    /** Class of broadly defined "4G" networks. */
    private static final int NETWORK_CLASS_4_G = 3;

    /** Network type is unknown */
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    /** Current network is GPRS */
    public static final int NETWORK_TYPE_GPRS = 1;
    /** Current network is EDGE */
    public static final int NETWORK_TYPE_EDGE = 2;
    /** Current network is UMTS */
    public static final int NETWORK_TYPE_UMTS = 3;
    /** Current network is CDMA: Either IS95A or IS95B*/
    public static final int NETWORK_TYPE_CDMA = 4;
    /** Current network is EVDO revision 0*/
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    /** Current network is EVDO revision A*/
    public static final int NETWORK_TYPE_EVDO_A = 6;
    /** Current network is 1xRTT*/
    public static final int NETWORK_TYPE_1xRTT = 7;
    /** Current network is HSDPA */
    public static final int NETWORK_TYPE_HSDPA = 8;
    /** Current network is HSUPA */
    public static final int NETWORK_TYPE_HSUPA = 9;
    /** Current network is HSPA */
    public static final int NETWORK_TYPE_HSPA = 10;
    /** Current network is iDen */
    public static final int NETWORK_TYPE_IDEN = 11;
    /** Current network is EVDO revision B*/
    public static final int NETWORK_TYPE_EVDO_B = 12;
    /** Current network is LTE */
    public static final int NETWORK_TYPE_LTE = 13;
    /** Current network is eHRPD */
    public static final int NETWORK_TYPE_EHRPD = 14;
    /** Current network is HSPA+ */
    public static final int NETWORK_TYPE_HSPAP = 15;
    /** Current network is GSM */
    public static final int NETWORK_TYPE_GSM = 16;
    /** Current network is TD_SCDMA */
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    /** Current network is IWLAN */
    public static final int NETWORK_TYPE_IWLAN = 18;
    /** Current network is LTE_CA  */
    public static final int NETWORK_TYPE_LTE_CA = 19;
    /**
     *  to get wifi or mobile net is enable
     *
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity == null) {
            LogUtils.e(TAG, "couldn't get connectivity manager");
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].isAvailable()) {
                        return true;
                    }
                }
            }
        }
        LogUtils.d(TAG, "network is not available");
        return false;
    }

    /**
     *  wifi or mobile net is connected or not
     * */
    public static boolean isNetWorkConnected(Context context) {
        boolean isConnected = false;
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        isConnected = true;
                        break;
                    }
                }
            }
        }
        return isConnected;
    }


    /**
     *mobile net is connected or not
     *
     */
    public static boolean  getMobileNetState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean  mobileNetConnectState= connectivityManager.getNetworkInfo(
                ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();

        return mobileNetConnectState;
    }


    /**
     * wifi is connected or not
     *
     */
    public static boolean  getWifiState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean wifiConnectState  = connectivityManager.getNetworkInfo(
                ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        return wifiConnectState;
    }


    /**
     * wifi 2g 3g 4g
     * get current net is wifi or mobile net
     * */
    public static int getNetworkConnectType(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo.State state = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        if(state == NetworkInfo.State.CONNECTED||state == NetworkInfo.State.CONNECTING){
            return  ConnectivityManager.TYPE_WIFI;
        }

        state = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        if(state == NetworkInfo.State.CONNECTED||state == NetworkInfo.State.CONNECTING){
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(
                            Context.TELEPHONY_SERVICE);
            return getMobileNetworkType(telephonyManager.getNetworkType());
        }
        return NETWORK_CLASS_UNKNOWN;
    }



    public static int getMobileNetworkType(int networkType) {
        switch (networkType) {
            case NETWORK_TYPE_GPRS:
            case NETWORK_TYPE_GSM:
            case  NETWORK_TYPE_EDGE:
            case NETWORK_TYPE_CDMA:
            case  NETWORK_TYPE_1xRTT:
            case NETWORK_TYPE_IDEN:
                return NETWORK_CLASS_2_G;
            case  NETWORK_TYPE_UMTS:
            case NETWORK_TYPE_EVDO_0:
            case  NETWORK_TYPE_EVDO_A:
            case NETWORK_TYPE_HSDPA:
            case NETWORK_TYPE_HSUPA:
            case  NETWORK_TYPE_HSPA:
            case  NETWORK_TYPE_EVDO_B:
            case  NETWORK_TYPE_EHRPD:
            case  NETWORK_TYPE_HSPAP:
            case  NETWORK_TYPE_TD_SCDMA:
                return NETWORK_CLASS_3_G;
            case  NETWORK_TYPE_LTE:
            case NETWORK_TYPE_IWLAN:
            case NETWORK_TYPE_LTE_CA:
                return NETWORK_CLASS_4_G;
            default:
                return NETWORK_CLASS_UNKNOWN;
        }
    }


    /**
     * is used get china  international mobile subscriber identity
     * */
    public static String getSIMOperatorName(Context context) {
        String  operatorName = "未知";
        try {
            TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
            String IMSI = telephonyManager.getSubscriberId();
            if (IMSI == null) {
                if (TelephonyManager.SIM_STATE_READY == telephonyManager
                        .getSimState()) {
                    String operator = telephonyManager.getSimOperator();
                    if (operator != null) {
                        if (operator.equals("46000")
                                || operator.equals("46002")
                                || operator.equals("46007")) {
                            operatorName = "中国移动";
                        } else if (operator.equals("46001")) {
                            operatorName = "中国联通";
                        } else if (operator.equals("46003")) {
                            operatorName = "中国电信";
                        }
                    }
                }
            } else {
                if (IMSI.startsWith("46000") || IMSI.startsWith("46002")
                        || IMSI.startsWith("46007")) {
                    operatorName = "中国移动";
                } else if (IMSI.startsWith("46001")) {
                    operatorName = "中国联通";
                } else if (IMSI.startsWith("46003")) {
                    operatorName = "中国电信";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operatorName;
    }
}
