package com.app.modou.ui.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;
import com.app.modou.ui.adapter.BankCardAdapter;
import com.app.modou.ui.mvvm.viewmode.BankCardViewMode;
import com.app.modou.utils.SpaceItemDecoration;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: BankCardActivity
 * @Description: 银行卡列表
 * @CreateDate: 2019/3/20 14:15
 * @Version: 1.0
 */
public class BankCardActivity extends BaseActivity {

    @BindView(R.id.tv_add_bank_card)
    TextView tv_add_bank_card;
    @BindView(R.id.recy_banl_car)
    RecyclerView recy_banl_car;

    private BankCardAdapter mBankCardAdapter;
    private BankCardViewMode mBankCardViewMode;
    @Override
    public int getLayoutId() {
        return R.layout.activity_bank_card;
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
        setTitle("银行卡列表");
    }

    @Override
    public void initView() {

        mBankCardViewMode = new BankCardViewMode();
        mBankCardAdapter = new BankCardAdapter(mBankCardViewMode.getBankCarDatas());
        configRecycleView(recy_banl_car,new LinearLayoutManager(this));
        recy_banl_car.addItemDecoration(new SpaceItemDecoration(this,1));

        recy_banl_car.setAdapter(mBankCardAdapter);

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.tv_add_bank_card})
    public void onClick(View v){

        if (v==tv_add_bank_card){
            startActivity(new Intent(this,BindBankCardActivity.class));
        }
    }
}
