package com.app.modou.ui.mvvm.viewmode;

import com.app.modou.ui.bean.ApplianceSeriesBean;
import com.app.modou.ui.bean.SeleteFaultBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: HomeApplianceRepairViewMode
 * @Description: 家电维修
 * @CreateDate: 2019/3/22 11:12
 * @Version: 1.0
 */
public class HomeApplianceRepairViewMode {

    private String [] appliances = {"空调","热水器","冰箱","电饭煲","油烟机","洗衣机","微波炉","净水器","饮水机"};
    public HomeApplianceRepairViewMode(){

    }

    public List<ApplianceSeriesBean> getApplianceDatas(){

        List<ApplianceSeriesBean> datas = new ArrayList<>();
        for (int i = 0; i < appliances.length; i++) {
            ApplianceSeriesBean bean = new ApplianceSeriesBean();
            bean.setName(appliances[i]);
            bean.setmSeleteFaultBean(getSeleteFaultDatas(appliances[i]));
            datas.add(bean);
        }
        return datas;
    }

    public List<SeleteFaultBean> getSeleteFaultDatas(String name){
        List<SeleteFaultBean> datas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            SeleteFaultBean bean = new SeleteFaultBean();
            bean.setName(name+"故障"+i);
            datas.add(bean);
        }
        return datas;
    }
}
