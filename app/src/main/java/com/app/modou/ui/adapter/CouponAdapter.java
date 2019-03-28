package com.app.modou.ui.adapter;

import android.view.View;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.core.base.BaseXRecyclerViewAdapter;
import com.app.modou.ui.bean.CouponBean;

import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: CouponAdapter
 * @Description: 描述
 * @CreateDate: 2019/3/20 11:04
 * @Version: 1.0
 */
public class CouponAdapter extends BaseXRecyclerViewAdapter<CouponBean> {


    public CouponAdapter(List<CouponBean> data) {
        super(data);
    }

    @Override
    public BaseHolder<CouponBean> getHolder(View v) {
        return new CouponHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_coupon_item;
    }

    public class CouponHolder extends BaseHolder<CouponBean>{

        public CouponHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(CouponBean data) {

        }
    }
}
