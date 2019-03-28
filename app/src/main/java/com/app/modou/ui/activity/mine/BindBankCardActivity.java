package com.app.modou.ui.activity.mine;

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
 * @ClassName: BindBankCardActivity
 * @Description: 绑定银行卡
 * @CreateDate: 2019/3/20 14:46
 * @Version: 1.0
 */
public class BindBankCardActivity extends BaseActivity {


    @BindView(R.id.btn_bink_card_next)
    Button btn_bink_card_next;
    @Override
    public int getLayoutId() {
        return R.layout.activity_bind_bank_card;
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
        setTitle("绑定银行卡");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_bink_card_next})
    public void onClick(View v){
        if (v==btn_bink_card_next){
            startActivity(new Intent(this,SetPayPassActivity.class));
        }
    }
}
