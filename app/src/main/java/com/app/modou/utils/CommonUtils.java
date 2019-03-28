package com.app.modou.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: CommonUtils
 * @Description: 公共工具类
 * @CreateDate: 2019/3/25 17:30
 * @Version: 1.0
 */
public class CommonUtils {

    /**
     * 输出（"2014-06-14  16:09:00"）
     * @return 获取当前时间
     */
    public static String PresentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new java.util.Date());
        return date;
    }
}
