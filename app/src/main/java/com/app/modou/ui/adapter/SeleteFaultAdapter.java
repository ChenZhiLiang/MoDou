package com.app.modou.ui.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.core.base.BaseXRecyclerViewAdapter;
import com.app.modou.ui.bean.SeleteFaultBean;

import java.util.List;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: SeleteFaultAdapter
 * @Description: 描述
 * @CreateDate: 2019/3/22 11:27
 * @Version: 1.0
 */
public class SeleteFaultAdapter extends BaseXRecyclerViewAdapter<SeleteFaultBean> {

    private int select;
    private OnItemCheckedListener mOnItemCheckedListener;
    public SeleteFaultAdapter(List<SeleteFaultBean> data) {
        super(data);
    }

    @Override
    public BaseHolder<SeleteFaultBean> getHolder(View v) {
        return new SeleteFaultHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_selete_fault;
    }

    public class SeleteFaultHolder extends BaseHolder<SeleteFaultBean>{

        @BindView(R.id.check_fault)
        CheckBox check_fault;
        public SeleteFaultHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(SeleteFaultBean data) {
            check_fault.setText(data.getName());
            check_fault.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        mOnItemCheckedListener.onCheck(data.getName());
                    }else {
                        mOnItemCheckedListener.onUpCheck(getLayoutPosition(),data.getName());
                    }
                }
            });
        }
    }

    public void setmOnItemCheckedListener(OnItemCheckedListener mOnItemCheckedListener) {
        this.mOnItemCheckedListener = mOnItemCheckedListener;
    }

    public interface OnItemCheckedListener {
        void onCheck(String fault);
        void onUpCheck(int postion,String fault);
    }

    public int getSelect() {
        return select;
    }
    public void setSelect(int select) {
        this.select = select;
    }
}
