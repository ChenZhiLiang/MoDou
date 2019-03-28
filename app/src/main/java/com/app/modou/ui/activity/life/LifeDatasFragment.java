package com.app.modou.ui.activity.life;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import com.app.modou.R;
import com.app.modou.core.base.BaseFragment;
import com.app.modou.core.helper.GlideHelper;
import com.app.modou.core.helper.ToastyHelper;
import com.app.modou.ui.adapter.LifeDatasAdapter;
import com.app.modou.ui.bean.AdvertBean;
import com.app.modou.ui.mvvm.HomeViewMode;
import com.app.modou.ui.mvvm.viewmode.LifeDatasViewMode;
import com.yobo.third_sdk.widget.bgabanner.BGABanner;
import com.yobo.third_sdk.widget.uitrarefresh.UTRefreshLayout;
import com.yobo.third_sdk.widget.uitrarefresh.ptr.PtrDefaultHandler;
import com.yobo.third_sdk.widget.uitrarefresh.ptr.PtrFrameLayout;
import com.yobo.third_sdk.widget.xrecyclerview.XRecyclerView;
import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: LifeDatasFragment
 * @Description: 生活数据显示页面
 * @CreateDate: 2019/3/19 15:51
 * @Version: 1.0
 */
public class LifeDatasFragment  extends BaseFragment implements  BGABanner.Adapter<ImageView, AdvertBean>, BGABanner.Delegate<ImageView, AdvertBean>{

    @BindView(R.id.refresh_layout)
    UTRefreshLayout refresh_layout;
    @BindView(R.id.banner_life_adv)
    BGABanner banner_life_adv;
    @BindView(R.id.recycler_life_list)
    XRecyclerView recycler_life_list;
    private LifeDatasAdapter mLifeDatasAdapter;
    private LifeDatasViewMode mLifeDatasViewMode;
    public static LifeDatasFragment getInstance(String title){
        LifeDatasFragment lf = new LifeDatasFragment();
        lf.mTitle = title;
        return lf;
    }


    @Override
    public int getLayoutId() {
        return R.layout.frag_life_datas;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        mLifeDatasViewMode = new LifeDatasViewMode();
        mLifeDatasAdapter = new LifeDatasAdapter(mLifeDatasViewMode.getDatas());

        configRecycleView(recycler_life_list, new LinearLayoutManager(mActivity));
        recycler_life_list.setNestedScrollingEnabled(false);
        recycler_life_list.setAdapter(mLifeDatasAdapter);
        //左右滑动时刷新控件禁止掉
        refresh_layout.disableWhenHorizontalMove(true);
        refresh_layout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                refresh_layout.refreshComplete();
            }
        });

        banner_life_adv.setAdapter(this);
        banner_life_adv.setDelegate(this);
    }
    @Override
    public void loadingData() {
        banner_life_adv.setData(new HomeViewMode().getAdvDatas(), null);

    }
    @Override
    public void onBannerItemClick(BGABanner banner, ImageView itemView, AdvertBean model, int position) {
        ToastyHelper.toastyNormal(mActivity,"点击了"+model.getName());

    }

    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, AdvertBean model, int position) {
        GlideHelper.loadImageView(mActivity, model.getImage_url(), itemView);

    }
}
