package com.app.modou.ui.adapter;

import android.view.View;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.core.base.BaseXRecyclerViewAdapter;
import com.app.modou.ui.bean.OrderBean;

import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: OrderAdapter
 * @Description: 描述
 * @CreateDate: 2019/3/20 17:06
 * @Version: 1.0
 */
public class OrderAdapter extends BaseXRecyclerViewAdapter<OrderBean> {

    public OrderAdapter(List<OrderBean> data) {
        super(data);
    }

    @Override
    public BaseHolder<OrderBean> getHolder(View v) {
        return new OrderHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_order_item;
    }

    public class OrderHolder extends BaseHolder<OrderBean>{

        public OrderHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(OrderBean data) {

        }
    }
}
