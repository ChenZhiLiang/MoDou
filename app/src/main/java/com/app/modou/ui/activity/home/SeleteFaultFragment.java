package com.app.modou.ui.activity.home;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.app.modou.R;
import com.app.modou.core.base.BaseFragment;
import com.app.modou.ui.adapter.SeleteFaultAdapter;
import com.app.modou.ui.bean.SeleteFaultBean;
import com.app.modou.ui.mvvm.view.HomeApplianceView;
import com.app.modou.ui.mvvm.viewmode.HomeApplianceRepairViewMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: SeleteFaultFragment
 * @Description: 故障选项表
 * @CreateDate: 2019/3/22 15:04
 * @Version: 1.0
 */
public class SeleteFaultFragment extends BaseFragment {

    @BindView(R.id.recy_selete_fault)
    RecyclerView recy_selete_fault;
    private List<SeleteFaultBean> mFaults = new ArrayList<>();
    private HomeApplianceRepairViewMode mHomeApplianceRepairViewMode;

    private int appliance_positon;
    private SeleteFaultAdapter mSeleteFaultAdapter;//故障选项列表适配
    private HomeApplianceView mHomeApplianceView;
    public static SeleteFaultFragment getInstance(String title, int appliance_positon, HomeApplianceView mHomeApplianceView){
        SeleteFaultFragment lf = new SeleteFaultFragment();
        lf.mTitle = title;
        lf.appliance_positon = appliance_positon;
        lf.mHomeApplianceView = mHomeApplianceView;
        return lf;
    }


    @Override
    public int getLayoutId() {
        return R.layout.frag_selete_fault;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        configRecycleView(recy_selete_fault,new GridLayoutManager(mActivity,2));
        mHomeApplianceRepairViewMode = new HomeApplianceRepairViewMode();
        mSeleteFaultAdapter = new SeleteFaultAdapter(mFaults);
        recy_selete_fault.setAdapter(mSeleteFaultAdapter);
        mSeleteFaultAdapter.setmOnItemCheckedListener(new SeleteFaultAdapter.OnItemCheckedListener() {
            @Override
            public void onCheck(String fault) {
                mHomeApplianceView.select(appliance_positon,fault);
            }

            @Override
            public void onUpCheck(int postion, String fault) {
                mHomeApplianceView.unselect(postion,fault);
            }
        });
    }

    @Override
    public void loadingData() {
        mFaults = mHomeApplianceRepairViewMode.getSeleteFaultDatas(mTitle);
        mSeleteFaultAdapter.addItem(mFaults);
        mSeleteFaultAdapter.notifyDataSetChanged();
    }
}
