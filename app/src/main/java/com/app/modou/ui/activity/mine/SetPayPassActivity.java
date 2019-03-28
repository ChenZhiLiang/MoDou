package com.app.modou.ui.activity.mine;

import android.os.Bundle;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: SetPayPassActivity
 * @Description: 设置支付密码
 * @CreateDate: 2019/3/20 15:12
 * @Version: 1.0
 */
    public class SetPayPassActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_set_pay_pass;
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
        setTitle("设置支付密码");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
