package com.app.modou.ui.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;
import com.app.modou.core.eventbus.Event;
import com.app.modou.core.eventbus.EventCode;
import com.app.modou.core.helper.EventBusHelper;
import com.app.modou.core.helper.GsonHelper;
import com.app.modou.core.helper.SharedPreferenceHelper;
import com.app.modou.core.helper.ToastyHelper;
import com.app.modou.ui.AppContext;
import com.app.modou.ui.bean.UserInfoBean;
import com.app.modou.ui.mvvm.view.LoginView;
import com.app.modou.ui.mvvm.viewmode.LoginViewMode;
import com.app.modou.utils.LogUtils;
import com.google.gson.JsonObject;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: LoginActivity
 * @Description: 登录
 * @CreateDate: 2019/3/25 14:58
 * @Version: 1.0
 */
public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.edit_phone)
    MaterialEditText edit_phone;
    @BindView(R.id.btn_login)
    Button btn_login;

    private LoginViewMode mLoginViewMode;
    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public String returnToolBarTitle() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        initToolBar();
        showOrHideToolBarNavigation(true);
        setTitle("登录");
    }

    @Override
    public void initView() {
        mLoginViewMode = new LoginViewMode(this);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_login})
    public void onClick(View v){
        if (v==btn_login){
            mLoginViewMode.Login(edit_phone.getText().toString());
        }
    }

    /**
     * @param result 登录结果返回
     */
    @Override
    public void LoginResult(Object result) {
        String status = GsonHelper.GsonToString(result.toString(),"status");
        if (status.equals("OK")){
            String signedValue = GsonHelper.GsonToString(result.toString(),"signedValue");
            //打印json字符串数据
            LogUtils.i(signedValue);
            UserInfoBean mUserInfo = GsonHelper.GsonToBean(signedValue,UserInfoBean.class);
            //保存用户信息
            SharedPreferenceHelper.setUserInfo(AppContext.getContext(),mUserInfo);
            //发送登录成功事件
            EventBusHelper.sendEvent(new Event(EventCode.Code.LOGIN_SECCESS));
            finish();
        }else {
            showLoadFailMsg(GsonHelper.GsonToString(result.toString(),"message"));
        }
    }

    @Override
    public void showProgress() {
        hud.show();
    }

    @Override
    public void hideProgress() {

        hud.dismiss();
    }

    @Override
    public void showLoadFailMsg(String err) {

        ToastyHelper.toastyNormal(this,err);
    }
}
