package com.app.modou.ui.mvvm.viewmode;

import com.app.modou.ui.bean.CouponBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: CouponViewMode
 * @Description: 描述
 * @CreateDate: 2019/3/20 11:22
 * @Version: 1.0
 */
public class CouponViewMode {

    public CouponViewMode(){

    }

    public List<CouponBean> getCouponDatas(){

        List<CouponBean> datas = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            CouponBean bean  = new CouponBean();
            datas.add(bean);
        }
        return datas;
    }
}
