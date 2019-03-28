package com.app.modou.ui.activity.mine;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.app.modou.R;
import com.app.modou.core.base.BaseFragment;
import com.app.modou.ui.adapter.OrderAdapter;
import com.app.modou.ui.mvvm.viewmode.OrderViewMode;
import com.app.modou.utils.SpaceItemDecoration;
import com.yobo.third_sdk.widget.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: OrderFragment
 * @Description: 我的订单frag
 * @CreateDate: 2019/3/20 16:12
 * @Version: 1.0
 */
public class OrderFragment extends BaseFragment {

    @BindView(R.id.recy_order)
    XRecyclerView recy_order;

    private OrderViewMode mOrderViewMode;
    private OrderAdapter mOrderAdapter;
    public static OrderFragment getInstance(String title){
        OrderFragment lf = new OrderFragment();
        lf.mTitle = title;
        return lf;
    }
    @Override
    public int getLayoutId() {
        return R.layout.frag_order;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

        configRecycleView(recy_order,new LinearLayoutManager(mActivity));

        mOrderViewMode = new OrderViewMode();
        mOrderAdapter = new OrderAdapter(mOrderViewMode.getOrder());

        recy_order.addItemDecoration(new SpaceItemDecoration(mActivity,10));

        recy_order.setAdapter(mOrderAdapter);
    }
    @Override
    public void loadingData() {

    }
}
