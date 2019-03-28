package com.app.modou.ui.mvvm;

import com.app.modou.ui.bean.AdvertBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: HomeViewMode
 * @Description: 首页请求数据处理 viewmode
 * @CreateDate: 2019/3/15 14:24
 * @Version: 1.0
 */
public class HomeViewMode {

    String []image_url = {"http://m.mdyichuxing.cn/repository/image/kGxQ3DOeQfyj6s31XkvKJQ.jpg","http://m.mdyichuxing.cn/repository/image/WGJ9YSrfTV-U09bYpVyYLw.jpg"};

    public HomeViewMode(){

    }

    public List<AdvertBean> getAdvDatas(){

        List<AdvertBean> datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            AdvertBean bean = new AdvertBean();
            bean.setName("广告"+i);
            bean.setImage_url(image_url[i]);
            datas.add(bean);
        }
        return datas;
    }
}
