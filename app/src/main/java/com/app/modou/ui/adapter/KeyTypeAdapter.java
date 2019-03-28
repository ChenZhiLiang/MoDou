package com.app.modou.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.modou.R;
import com.app.modou.ui.bean.KeyBean;

import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: KeyTypeAdapter
 * @Description: 描述
 * @CreateDate: 2019/3/20 10:09
 * @Version: 1.0
 */
public class KeyTypeAdapter extends RecyclerView.Adapter<KeyTypeAdapter.KeyTypeHolder> {

    private List<KeyBean.KeyNum> mDatas;
    public KeyTypeAdapter(List<KeyBean.KeyNum> data) {
        this.mDatas = data;
    }


    @NonNull
    @Override
    public KeyTypeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_key_type_item, viewGroup, false);
        return new KeyTypeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KeyTypeHolder keyTypeHolder, int i) {
        keyTypeHolder.title.setText(mDatas.get(i).getName());
        keyTypeHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //item 点击事件
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //② 创建ViewHolder
    public static class KeyTypeHolder extends RecyclerView.ViewHolder{
        public final TextView title;
        public KeyTypeHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);
        }
    }
}
