package harvest.arvin.android.com.androidcommontool.util;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.system.Os;

import java.io.File;

/**
*@author arvin
*@date 2017/9/29
*@describe TO DO
*@name SDCardUtils
*/


public class SDCardUtils {

    private final static long SDCARD_ERROR = -1;

    /**
     * 外部存储是否可用
     * @return
     */
     public static boolean externalMemoryAvailable() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }


    /**
     * 获取手机内部可用空间大小
     * @return
     */
    static public long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize =0;
        long availableBlocks =0;
        if(Build.VERSION.SDK_INT <18){
            blockSize = stat.getBlockSize();
             availableBlocks = stat.getAvailableBlocks();
        }else{
             blockSize = stat.getBlockSizeLong();
            availableBlocks  = stat.getAvailableBlocksLong();
        }

        return availableBlocks * blockSize;
    }


    /**
     * 获取手机内部空间大小
     * @return
     */
    static public long getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = 0;
        long totalBlocks =0;
        if(Build.VERSION.SDK_INT <18){
            blockSize = stat.getBlockSize();
            totalBlocks  = stat.getBlockCount();
        }else{
            blockSize = stat.getBlockSizeLong();
            totalBlocks  = stat.getBlockCountLong();
        }

        return totalBlocks * blockSize;
    }


    /**
     * 获取手机外部可用空间大小
     * @return
     */
    static public long getAvailableExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = 0;
            long availableBlocks =0;
            if(Build.VERSION.SDK_INT <18){
                 blockSize = stat.getBlockSize();
                 availableBlocks = stat.getAvailableBlocks();
            }else{
                 blockSize = stat.getBlockSizeLong();
                 availableBlocks = stat.getAvailableBlocksLong();
            }

            return availableBlocks * blockSize;
        } else {
            return SDCARD_ERROR;
        }
    }


    /**
     * 获取手机外部空间大小
     * @return
     */
    static public long getTotalExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());

            long blockSize = 0;
            long totalBlocks =0;
            if(Build.VERSION.SDK_INT <18){
                blockSize = stat.getBlockSize();
                totalBlocks = stat.getBlockCount();
            }else{
                blockSize = stat.getBlockSizeLong();
                totalBlocks = stat.getBlockCountLong();
            }
            return totalBlocks * blockSize;
        } else {
            return SDCARD_ERROR;
        }
    }

}
