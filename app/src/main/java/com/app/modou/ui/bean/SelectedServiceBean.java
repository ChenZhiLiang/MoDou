package com.app.modou.ui.bean;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: SelectedServiceBean
 * @Description: 描述
 * @CreateDate: 2019/3/22 15:42
 * @Version: 1.0
 */
public class SelectedServiceBean {

    private int id;
    private String name;
    String fault;
    int index;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
