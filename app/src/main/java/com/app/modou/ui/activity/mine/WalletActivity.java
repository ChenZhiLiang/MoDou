package com.app.modou.ui.activity.mine;

import android.os.Bundle;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: WalletActivity
 * @Description: 钱包
 * @CreateDate: 2019/3/20 11:47
 * @Version: 1.0
 */
public class WalletActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_wallet;
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
        setTitle("钱包");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
