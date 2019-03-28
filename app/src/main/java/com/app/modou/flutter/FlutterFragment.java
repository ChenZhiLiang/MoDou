package com.app.modou.flutter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: FlutterFragment
 * @Description: 描述
 * @CreateDate: 2019/3/19 9:04
 * @Version: 1.0
 */
public class FlutterFragment  {

  /*  @Override
    public void setArguments(@Nullable Bundle args) {
        if(args == null) {
            args = new Bundle();
            args.putString("tag","");
        }
        super.setArguments(args);
    }

    public void setTabTag(String tag) {
        Bundle args = new Bundle();
        args.putString("tag",tag);
        super.setArguments(args);
    }

    @Override
    public void onRegisterPlugins(PluginRegistry registry) {
        GeneratedPluginRegistrant.registerWith(registry);
    }

    @Override
    public String getContainerName() {
        return getArguments().getString("tag");
    }

    @Override
    public Map getContainerParams() {
        Map<String,String> params = new HashMap<>();
        params.put("tag",getArguments().getString("tag"));
        return params;
    }

    @Override
    public void destroyContainer() {

    }

    public static FlutterFragment instance(String tag){
        FlutterFragment fragment = new FlutterFragment();
        fragment.setTabTag(tag);
        return fragment;
    }*/
}
