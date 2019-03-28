package com.app.modou.ui.adapter;

import android.app.Activity;
import android.view.View;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.core.base.BaseXRecyclerViewAdapter;
import com.app.modou.ui.adapter.holder.MyKeyHolder;
import com.app.modou.ui.bean.KeyBean;

import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: MyKeyAdapter
 * @Description: 描述
 * @CreateDate: 2019/3/20 9:36
 * @Version: 1.0
 */
public class MyKeyAdapter extends BaseXRecyclerViewAdapter<KeyBean> {

    private Activity mActivity;
    public MyKeyAdapter(List<KeyBean> data,Activity mActivity) {
        super(data);
        this.mActivity = mActivity;
    }

    @Override
    public BaseHolder<KeyBean> getHolder(View v) {
        return new MyKeyHolder(v,mActivity);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_key_item;
    }
}
