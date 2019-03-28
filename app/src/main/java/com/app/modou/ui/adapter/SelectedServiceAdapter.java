package com.app.modou.ui.adapter;

import android.view.View;
import android.widget.TextView;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.core.base.BaseXRecyclerViewAdapter;
import com.app.modou.ui.bean.SelectedServiceBean;

import java.util.List;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: SelectedServiceAdapter
 * @Description: 已选服务列表适配
 * @CreateDate: 2019/3/22 15:41
 * @Version: 1.0
 */
public class SelectedServiceAdapter extends BaseXRecyclerViewAdapter<SelectedServiceBean> {
    public SelectedServiceAdapter(List<SelectedServiceBean> data) {
        super(data);
    }

    @Override
    public BaseHolder<SelectedServiceBean> getHolder(View v) {
        return new SelectedServiceHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_selected_service_item;
    }

    public class SelectedServiceHolder extends BaseHolder<SelectedServiceBean>{

        @BindView(R.id.tv_service_name)
        TextView tv_service_name;
        @BindView(R.id.tv_service_fault)
        TextView tv_service_fault;
        @BindView(R.id.tv_service_count)
        TextView tv_service_count;
        public SelectedServiceHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(SelectedServiceBean data) {
            tv_service_name.setText(data.getName());
            tv_service_fault.setText(data.getFault());
            tv_service_count.setText(String.valueOf(data.getIndex()));
        }
    }
}
