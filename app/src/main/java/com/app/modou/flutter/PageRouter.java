package com.app.modou.flutter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.app.modou.ui.activity.home.PublicReapairActivity;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: PageRouter
 * @Description: 描述
 * @CreateDate: 2019/3/18 18:33
 * @Version: 1.0
 */
public class PageRouter {

    public static final String NATIVE_PAGE_URL = "flutter:publicReapir";
    public static final String FLUTTER_PAGE_URL = "sample://flutterPage";
    public static final String FLUTTER_FRAGMENT_PAGE_URL = "sample://flutterFragmentPage";

    public static boolean openPageByUrl(Context context, String url) {
        return openPageByUrl(context, url, 0);
    }

    public static boolean openPageByUrl(Context context, String url, int requestCode) {
        try {
            if (TextUtils.equals(url, FLUTTER_PAGE_URL)) {
                context.startActivity(new Intent(context, FlutterPageActivity.class));
                return true;
            }
//            else if (TextUtils.equals(url, FLUTTER_FRAGMENT_PAGE_URL)) {
//                context.startActivity(new Intent(context, FlutterFragmentPageActivity.class));
//                return true;
//            }
            else if (TextUtils.equals(url, NATIVE_PAGE_URL)) {
                context.startActivity(new Intent(context, PublicReapairActivity.class));
                return true;
            } else {
                return false;
            }
        } catch (Throwable t) {
            return false;
        }
    }
}
