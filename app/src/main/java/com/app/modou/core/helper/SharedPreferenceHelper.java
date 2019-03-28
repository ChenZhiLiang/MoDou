package com.app.modou.core.helper;

import android.content.Context;
import android.util.Base64;

import com.app.modou.confing.AppConfig;
import com.app.modou.ui.bean.UserInfoBean;
import com.yobo.third_sdk.utils.PreferenceHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/9.
 * 获取 SharedPreferences 的数据.
 */

public class SharedPreferenceHelper {

    /**
     * 设置用户信息 UserInfo
     *
     * @param context
     * @param user
     */
    public static void setUserInfo(Context context, UserInfoBean user) {
        if (user instanceof Serializable) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(user);//把对象写到流里
                String temp = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
                PreferenceHelper.write(context, AppConfig.TOKEN_FILE_NAME, AppConfig.USER_INFO, temp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取用户信息
     * @param context
     * @return
     */
    public static UserInfoBean getUserInfo(Context context) {
        String user = PreferenceHelper.readString(context,AppConfig.TOKEN_FILE_NAME,AppConfig.USER_INFO);
        if (user!=null){
            ByteArrayInputStream bais =  new ByteArrayInputStream(Base64.decode(user.getBytes(), Base64.DEFAULT));
            UserInfoBean user_info = null;
            try {
                ObjectInputStream ois = new ObjectInputStream(bais);
                user_info = (UserInfoBean) ois.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return user_info;
        }else {
            return null;
        }
    }

    /**
     * 清除 Token
     *
     * @param context 上下文
     */
    public static void clearShared(Context context) {
        //清除用户信息
        PreferenceHelper.remove(context, AppConfig.TOKEN_FILE_NAME, AppConfig.USER_INFO);

    }
}
