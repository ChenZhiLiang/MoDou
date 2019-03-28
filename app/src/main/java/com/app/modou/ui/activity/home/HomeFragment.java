package com.app.modou.ui.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.app.modou.R;
import com.app.modou.core.base.BaseFragment;
import com.app.modou.core.helper.GlideHelper;
import com.app.modou.core.helper.ToastyHelper;
import com.app.modou.ui.bean.AdvertBean;
import com.app.modou.ui.mvvm.HomeViewMode;
import com.yobo.third_sdk.widget.bgabanner.BGABanner;
import com.yobo.third_sdk.widget.uitrarefresh.UTRefreshLayout;
import com.yobo.third_sdk.widget.uitrarefresh.ptr.PtrDefaultHandler;
import com.yobo.third_sdk.widget.uitrarefresh.ptr.PtrFrameLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: HomeFragment
 * @Description: 首页
 * @CreateDate: 2019/3/15 10:24
 * @Version: 1.0
 */
public class HomeFragment extends BaseFragment implements BGABanner.Adapter<ImageView, AdvertBean>, BGABanner.Delegate<ImageView, AdvertBean> {

    @BindView(R.id.tv_home_title_bar)
    TextView tv_home_title_bar;
    /*广告布局*/
    @BindView(R.id.banner_home_adv)
    BGABanner advBanner;
    @BindView(R.id.refresh_layout)
    UTRefreshLayout refresh_layout;

    @BindView(R.id.tv_my_car)
    TextView tv_my_car;//我的车辆
    @BindView(R.id.tv_open_door)
    TextView tv_open_door;//一键开门
    @BindView(R.id.tv_property_fee)
    TextView tv_property_fee;//物业缴费
    @BindView(R.id.tv_public_service)
    TextView tv_public_service;//公共报修
    @BindView(R.id.tv_household_service)
    TextView tv_household_service;//家政服务
    @BindView(R.id.tv_business_district)
    TextView tv_business_district;//500米商圈
    private HomeViewMode mHomeViewMode;
    /**
     * fragment 传递参数
     * @param title
     * @return
     */
    public static HomeFragment getInstance(String title) {
        HomeFragment hf = new HomeFragment();
        hf.mTitle = title;
        return hf;
    }
    @Override
    public int getLayoutId() {
        return R.layout.frag_home;
    }
    @Override
    public void initView(View view, Bundle savedInstanceState) {
        tv_home_title_bar.setText(getString(R.string.user_centre));
        //左右滑动时刷新控件禁止掉
        refresh_layout.disableWhenHorizontalMove(true);
        refresh_layout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                refresh_layout.refreshComplete();
            }
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                ViewGroup viewGroup = (ViewGroup) content;
                if (viewGroup instanceof ScrollView) {
                    return viewGroup.getScrollY() == 0;
                } else {
                    return true;
                }
            }
        });

        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) advBanner.getLayoutParams(); //取控件textView当前的布局参数
        linearParams.height =  (int)(dm.widthPixels/2.5);// 控件的高强制设成20
        linearParams.width =  dm.widthPixels ;// 控件的宽强制设成30
        advBanner.setLayoutParams(linearParams); //使设置好的布局参数应用到控件
        advBanner.setAdapter(this);
        advBanner.setDelegate(this);

        mHomeViewMode = new HomeViewMode();
    }
    @Override
    public void loadingData() {

        advBanner.setData(mHomeViewMode.getAdvDatas(), null);
    }

    @Override
    public void onBannerItemClick(BGABanner banner, ImageView itemView, AdvertBean model, int position) {

        ToastyHelper.toastyNormal(mActivity,"点击了"+model.getName());
    }

    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, AdvertBean model, int position) {
        GlideHelper.loadImageView(mActivity, model.getImage_url(), itemView);
    }

    @OnClick({R.id.tv_my_car,R.id.tv_open_door,R.id.tv_property_fee,R.id.tv_public_service,R.id.tv_household_service,R.id.tv_business_district})
    public void onClick(View v){

        if (v==tv_my_car){
            startActivity(new Intent(mActivity,ParkingManagementActivity.class));
            mActivity.overridePendingTransition(R.anim.anim_right_in,R.anim.anim_right_out);
//            ToastyHelper.toastyNormal(mActivity,"我的车辆");
        }else if (v==tv_open_door){
//            ToastyHelper.toastyNormal(mActivity,"一键开门");
            startActivity(new Intent(mActivity,MyKeyActivity.class));
            mActivity.overridePendingTransition(R.anim.anim_right_in,R.anim.anim_right_out);

        }else if (v==tv_property_fee){
//            ToastyHelper.toastyNormal(mActivity,"物业缴费");
            startActivity(new Intent(mActivity,SelectVillageActivity.class));

        }else if (v==tv_public_service){
//            PageRouter.openPageByUrl(mActivity, PageRouter.NATIVE_PAGE_URL);
//            ToastyHelper.toastyNormal(mActivity,"公共报修");
            startActivity(new Intent(mActivity,PublicReapairActivity.class));
            mActivity.overridePendingTransition(R.anim.anim_right_in,R.anim.anim_right_out);

        }else if (v==tv_household_service){
//            ToastyHelper.toastyNormal(mActivity,"家政服务");
            startActivity(new Intent(mActivity,HouseholdServiceActivity.class));

        }else if (v==tv_business_district){
            ToastyHelper.toastyNormal(mActivity,"500米商圈");

        }
    }
}
