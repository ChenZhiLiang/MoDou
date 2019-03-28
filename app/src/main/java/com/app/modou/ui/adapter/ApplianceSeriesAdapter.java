package com.app.modou.ui.adapter;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.widget.TextView;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.core.base.BaseXRecyclerViewAdapter;
import com.app.modou.ui.bean.ApplianceSeriesBean;

import java.util.List;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: ApplianceSeriesAdapter
 * @Description: 电器系列列表适配
 * @CreateDate: 2019/3/22 11:06
 * @Version: 1.0
 */
public class ApplianceSeriesAdapter extends BaseXRecyclerViewAdapter<ApplianceSeriesBean> {


    private Activity mActivity;
    private int select;
    private OnItemClickListener onClickListener;
    public ApplianceSeriesAdapter(List<ApplianceSeriesBean> data,Activity mActivity) {
        super(data);
        this.mActivity = mActivity;
    }

    @Override
    public BaseHolder<ApplianceSeriesBean> getHolder(View v) {
        return new ApplianceSeriesHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_appliance_series_item;
    }

    public class ApplianceSeriesHolder extends BaseHolder<ApplianceSeriesBean>{

        @BindView(R.id.tv_appliance_name)
        TextView tv_appliance_name;
        public ApplianceSeriesHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(ApplianceSeriesBean data) {
            if ( getLayoutPosition() == getSelect()) {
                tv_appliance_name.setBackgroundColor(mActivity.getResources().getColor(R.color.bg));
            } else {
                tv_appliance_name.setBackgroundColor(mActivity.getResources().getColor(R.color.white));
            }
            tv_appliance_name.setText(data.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onItemClick(itemView, getLayoutPosition());

                }
            });
        }
    }

    public void setOnClickListener(OnItemClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int postion);
    }
    public int getSelect() {
        return select;
    }
    public void setSelect(int select) {
        this.select = select;
    }

}
