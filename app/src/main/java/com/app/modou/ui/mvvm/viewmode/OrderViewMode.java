package com.app.modou.ui.mvvm.viewmode;

import com.app.modou.ui.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: OrderViewMode
 * @Description: 描述
 * @CreateDate: 2019/3/20 17:17
 * @Version: 1.0
 */
public class OrderViewMode {

    public OrderViewMode(){

    }

    public List<OrderBean> getOrder(){

        List<OrderBean> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            OrderBean bean = new OrderBean();
            datas.add(bean);
        }
        return datas;
    }
}
