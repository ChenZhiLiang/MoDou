package com.app.modou.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: ScrollLinearLayoutManager
 * @Description: 描述
 * @CreateDate: 2019/3/19 17:54
 * @Version: 1.0
 */
public class ScrollLinearLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;

    public ScrollLinearLayoutManager(Context context) {
        super(context);
    }

    public ScrollLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public ScrollLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }

}
