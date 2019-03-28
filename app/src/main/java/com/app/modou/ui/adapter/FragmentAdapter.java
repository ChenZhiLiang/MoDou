package com.app.modou.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: FragmentAdapter
 * @Description: 描述
 * @CreateDate: 2019/3/19 16:06
 * @Version: 1.0
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private String [] title;
    private List<Fragment> fragmentList;
    public FragmentAdapter(FragmentManager fm,List<Fragment> fragmentList,String [] title) {
        super(fm);
        this.fragmentList = fragmentList;
        this.title = title;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
