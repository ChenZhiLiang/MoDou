package com.app.modou.ui.adapter;

import android.view.View;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.core.base.BaseXRecyclerViewAdapter;
import com.app.modou.ui.bean.BankCardBean;

import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: BankCardAdapter
 * @Description: 银行卡列表适配器
 * @CreateDate: 2019/3/20 14:25
 * @Version: 1.0
 */
public class BankCardAdapter extends BaseXRecyclerViewAdapter<BankCardBean> {

    public BankCardAdapter(List<BankCardBean> data) {
        super(data);
    }

    @Override
    public BaseHolder<BankCardBean> getHolder(View v) {
        return new BankCardHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_bank_car_item;
    }

    public class BankCardHolder extends BaseHolder<BankCardBean>{

        public BankCardHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(BankCardBean data) {

        }
    }
}
