package com.app.modou.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;
import com.app.modou.core.base.BaseFragmentPageAdapter;
import com.app.modou.core.helper.ToastyHelper;
import com.app.modou.ui.activity.home.HomeFragment;
import com.app.modou.ui.activity.life.LifeFragment;
import com.app.modou.ui.activity.mine.MineFragment;
import com.app.modou.ui.bean.TabEntityBean;
import com.app.modou.view.NoScrollViewPager;
import com.yobo.third_sdk.widget.tablayout.CommonTabLayout;
import com.yobo.third_sdk.widget.tablayout.listener.CustomTabEntity;
import com.yobo.third_sdk.widget.tablayout.listener.OnTabSelectListener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements OnTabSelectListener, OnPageChangeListener{

    @BindView(R.id.vpage_main)
    NoScrollViewPager vpageMain;
    @BindView(R.id.tab_main)
    CommonTabLayout tabMain;
    private BaseFragmentPageAdapter mBaseFragmentPageAdapter;
    private ArrayList<Fragment> mFragments;
    private ArrayList<CustomTabEntity> mTabEntities;
    private String[] mTitles;
    private int[] mIconUnselectIds = {
            R.mipmap.icon_home_unselete, R.mipmap.icon_life_unselete,
            R.mipmap.icon_mine_unselete};
    private int[] mIconSelectIds = {
            R.mipmap.icon_home_selete, R.mipmap.icon_life_selete,
            R.mipmap.icon_mine_selete};

    public static WeakReference<MainActivity> sRef;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public String returnToolBarTitle() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        sRef = new WeakReference<>(this);
        mFragments = new ArrayList<>();
        mTabEntities = new ArrayList<>();
    }

    @Override
    public void initView() {
        mTitles = getResources().getStringArray(R.array.tab);
        mFragments.add(HomeFragment.getInstance(mTitles[0]));
        mFragments.add(LifeFragment.getInstance(mTitles[1]));
        mFragments.add(MineFragment.getInstance(mTitles[2]));
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntityBean(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mBaseFragmentPageAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments);
        vpageMain.setOffscreenPageLimit(3);
        vpageMain.setNoScroll(true);//设置viewpage 是否可以左右滑动
        vpageMain.setAdapter(mBaseFragmentPageAdapter);
        tabMain.setTabData(mTabEntities);
        tabMain.setOnTabSelectListener(this);
        vpageMain.addOnPageChangeListener(this);
        vpageMain.setCurrentItem(0);
    }

    @Override
    public void initData() {

    }

    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            ToastyHelper.toastyNormal(MainActivity.this, "再按一次退出程序");
            firstTime = secondTime;
        } else {
            AppManager.getAppManager().AppExit(this);
            super.onBackPressed();
        }
    }

    @Override
    public void onTabSelect(int position) {
        vpageMain.setCurrentItem(position, false);
    }

    @Override
    public void onTabReselect(int position) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        tabMain.setCurrentTab(position);

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sRef.clear();
        sRef = null;
    }
}
