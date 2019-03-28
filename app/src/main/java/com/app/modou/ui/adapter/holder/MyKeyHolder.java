package com.app.modou.ui.adapter.holder;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.ui.adapter.KeyTypeAdapter;
import com.app.modou.ui.bean.KeyBean;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: MyKeyHolder
 * @Description: 描述
 * @CreateDate: 2019/3/20 9:38
 * @Version: 1.0
 */
public class MyKeyHolder extends BaseHolder<KeyBean> {

    @BindView(R.id.recy_key_num)
    RecyclerView recy_key_num;
    private Activity mActivity;
    private KeyTypeAdapter mKeyTypeAdapter;
    public MyKeyHolder(View itemView,Activity mActivity) {
        super(itemView);
        this.mActivity = mActivity;
    }

    @Override
    public void setData(KeyBean data) {
        mKeyTypeAdapter = new KeyTypeAdapter(data.getKey_num());
        recy_key_num.setLayoutManager(new GridLayoutManager(mActivity,4));
        recy_key_num.setAdapter(mKeyTypeAdapter);
    }
}
