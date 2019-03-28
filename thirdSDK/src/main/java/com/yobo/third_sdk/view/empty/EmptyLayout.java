package com.yobo.third_sdk.view.empty;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yobo.third_sdk.R;
import com.yobo.third_sdk.utils.SystemToolUtil;

/**
 * Created by hjt on 2016/7/20.
 * EmptyLayout 网络出错，加载数据为空
 */
public class EmptyLayout extends LinearLayout implements View.OnClickListener {

    public static final int NETWORK_ERROR = 1;//网络出错
    public static final int NETWORK_LOADING = 2;//加载中
    public static final int NODATA = 3;//加载数据为空
    public static final int HIDE_LAYOUT = 4;//隐藏layout
    public static final int NODATA_ENABLE_CLICK = 5;//加载数据为空，继续点击

    private boolean clickEnable = true;
    private OnClickListener listener;
    private final Context mContext;
    public ImageView img;
    private int mErrorState;
    private TextView tv;

    public EmptyLayout(Context context)
    {
        super(context);
        this.mContext = context;
        init();
    }
    public EmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext, R.layout.view_empty_layout, null);
        img = (ImageView) view.findViewById(R.id.img_error_layout);
        tv = (TextView) view.findViewById(R.id.tv_error_layout);
        setBackgroundColor(-1);
        setOnClickListener(this);
        img.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clickEnable) {
                    if (listener != null)
                        listener.onClick(v);
                }
            }
        });
        addView(view);
    }

    public void dismiss() {
        mErrorState = HIDE_LAYOUT;
        setVisibility(View.GONE);
    }

    public int getErrorState() {
        return mErrorState;
    }

    public boolean isLoadError() {
        return mErrorState == NETWORK_ERROR;
    }

    public boolean isLoading() {
        return mErrorState == NETWORK_LOADING;
    }

    @Override
    public void onClick(View v) {
        if (clickEnable) {
            if (listener != null)
                listener.onClick(v);
        }
    }

    /**
     * 设置文字
     * @param msg
     */
    public void setErrorMessage(String msg) {
        tv.setText(msg);
    }

    /**
     * 设置图片背景
     * @param imgResource
     */
    public void setErrorImag(int imgResource) {
        try {
            img.setImageResource(imgResource);
        } catch (Exception e) {
        }
    }

    /**
     * 状态
     * @param i
     */
    public void setErrorType(int i) {
        setVisibility(View.VISIBLE);
        switch (i) {
            case NETWORK_ERROR:
                mErrorState = NETWORK_ERROR;
                if (SystemToolUtil.checkNet(mContext)) {
                    tv.setText(R.string.error_view_load_error_click_to_refresh);
                    img.setBackgroundResource(R.mipmap.pagefailed_bg);
                } else {
                    tv.setText(R.string.error_view_network_error_click_to_refresh);
                    img.setBackgroundResource(R.mipmap.page_icon_network);
                }
                img.setVisibility(View.VISIBLE);
                clickEnable = true;
                break;
            case NETWORK_LOADING:
                mErrorState = NETWORK_LOADING;
                img.setVisibility(View.GONE);
                tv.setText(R.string.error_view_loading);
                clickEnable = false;
                break;
            case NODATA:
                mErrorState = NODATA;
                img.setBackgroundResource(R.mipmap.page_icon_empty);
                img.setVisibility(View.VISIBLE);
                clickEnable = true;
                break;
            case HIDE_LAYOUT:
                setVisibility(View.GONE);
                break;
            case NODATA_ENABLE_CLICK:
                mErrorState = NODATA_ENABLE_CLICK;
                img.setBackgroundResource(R.mipmap.page_icon_empty);
                img.setVisibility(View.VISIBLE);
                clickEnable = true;
                break;
            default:
                break;
        }
    }

    /**
     * 没有数据文字
     * @param noDataContent
     */
    public void setNoDataContent(String noDataContent) {
        if (!TextUtils.isEmpty(noDataContent))
            tv.setText(noDataContent);
        else
            tv.setText(R.string.error_view_no_data);
    }

    /**
     *  外部点击事件
     * @param listener
     */
    public void setOnLayoutClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == View.GONE)
            mErrorState = HIDE_LAYOUT;
    }
}
