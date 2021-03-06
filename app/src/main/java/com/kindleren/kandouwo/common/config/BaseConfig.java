package com.kindleren.kandouwo.common.config;

import android.content.Context;
import android.util.DisplayMetrics;

//import com.sankuai.common.utils.Utils;


/**
 * Created by foxcoder on 14-9-17.
 */
public class BaseConfig {

    public static int width;
    public static int height;
    public static float density;
    public static int densityDpi;
    private static boolean displayInited;
    // DEVICE_ID 默认为15个零，每台机器都不一样。
    public static String deviceId = "000000000000000";

    public static void initDisplay(Context context) {
        if ((!displayInited) && (context.getResources() != null)) {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            width = metrics.widthPixels;
            height = metrics.heightPixels;
            density = metrics.density;
            densityDpi = metrics.densityDpi;
            displayInited = true;
        }
//        deviceId = Utils.getDeviceId(context);
    }

    public static int dp2px(int dp) {
        return (int) (dp * density);
    }
}
