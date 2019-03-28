package com.app.modou.ui.activity.mine;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;
import com.app.modou.ui.adapter.BillAdapter;
import com.app.modou.ui.mvvm.viewmode.BillViewMode;
import com.app.modou.utils.SpaceItemDecoration;
import com.yobo.third_sdk.widget.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: BillActivity
 * @Description: 物业账单
 * @CreateDate: 2019/3/20 17:25
 * @Version: 1.0
 */
public class BillActivity extends BaseActivity {

    @BindView(R.id.recy_bill)
    XRecyclerView recy_bill;

    private BillAdapter mBillAdapter;
    private BillViewMode mBillViewMode;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bill;
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
        setTitle("物业账单");
    }

    @Override
    public void initView() {
        mBillViewMode = new BillViewMode();
        mBillAdapter = new BillAdapter(mBillViewMode.getBillDatas());
        configRecycleView(recy_bill,new LinearLayoutManager(this));
        recy_bill.addItemDecoration(new SpaceItemDecoration(this,10));
        recy_bill.setAdapter(mBillAdapter);
    }

    @Override
    public void initData() {

    }
}
