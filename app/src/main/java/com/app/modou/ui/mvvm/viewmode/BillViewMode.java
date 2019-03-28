package com.app.modou.ui.mvvm.viewmode;

import com.app.modou.ui.bean.BillBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: BillViewMode
 * @Description: 描述
 * @CreateDate: 2019/3/21 11:11
 * @Version: 1.0
 */
public class BillViewMode {

    public BillViewMode(){

    }

    public List<BillBean> getBillDatas(){

        List<BillBean> datas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            BillBean bean = new BillBean();
            datas.add(bean);
        }
        return datas;
    }
}
