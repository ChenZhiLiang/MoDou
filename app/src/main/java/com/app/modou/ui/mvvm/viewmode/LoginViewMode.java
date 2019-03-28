package com.app.modou.ui.mvvm.viewmode;

import com.app.modou.core.network.okhttp.callback.ResultCallback;
import com.app.modou.ui.mvvm.view.LoginView;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: LoginViewMode
 * @Description: 描述
 * @CreateDate: 2019/3/25 16:58
 * @Version: 1.0
 */
public class LoginViewMode {

    private LoginView mLoginView;
    private BaseMode mBaseMode;

    public LoginViewMode(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mBaseMode = new BaseMode();
    }


    /**
     * @param bizUserId 商户系统用户标识，商户系统中唯一编号。 用户名
     */
    public void Login(String bizUserId){
        mLoginView.showProgress();
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        try {
            jsonObject.put("bizUserId",bizUserId);
            jsonObject1.put("service","MemberService");
            jsonObject1.put("method","getMemberInfo");
            jsonObject1.put("param",jsonObject);
            mBaseMode.PostRequest(jsonObject1.toString(),new ResultCallback() {
                @Override
                public void onSuccess(Object result) {
                    mLoginView.LoginResult(result);
                    mLoginView.hideProgress();
                }
                @Override
                public void onFailure(Object result) {
                    mLoginView.hideProgress();
                    mLoginView.showLoadFailMsg(result.toString());
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
