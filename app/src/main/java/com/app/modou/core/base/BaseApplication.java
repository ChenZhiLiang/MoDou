package com.app.modou.core.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
/**
 * Created by Administrator on 2017/1/11.
 * Android Application程序的入口点基类
 */

public class BaseApplication extends Application {

    private static Context mContext;
    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        // 集成flutter 初始化
     /*   FlutterBoostPlugin.init(new IPlatform() {
            @Override
            public Application getApplication() {
                return BaseApplication.this;
            }

            *//**
             * get the main activity, this activity should always at the bottom of task stack.
             *//*
            @Override
            public Activity getMainActivity() {
                return MainActivity.sRef.get();
            }

            @Override
            public boolean isDebug() {
                return false;
            }

            *//**
             * start a new activity from flutter page, you may need a activity router.
             *//*
            @Override
            public boolean startActivity(Context context, String url, int requestCode) {
                return PageRouter.openPageByUrl(context,url,requestCode);
            }

            @Override
            public Map getSettings() {
                return null;
            }
        });*/
    }

    public static synchronized BaseApplication getContext() {
        return (BaseApplication) mContext;
    }

}
