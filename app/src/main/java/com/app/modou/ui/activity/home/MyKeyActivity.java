package com.app.modou.ui.activity.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;
import com.app.modou.ui.adapter.MyKeyAdapter;
import com.app.modou.ui.mvvm.viewmode.MyKeyViewMode;
import com.app.modou.utils.SpaceItemDecoration;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: MyKeyActivity
 * @Description: 我的钥匙
 * @CreateDate: 2019/3/20 9:17
 * @Version: 1.0
 */
public class MyKeyActivity extends BaseActivity {

    @BindView(R.id.recy_key)
    RecyclerView recy_key;

    private MyKeyAdapter mMyKeyAdapter;
    private MyKeyViewMode mMyKeyViewMode;
    @Override
    public int getLayoutId() {
        return R.layout.activity_my_key;
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
        setTitle("我的钥匙");
        configRecycleView(recy_key,new LinearLayoutManager(mContext));
    }

    @Override
    public void initView() {

        mMyKeyViewMode = new MyKeyViewMode();
        mMyKeyAdapter = new MyKeyAdapter(mMyKeyViewMode.getKeyDatas(),this);
        recy_key.setNestedScrollingEnabled(false);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dimen_10px);
        recy_key.addItemDecoration(new SpaceItemDecoration(this,spacingInPixels));
        recy_key.setAdapter(mMyKeyAdapter);
    }

    @Override
    public void initData() {

    }
}
