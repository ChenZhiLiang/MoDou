package com.app.modou.ui.bean;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: KeyBean
 * @Description: 钥匙模型
 * @CreateDate: 2019/3/20 9:37
 * @Version: 1.0
 */
public class KeyBean {

    private String name;
    private List<KeyNum> key_num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<KeyNum> getKey_num() {
        return key_num;
    }

    public void setKey_num(List<KeyNum> key_num) {
        this.key_num = key_num;
    }

    public static class KeyNum  {

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
