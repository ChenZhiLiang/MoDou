package com.app.modou.ui.mvvm.viewmode;

import com.app.modou.ui.bean.BankCardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: BankCardViewMode
 * @Description: 银行卡viewmode
 * @CreateDate: 2019/3/20 14:36
 * @Version: 1.0
 */
public class BankCardViewMode {

    public BankCardViewMode(){

    }

    public List<BankCardBean> getBankCarDatas(){

        List<BankCardBean> datas = new ArrayList<>();
        for (int i = 0; i <2 ; i++) {
            BankCardBean bean = new BankCardBean();
            bean.setName("工商银行");
            datas.add(bean);
        }
        return datas;
    }
}
