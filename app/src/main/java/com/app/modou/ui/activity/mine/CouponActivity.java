package com.app.modou.ui.activity.mine;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;
import com.app.modou.ui.adapter.CouponAdapter;
import com.app.modou.ui.mvvm.viewmode.CouponViewMode;
import com.app.modou.utils.SpaceItemDecoration;
import com.yobo.third_sdk.widget.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: CouponActivity
 * @Description: 优惠券/抵扣券
 * @CreateDate: 2019/3/20 10:50
 * @Version: 1.0
 */
public class CouponActivity extends BaseActivity {

    @BindView(R.id.recy_coupon)
    XRecyclerView recy_coupon;

    private CouponAdapter mCouponAdapter;
    private CouponViewMode mCouponViewMode;
    @Override
    public int getLayoutId() {
        return R.layout.activity_coupon;
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
        setTitle("抵扣券");
    }

    @Override
    public void initView() {
        mCouponViewMode = new CouponViewMode();
        mCouponAdapter = new CouponAdapter(mCouponViewMode.getCouponDatas());
        configRecycleView(recy_coupon,new LinearLayoutManager(this));
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dimen_10px);
        Drawable drawable = getDrawable(R.color.white);
        recy_coupon.addItemDecoration(new SpaceItemDecoration(this,drawable,spacingInPixels));
        recy_coupon.setAdapter(mCouponAdapter);
    }

    @Override
    public void initData() {

    }
}
