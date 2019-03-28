package com.app.modou.ui.mvvm;

import com.app.modou.ui.bean.MessageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: MessageViewMode
 * @Description: 描述
 * @CreateDate: 2019/3/15 15:46
 * @Version: 1.0
 */
public class MessageViewMode {

    public MessageViewMode(){

    }

    public List<MessageBean> getMessageDatas(){

        List<MessageBean> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MessageBean bean = new MessageBean();
            bean.setName("物业公告:"+i);
            datas.add(bean);
        }
        return datas;
    }
}
