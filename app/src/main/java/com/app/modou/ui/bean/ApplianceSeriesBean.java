package com.app.modou.ui.bean;

import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: ApplianceSeriesBean
 * @Description: 电器系列数据魔板
 * @CreateDate: 2019/3/22 11:07
 * @Version: 1.0
 */
public class ApplianceSeriesBean {

    String name;
    List<SeleteFaultBean> mSeleteFaultBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SeleteFaultBean> getmSeleteFaultBean() {
        return mSeleteFaultBean;
    }

    public void setmSeleteFaultBean(List<SeleteFaultBean> mSeleteFaultBean) {
        this.mSeleteFaultBean = mSeleteFaultBean;
    }
}
