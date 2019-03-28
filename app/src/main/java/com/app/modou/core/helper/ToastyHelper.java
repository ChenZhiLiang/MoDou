package com.app.modou.core.helper;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.yobo.third_sdk.view.toasty.Toasty;

/**
 * Created by Administrator on 2017-11-06.
 * 二次封装Toasty
 */

public class ToastyHelper {

    /**
     * 显示错误信息的Toast:
     * @param activity
     * @param msg
     */
     public static void toastyError(Activity activity, String msg){
         Toasty.error(activity, msg, Toast.LENGTH_SHORT, true).show();
     }

    /**
     * 显示成功的Toast::
     * @param activity
     * @param msg
     */
    public static void toastySuccess(Activity activity,String msg){
        Toasty.success(activity, msg, Toast.LENGTH_SHORT, true).show();
    }

    /**
     * 显示info的Toast::
     * @param activity
     * @param msg
     */
    public static void toastyInfo(Activity activity,String msg){
        Toasty.info(activity, msg, Toast.LENGTH_SHORT, true).show();
    }

    /**
     * 显示警告的:
     * @param activity
     * @param msg
     */
    public static void toastyWarning(Activity activity,String msg){
        Toasty.warning(activity, msg, Toast.LENGTH_SHORT, true).show();
    }

    /**
     * 显示常规的:
     * @param activity
     * @param msg
     */
    public static void toastyNormal(Activity activity,String msg){
        Toasty.normal(activity, msg).show();
    }
}
