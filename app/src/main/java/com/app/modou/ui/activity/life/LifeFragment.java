package com.app.modou.ui.activity.life;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.modou.R;
import com.app.modou.core.base.BaseFragment;
import com.app.modou.core.base.BaseFragmentPageAdapter;
import com.app.modou.ui.adapter.FragmentAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: LifeFragment
 * @Description: 生活（社区商圈）
 * @CreateDate: 2019/3/18 9:23
 * @Version: 1.0
 */
public class LifeFragment extends BaseFragment implements OnPageChangeListener {

    @BindView(R.id.tv_home_title_bar)
    TextView tv_home_title_bar;

    @BindView(R.id.ll_cate)
    LinearLayout ll_cate;
    @BindView(R.id.tv_cate)
    TextView tv_cate;
    @BindView(R.id.view_cate)
    View view_cate;

    @BindView(R.id.ll_recreation)
    LinearLayout ll_recreation;
    @BindView(R.id.tv_recreation)
    TextView tv_recreation;
    @BindView(R.id.view_recreation)
    View view_recreation;

    @BindView(R.id.ll_service)
    LinearLayout ll_service;
    @BindView(R.id.tv_service)
    TextView tv_service;
    @BindView(R.id.view_service)
    View view_service;

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private String[] mTitles;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BaseFragmentPageAdapter mBaseFragmentPageAdapter;

    public static LifeFragment getInstance(String title) {
        LifeFragment lf = new LifeFragment();
        lf.mTitle = title;
        return lf;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_life;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        tv_home_title_bar.setText(getString(R.string.life));
        mTitles = getResources().getStringArray(R.array.tab);

        for (int i = 0; i < mTitles.length; i++) {
            mFragments.add(LifeDatasFragment.getInstance(mTitles[i]));
        }
        mBaseFragmentPageAdapter = new BaseFragmentPageAdapter(getChildFragmentManager(), mFragments);
        viewpager.setOffscreenPageLimit(3);
        viewpager.setAdapter(mBaseFragmentPageAdapter);
        viewpager.addOnPageChangeListener(this);
        viewpager.setCurrentItem(0);

    }

    @Override
    public void loadingData() {

    }

    @OnClick({R.id.ll_cate, R.id.ll_recreation, R.id.ll_service})
    public void onClick(View v) {
        if (v == ll_cate) {
            viewpager.setCurrentItem(0, false);
            ChangeTabText(0);
        } else if (v == ll_recreation) {
            viewpager.setCurrentItem(1, false);
            ChangeTabText(1);
        } else {
            viewpager.setCurrentItem(2, false);
            ChangeTabText(3);
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        viewpager.setCurrentItem(position, false);
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
            tv_cate.setTextColor(mActivity.getResources().getColor(R.color.blue));
            view_cate.setVisibility(View.VISIBLE);
            tv_recreation.setTextColor(mActivity.getResources().getColor(R.color.default_hint_color));
            view_recreation.setVisibility(View.GONE);
            tv_service.setTextColor(mActivity.getResources().getColor(R.color.default_hint_color));
            view_service.setVisibility(View.GONE);
        } else if (position == 1) {
            tv_cate.setTextColor(mActivity.getResources().getColor(R.color.default_hint_color));
            view_cate.setVisibility(View.GONE);
            tv_recreation.setTextColor(mActivity.getResources().getColor(R.color.blue));
            view_recreation.setVisibility(View.VISIBLE);
            tv_service.setTextColor(mActivity.getResources().getColor(R.color.default_hint_color));
            view_service.setVisibility(View.GONE);
        } else {
            tv_cate.setTextColor(mActivity.getResources().getColor(R.color.default_hint_color));
            view_cate.setVisibility(View.GONE);
            tv_recreation.setTextColor(mActivity.getResources().getColor(R.color.default_hint_color));
            view_recreation.setVisibility(View.GONE);
            tv_service.setTextColor(mActivity.getResources().getColor(R.color.blue));
            view_service.setVisibility(View.VISIBLE);
        }
    }
}
