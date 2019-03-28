package com.app.modou.ui.bean;

import com.yobo.third_sdk.widget.tablayout.listener.CustomTabEntity;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: TabEntityBean
 * @Description:
 * @CreateDate: 2019/3/15 10:33
 * @Version: 1.0
 */
public class TabEntityBean implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public TabEntityBean(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}

