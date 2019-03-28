package com.app.modou.ui.mvvm.view;

import com.app.modou.ui.bean.SeleteFaultBean;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: HomeApplianceView
 * @Description: 描述
 * @CreateDate: 2019/3/22 16:09
 * @Version: 1.0
 */
public interface HomeApplianceView {


    /**
     *选择
     * @param appliance_id
     * @param fault
     */
    void select(int appliance_id, String fault);


    /**
     * 不选择
     * @param appliance_id
     * @param fault
     */
    void unselect(int appliance_id, String fault);
}
