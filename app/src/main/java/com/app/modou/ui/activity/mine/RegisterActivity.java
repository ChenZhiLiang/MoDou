package com.app.modou.ui.activity.mine;

import android.os.Bundle;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: RegisterActivity
 * @Description: 注册
 * @CreateDate: 2019/3/25 15:50
 * @Version: 1.0
 */
public class RegisterActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
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
        setTitle("注册");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
