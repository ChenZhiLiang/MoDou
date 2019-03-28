package com.app.modou.ui.activity.mine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;
import com.app.modou.core.base.BaseFragmentPageAdapter;
import com.app.modou.ui.activity.life.LifeDatasFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: OrderActivity
 * @Description: 我的订单
 * @CreateDate: 2019/3/20 15:36
 * @Version: 1.0
 */
public class OrderActivity extends BaseActivity implements OnPageChangeListener {

    @BindView(R.id.ll_undisposed)
    LinearLayout ll_undisposed;
    @BindView(R.id.tv_undisposed)
    TextView tv_undisposed;
    @BindView(R.id.view_undisposed)
    View view_undisposed;

    @BindView(R.id.ll_underway)
    LinearLayout ll_underway;
    @BindView(R.id.tv_underway)
    TextView tv_underway;
    @BindView(R.id.view_underway)
    View view_underway;

    @BindView(R.id.ll_processed)
    LinearLayout ll_processed;
    @BindView(R.id.tv_processed)
    TextView tv_processed;
    @BindView(R.id.view_processed)
    View view_processed;

    @BindView(R.id.viewpager_order)
    ViewPager viewpager_order;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BaseFragmentPageAdapter mBaseFragmentPageAdapter;
    private String[] mTitles;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order;
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
        setTitle("我的订单");
    }

    @Override
    public void initView() {
        mTitles = getResources().getStringArray(R.array.tab);

        for (int i = 0; i < mTitles.length; i++) {
            mFragments.add(OrderFragment.getInstance(mTitles[i]));
        }
        mBaseFragmentPageAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments);
        viewpager_order.setOffscreenPageLimit(3);
        viewpager_order.setAdapter(mBaseFragmentPageAdapter);
        viewpager_order.addOnPageChangeListener(this);
        viewpager_order.setCurrentItem(0);
    }

    @Override
    public void initData() {

    }
    @OnClick({R.id.ll_undisposed, R.id.ll_underway, R.id.ll_processed})
    public void onClick(View v) {
        if (v == ll_undisposed) {
            viewpager_order.setCurrentItem(0, false);
            ChangeTabText(0);
        } else if (v == ll_underway) {
            viewpager_order.setCurrentItem(1, false);
            ChangeTabText(1);
        } else {
            viewpager_order.setCurrentItem(2, false);
            ChangeTabText(3);
        }
    }
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        viewpager_order.setCurrentItem(position, false);
        ChangeTabText(position);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    /**
     * tab切换
     *
     * @param position
     */
    private void ChangeTabText(int position) {
        if (position == 0) {
            tv_undisposed.setTextColor(getResources().getColor(R.color.blue));
            view_undisposed.setVisibility(View.VISIBLE);
            tv_underway.setTextColor(getResources().getColor(R.color.default_hint_color));
            view_underway.setVisibility(View.GONE);
            tv_processed.setTextColor(getResources().getColor(R.color.default_hint_color));
            view_processed.setVisibility(View.GONE);
        } else if (position == 1) {
            tv_undisposed.setTextColor(getResources().getColor(R.color.default_hint_color));
            view_undisposed.setVisibility(View.GONE);
            tv_underway.setTextColor(getResources().getColor(R.color.blue));
            view_underway.setVisibility(View.VISIBLE);
            tv_processed.setTextColor(getResources().getColor(R.color.default_hint_color));
            view_processed.setVisibility(View.GONE);
        } else {
            tv_undisposed.setTextColor(getResources().getColor(R.color.default_hint_color));
            view_undisposed.setVisibility(View.GONE);
            tv_underway.setTextColor(getResources().getColor(R.color.default_hint_color));
            view_underway.setVisibility(View.GONE);
            tv_processed.setTextColor(getResources().getColor(R.color.blue));
            view_processed.setVisibility(View.VISIBLE);
        }
    }
}
