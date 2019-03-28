package com.app.modou.ui.adapter;

import android.view.View;

import com.app.modou.R;
import com.app.modou.core.base.BaseHolder;
import com.app.modou.core.base.BaseXRecyclerViewAdapter;
import com.app.modou.ui.adapter.holder.MessageHolder;
import com.app.modou.ui.bean.MessageBean;

import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: MessageAdapter
 * @Description: 消息适配器
 * @CreateDate: 2019/3/15 15:25
 * @Version: 1.0
 */
public class MessageAdapter extends BaseXRecyclerViewAdapter<MessageBean> {


    public MessageAdapter(List<MessageBean> data) {
        super(data);
    }

    @Override
    public BaseHolder<MessageBean> getHolder(View v) {
        return new MessageHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_message_item;
    }
}
