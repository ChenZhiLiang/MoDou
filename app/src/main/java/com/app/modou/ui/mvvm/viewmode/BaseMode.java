package com.app.modou.ui.mvvm.viewmode;


import com.app.modou.core.network.okhttp.OkHttpClientHelper;
import com.app.modou.core.network.okhttp.callback.ResultCallback;
import com.app.modou.core.network.okhttp.request.OkHttpRequest;
import com.app.modou.core.network.okhttp.request.RequestParams;

/**
 * author：chenzl
 * Create time: 2018/12/26 0026 15:57
 * describe: Mode通用
 * e_mail：chenzhiliang@guangxirenrenparking.com
 */
public class BaseMode {
    /**
     * get请求
     *
     * @param params   参数集
     * @param callback
     */
    public void GetRequest(RequestParams params, ResultCallback callback) {
        OkHttpClientHelper.call(OkHttpRequest.createGetRequest(params),callback);
    }

    /**
     * post请求
     * @param rep
     * @param callback
     */
    public void PostRequest(String rep,ResultCallback callback){
        OkHttpClientHelper.call(OkHttpRequest.createPostRequest(rep),callback);
    }

    /**
     * 上传文件
     * @param params
     * @param callback
     */
    public void MultiPostRequest( RequestParams params, ResultCallback callback) {
        OkHttpClientHelper.call(OkHttpRequest.createMultiPostRequest(params),callback);
    }
}
