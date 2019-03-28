package com.app.modou.ui.activity.home;

import android.os.Bundle;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: ParkingManagementActivity
 * @Description: 智能停车
 * @CreateDate: 2019/3/15 16:23
 * @Version: 1.0
 */
public class ParkingManagementActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_parking_management;
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
        setTitle("智能停车");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
