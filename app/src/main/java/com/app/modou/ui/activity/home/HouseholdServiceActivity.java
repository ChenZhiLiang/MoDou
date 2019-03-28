package com.app.modou.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: HouseholdServiceActivity
 * @Description: 家政服务
 * @CreateDate: 2019/3/22 9:54
 * @Version: 1.0
 */
public class HouseholdServiceActivity extends BaseActivity {

    @BindView(R.id.tv_home_appliance_repair)
    TextView tv_home_appliance_repair;

    @Override
    public int getLayoutId() {
        return R.layout.activity_household_service;
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
        setTitle("家政服务");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.tv_home_appliance_repair})
    public void onClick(View v){
        if (v==tv_home_appliance_repair){
            startActivity(new Intent(this,HomeApplianceRepairActivity.class));
        }
    }
}
