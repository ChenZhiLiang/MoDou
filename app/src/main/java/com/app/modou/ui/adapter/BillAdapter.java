package com.app.modou.ui.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.core.base.BaseXRecyclerViewAdapter;
import com.app.modou.ui.bean.BillBean;

import java.util.List;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: BillAdapter
 * @Description: 描述
 * @CreateDate: 2019/3/21 10:38
 * @Version: 1.0
 */
public class BillAdapter extends BaseXRecyclerViewAdapter<BillBean> {

    public BillAdapter(List<BillBean> data) {
        super(data);
    }

    @Override
    public BaseHolder<BillBean> getHolder(View v) {
        return new BillHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_bill_item;
    }

    public class BillHolder extends BaseHolder<BillBean>{

        @BindView(R.id.ll_bill_details)
        LinearLayout ll_bill_details;
        @BindView(R.id.tv_look_details)
        TextView tv_look_details;

        public BillHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(BillBean data) {
            tv_look_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (ll_bill_details.getVisibility() == View.VISIBLE){
                        ll_bill_details.setVisibility(View.GONE);
                    }else {
                        ll_bill_details.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }
}
