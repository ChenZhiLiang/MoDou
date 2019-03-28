package com.app.modou.core.helper;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 * 二次封装 Gson
 */

public class GsonHelper {

    private static Gson gson = null;
    static {
        if (gson == null) {
            gson = new Gson();
        }
    }
    private GsonHelper() { }
    /**
     * 转成json
     *
     * @param object
     * @return
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * 转成bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * 获取json int类型字段数据
     * @param gsonString json数据
     * @param name 字段名称
     */
    public static int GsonToInt(String gsonString,String name){
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(gsonString);
        return jsonObject.get(name).getAsInt();
    }

    /**
     * 获取json String类型字段数据
     * @param gsonString json数据
     * @param name 字段名称
     */
    public static String GsonToString(String gsonString,String name){
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(gsonString);
        return jsonObject.get(name).getAsString();
    }

    /**
     * 获取data数据
     * @param gsonString
     * @return
     */
    public static JsonObject GsonToData(String gsonString){
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(gsonString);
        return jsonObject.get("data").getAsJsonObject();
    }
    /**
     * 获取data数据 String类型字段
     * @param gsonString  DataJson数据
     * @param name 字段名称
     * @return
     */
    public static String GsonToDataJsonString(String gsonString,String name){
        return GsonToData(gsonString).get(name).getAsString();
    }

    /**
     * 获取data数据 int类型字段
     * @param gsonString
     * @param name
     * @return
     */
    public static int GsonToDataJsonInt(String gsonString,String name){
        return GsonToData(gsonString).get(name).getAsInt();
    }
    /**
     * 转成list
     * 泛型在编译期类型被擦除导致报错
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }
}
