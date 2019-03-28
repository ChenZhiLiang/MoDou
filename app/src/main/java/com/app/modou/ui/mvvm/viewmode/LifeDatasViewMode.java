package com.app.modou.ui.mvvm.viewmode;

import com.app.modou.ui.bean.LifeDatasBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: LifeDatasViewMode
 * @Description: 描述
 * @CreateDate: 2019/3/19 17:44
 * @Version: 1.0
 */
public class LifeDatasViewMode {


    public LifeDatasViewMode(){

    }

    public List<LifeDatasBean> getDatas(){

        List<LifeDatasBean> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LifeDatasBean bean = new LifeDatasBean();
            bean.setName("蝗灾罗师傅");
            datas.add(bean);
        }
        return datas;
    }

}
