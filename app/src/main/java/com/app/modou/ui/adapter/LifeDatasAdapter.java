package com.app.modou.ui.adapter;

import android.view.View;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.core.base.BaseXRecyclerViewAdapter;
import com.app.modou.ui.adapter.holder.LifeDatasHolder;
import com.app.modou.ui.bean.LifeDatasBean;

import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: LifeDatasAdapter
 * @Description: 描述
 * @CreateDate: 2019/3/19 17:31
 * @Version: 1.0
 */
public class LifeDatasAdapter extends BaseXRecyclerViewAdapter<LifeDatasBean> {


    public LifeDatasAdapter(List<LifeDatasBean> data) {
        super(data);
    }

    @Override
    public BaseHolder<LifeDatasBean> getHolder(View v) {
        return new LifeDatasHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_life_data_item;
    }
}
