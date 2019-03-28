package com.app.modou.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: SelectVillageActivity
 * @Description: 选择小区
 * @CreateDate: 2019/3/21 16:24
 * @Version: 1.0
 */
public class SelectVillageActivity extends BaseActivity {

    @BindView(R.id.btn_select_sure)
    Button btn_select_sure;
    @Override
    public int getLayoutId() {
        return R.layout.activity_select_village;
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
        setTitle("选择小区");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_select_sure})
    public void onClick(View v){

        if (v==btn_select_sure){
            startActivity(new Intent(this,PropertyPaymentActivity.class));
        }
    }
}
