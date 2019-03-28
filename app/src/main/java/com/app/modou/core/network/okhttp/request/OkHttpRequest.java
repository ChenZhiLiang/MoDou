package com.app.modou.core.network.okhttp.request;

import com.app.modou.core.helper.UserHelper;
import com.app.modou.core.network.api.ApiUrl;
import com.app.modou.utils.CommonUtils;
import com.app.modou.utils.SignUtils;

import java.io.File;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author Administrator
 * @function build the request
 * 创建Request请求
 */
public class OkHttpRequest {

	/**
	 * ressemble the params to the url
	 *  Get 请求
	 * @param params 参数
	 * @return
	 */
	public static Request createGetRequest( RequestParams params) {
		String url = ApiUrl.APP_HOST;
		StringBuilder urlBuilder = new StringBuilder(url).append("?");
		if (params != null) {
			for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
				urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
			}
		}
		return new Request.Builder().url(urlBuilder.substring(0, urlBuilder.length() - 1)).get().build();
//		if (mToken == null) {
//		}else {
//			return new Request.Builder().addHeader("Authorization", "Bearer " + mToken).url(urlBuilder.substring(0, urlBuilder.length() - 1)).get().build();
//		}
	}


	/**
	 * create the key-value Request
	 * Post 请求
	 * @param req
	 * @return
	 */
	public static Request createPostRequest(String req) {
		RequestParams params = new RequestParams();
		String url = ApiUrl.APP_HOST;
		String timestamp  = CommonUtils.PresentDate();
		params.put("req",req);
		params.put("sysid", ApiUrl.sysid);//云商通分配给应用的系统编号
		params.put("timestamp",timestamp);//请求的时间戳
		params.put("v","1.0");//接口版本(现为 1.0)
		params.put("sign", SignUtils.sign(ApiUrl.sysid + req + timestamp));//SHA1WithRSA签名数据sysid + rps + timestamp
		FormBody.Builder mFormBodyBuild = new FormBody.Builder();
		if (params != null) {
			for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
				mFormBodyBuild.add(entry.getKey(), entry.getValue());
			}
		}
		FormBody mFormBody = mFormBodyBuild.build();

		return new Request.Builder().url(url).post(mFormBody).build();

//		if (mToken == null) {
//			return new Request.Builder().url(url).post(mFormBody).build();
//		}else {
//			return new Request.Builder().addHeader("Authorization", "Bearer " + mToken).url(url).post(mFormBody).build();
//		}
	}


	/**
	 * 文件上传请求
	 *  File 请求
	 * @param params 参数
     * @return
     */
	public static Request createMultiPostRequest(RequestParams params) {
		String url = ApiUrl.APP_HOST;
		MultipartBody.Builder requestBody = new MultipartBody.Builder();
		requestBody.setType(MultipartBody.FORM);

		if (params != null) {
			if (params.urlParams != null) {
				for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
					requestBody.addFormDataPart(entry.getKey(),entry.getValue());
				}
			}
			if (params.fileParams != null) {
				for (Map.Entry<String, Object> entry : params.fileParams.entrySet()) {
					requestBody.addFormDataPart(entry.getKey(), ((File) entry.getValue()).getName(),
							RequestBody.create(MediaType.parse("application/octet-stream"), (File) entry.getValue()));
				}
			}
		}
		return new Request.Builder().url(url).post(requestBody.build()).build();
//		String mToken = UserHelper.getToken();
//		if (mToken == null) {
//			return new Request.Builder().url(url).post(requestBody.build()).build();
//		}else {
//			return new Request.Builder().addHeader("Authorization", "Bearer " + mToken).url(url).post(requestBody.build()).build();
//		}
	}
}