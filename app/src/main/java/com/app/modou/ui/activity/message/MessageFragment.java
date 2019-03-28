package com.app.modou.ui.activity.message;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.app.modou.R;
import com.app.modou.core.base.BaseFragment;
import com.app.modou.ui.adapter.MessageAdapter;
import com.app.modou.ui.mvvm.MessageViewMode;
import com.app.modou.utils.SpaceItemDecoration;
import com.yobo.third_sdk.widget.xrecyclerview.ProgressStyle;
import com.yobo.third_sdk.widget.xrecyclerview.XRecyclerView;
import com.yobo.third_sdk.widget.xrecyclerview.XRecyclerView.LoadingListener;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: LifeFragment
 * @Description: 生活
 * @CreateDate: 2019/3/15 10:26
 * @Version: 1.0
 */
public class MessageFragment extends BaseFragment implements LoadingListener {

    @BindView(R.id.tv_home_title_bar)
    TextView tv_home_title_bar;

    @BindView(R.id.recy_messagge)
    XRecyclerView recy_messagge;

    private MessageAdapter mMessageAdapter;
    private MessageViewMode mMessageViewMode;
    /**
     * fragment 传递参数
     * @param title
     * @return
     */
    public static MessageFragment getInstance(String title) {
        MessageFragment hf = new MessageFragment();
        hf.mTitle = title;
        return hf;
    }
    @Override
    public int getLayoutId() {
        return R.layout.frag_message;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        tv_home_title_bar.setText(getString(R.string.message));

        mMessageViewMode = new MessageViewMode();
        mMessageAdapter = new MessageAdapter(mMessageViewMode.getMessageDatas());
        configRecycleView(recy_messagge, new LinearLayoutManager(mActivity));
        recy_messagge.setRefreshProgressStyle(ProgressStyle.BallPulse);
        recy_messagge.setLoadingMoreProgressStyle(ProgressStyle.BallBeat);
        recy_messagge.setArrowImageView(R.mipmap.icon_pull_down);
        recy_messagge.setLoadingListener(this);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dimen_1px);
        recy_messagge.addItemDecoration(new SpaceItemDecoration(mActivity,spacingInPixels));
        recy_messagge.setAdapter(mMessageAdapter);
        recy_messagge.setPullRefreshEnabled(true);
    }

    @Override
    public void loadingData() {

    }

    @Override
    public void onRefresh() {

        recy_messagge.refreshComplete();
    }

    @Override
    public void onLoadMore() {

    }
}
