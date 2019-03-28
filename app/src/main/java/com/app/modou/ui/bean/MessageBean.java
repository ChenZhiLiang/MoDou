package com.app.modou.ui.bean;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: MessageBean
 * @Description: 消息模型
 * @CreateDate: 2019/3/15 15:26
 * @Version: 1.0
 */
public class MessageBean {

    private String name;
    private String time;
    String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
