package com.app.modou.ui.activity.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.app.modou.R;
import com.app.modou.core.base.BaseActivity;
import com.app.modou.core.base.BaseFragmentPageAdapter;
import com.app.modou.ui.activity.mine.OrderFragment;
import com.app.modou.ui.adapter.ApplianceSeriesAdapter;
import com.app.modou.ui.adapter.SelectedServiceAdapter;
import com.app.modou.ui.adapter.SeleteFaultAdapter;
import com.app.modou.ui.bean.ApplianceSeriesBean;
import com.app.modou.ui.bean.SelectedServiceBean;
import com.app.modou.ui.bean.SeleteFaultBean;
import com.app.modou.ui.mvvm.view.HomeApplianceView;
import com.app.modou.ui.mvvm.viewmode.HomeApplianceRepairViewMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: HomeApplianceRepairActivity
 * @Description: 家电维修
 * @CreateDate: 2019/3/22 10:14
 * @Version: 1.0
 */
public class HomeApplianceRepairActivity extends BaseActivity implements HomeApplianceView {

    @BindView(R.id.recy_appliance_series)
    RecyclerView recy_appliance_series;//电器系列列表

    @BindView(R.id.viewpage_selete_fault)
    ViewPager viewpage_selete_fault;

    @BindView(R.id.recy_selected)
    RecyclerView recy_selected;//已选项目

