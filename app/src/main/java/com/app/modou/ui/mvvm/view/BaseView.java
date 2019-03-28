package com.app.modou.ui.mvvm.view;

/**
 * Created by Administrator on 2017-11-06.
 */

public interface BaseView {

    void showProgress();

    void hideProgress();

    void showLoadFailMsg(String err);
}
