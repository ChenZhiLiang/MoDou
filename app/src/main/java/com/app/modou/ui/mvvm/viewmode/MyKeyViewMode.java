package com.app.modou.ui.mvvm.viewmode;

import com.app.modou.ui.bean.KeyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: MyKeyViewMode
 * @Description: 描述
 * @CreateDate: 2019/3/20 9:48
 * @Version: 1.0
 */
public class MyKeyViewMode {

    public MyKeyViewMode(){

    }

    public List<KeyBean> getKeyDatas(){

        List<KeyBean> datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            KeyBean bean = new KeyBean();
            bean.setKey_num(getKeyNum());
            datas.add(bean);
        }

        return datas;
    }
    public List<KeyBean.KeyNum> getKeyNum(){

        List<KeyBean.KeyNum> datas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            KeyBean.KeyNum bean = new KeyBean.KeyNum();
            bean.setName(i+"号门");
            datas.add(bean);
        }
        return datas;
    }

}