    private ApplianceSeriesAdapter mApplianceSeriesAdapter;//电器系列适配器
    private SelectedServiceAdapter mSelectedServiceAdapter;//已选项目适配
    private List<ApplianceSeriesBean> mApplianceSeriesDatas = new ArrayList<>();
    private List<SelectedServiceBean> mSelectedDatas = new ArrayList<>();
    private HomeApplianceRepairViewMode mHomeApplianceRepairViewMode;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BaseFragmentPageAdapter mBaseFragmentPageAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_home_appliance_repair;
    }

    @Override
    public String returnToolBarTitle() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        initToolBar();
        showOrHideToolBarNavigation(true);
        setTitle("家电维修");
    }

    @Override
    public void initView() {

        configRecycleView(recy_appliance_series,new LinearLayoutManager(this));
        configRecycleView(recy_selected,new LinearLayoutManager(this));

        mHomeApplianceRepairViewMode = new HomeApplianceRepairViewMode();
        mApplianceSeriesDatas = mHomeApplianceRepairViewMode.getApplianceDatas();
        mApplianceSeriesAdapter = new ApplianceSeriesAdapter(mApplianceSeriesDatas,this);
        recy_appliance_series.setNestedScrollingEnabled(false);
        recy_appliance_series.setAdapter(mApplianceSeriesAdapter);
        mApplianceSeriesAdapter.setOnClickListener(new ApplianceSeriesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                //拿适配器调用适配器内部自定义好的setSelect方法（参数写点击事件的参数的position）
                mApplianceSeriesAdapter.setSelect(postion);
                //刷新适配器
                mApplianceSeriesAdapter.notifyDataSetChanged();
                viewpage_selete_fault.setCurrentItem(postion);
            }
        });

        for (int i = 0; i < mApplianceSeriesDatas.size(); i++) {
            mFragments.add(SeleteFaultFragment.getInstance(mApplianceSeriesDatas.get(i).getName(),i,this));
        }
        mBaseFragmentPageAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments);
        viewpage_selete_fault.setOffscreenPageLimit(mApplianceSeriesDatas.size());
        viewpage_selete_fault.setAdapter(mBaseFragmentPageAdapter);
        viewpage_selete_fault.setCurrentItem(0);

        mSelectedServiceAdapter = new SelectedServiceAdapter(mSelectedDatas);
        recy_selected.setAdapter(mSelectedServiceAdapter);
    }

    @Override
    public void initData() {

    }


  /*  *//**
     * 故障选择
     * @param appliance_id 电器id
     * @param data  故障模型
     *//*
    @Override
    public void select(int appliance_id, SeleteFaultBean data) {
        boolean isSameFaylt = false;
        if (mSelectedDatas.size()>0){
            for (int i = 0; i < mSelectedDatas.size(); i++) {
                if (appliance_id == mSelectedDatas.get(i).getId()){//判断电器选择有没有重复
                    StringBuilder stringBuilder = new StringBuilder().append(mSelectedDatas.get(i).getFault()).append("、").append(data.getName());
                    mSelectedDatas.get(i).setFault(stringBuilder.toString());
                    mSelectedServiceAdapter.notifyDataSetChanged();
                    isSameFaylt = true;
                }
            }
            if (!isSameFaylt){
                AddSelectedService(appliance_id,data);
            }
        }else {
            AddSelectedService(appliance_id,data);
        }
    }*/

   /* @Override
    public void unselect(int appliance_id, SeleteFaultBean data) {
        String deleteResult="";
        for (int i = 0; i < mSelectedDatas.size(); i++) {
            if (appliance_id == mSelectedDatas.get(i).getId()){//判断电器选择有没有重复
                String Fault = mSelectedDatas.get(i).getFault();

                if(Fault.indexOf("、")!=-1){//是否包含"、"
                    String[] strs=Fault.split("、");
                    for(int j = 0;j<strs.length;j++){
                        if (!strs[j].equals(data.getName())){
                            if (TextUtils.isEmpty(deleteResult)){
                                deleteResult = deleteResult + strs[j];
                            }else {
                                deleteResult = deleteResult+"、"+strs[j];
                            }
                        }
                    }
                    mSelectedDatas.get(i).setFault(deleteResult);
                    mSelectedServiceAdapter.notifyDataSetChanged();
                }else {
                    mSelectedDatas.remove(appliance_id);
                    mSelectedServiceAdapter.notifyDataSetChanged();
                }
            }
        }
    }
*/

    /**
     * 添加已选服务
     */
    private void AddSelectedService(int appliance_id,String fault){
        SelectedServiceBean bean = new SelectedServiceBean();
        bean.setId(appliance_id);
        bean.setName(mApplianceSeriesDatas.get(appliance_id).getName());
        bean.setFault(fault);
        bean.setIndex(1);
        mSelectedDatas.add(bean);
        mSelectedServiceAdapter.notifyDataSetChanged();
    }

    @Override
    public void select(int appliance_id, String fault) {
        boolean isSameFaylt = false;
        if (mSelectedDatas.size()>0){
            for (int i = 0; i < mSelectedDatas.size(); i++) {
                if (appliance_id == mSelectedDatas.get(i).getId()){//判断电器选择有没有重复
                    StringBuilder stringBuilder = new StringBuilder().append(mSelectedDatas.get(i).getFault()).append("、").append(fault);
                    mSelectedDatas.get(i).setFault(stringBuilder.toString());
                    mSelectedServiceAdapter.notifyDataSetChanged();
                    isSameFaylt = true;
                }
            }
            if (!isSameFaylt){
                AddSelectedService(appliance_id,fault);
            }
        }else {
            AddSelectedService(appliance_id,fault);
        }
    }

    @Override
    public void unselect(int appliance_id, String fault) {
        String deleteResult="";
        for (int i = 0; i < mSelectedDatas.size(); i++) {

            String Fault = mSelectedDatas.get(appliance_id).getFault();

            if(Fault.indexOf("、")!=-1){//是否包含"、"
                String[] strs=Fault.split("、");
                for(int j = 0;j<strs.length;j++){
                    if (!strs[j].equals(fault)){
                        if (TextUtils.isEmpty(deleteResult)){
                            deleteResult = deleteResult + strs[j];
                        }else {
                            deleteResult = deleteResult+"、"+strs[j];
                        }
                    }
                }
                mSelectedDatas.get(i).setFault(deleteResult);
                mSelectedServiceAdapter.notifyDataSetChanged();
            }else {
                mSelectedDatas.remove(i);
                mSelectedServiceAdapter.notifyDataSetChanged();
            }

//            if (appliance_id == mSelectedDatas.get(i).getId()){//判断电器选择有没有重复
//
//            }
        }
    }
}
