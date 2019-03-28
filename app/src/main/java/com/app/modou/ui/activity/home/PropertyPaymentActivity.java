package com.app.modou.ui.activity.home;

import android.os.Bundle;
import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: PropertyPaymentActivity
 * @Description: 物业缴费
 * @CreateDate: 2019/3/21 11:33
 * @Version: 1.0
 */
public class PropertyPaymentActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_property_payment;
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
        setTitle("应缴款项");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
