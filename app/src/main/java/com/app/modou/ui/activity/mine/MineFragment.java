package com.app.modou.ui.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.app.modou.R;
import com.app.modou.core.base.BaseFragment;
import com.app.modou.core.eventbus.Event;
import com.app.modou.core.eventbus.EventCode;
import com.app.modou.core.helper.ToastyHelper;
import com.app.modou.core.helper.UserHelper;
import com.app.modou.ui.bean.UserInfoBean;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author: chen
 * @ProjectName: MoDou
 * @ClassName: MineFragment
 * @Description: 我的
 * @CreateDate: 2019/3/15 10:26
 * @Version: 1.0
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.tv_home_title_bar)
    TextView tv_home_title_bar;

    @BindView(R.id.rt_user)
    RelativeLayout rt_user;
    @BindView(R.id.tv_user_name)
    TextView tv_user_name;
    @BindView(R.id.tv_coupon)
    TextView tv_coupon;
    @BindView(R.id.tv_wallet)
    TextView tv_wallet;
    @BindView(R.id.tv_bank_card)
    TextView tv_bank_card;

    @BindView(R.id.tv_order)
    TextView tv_order;
    @BindView(R.id.tv_bill)
    TextView tv_bill;

    /**
     * fragment 传递参数
     * @param title
     * @return
     */
    public static MineFragment getInstance(String title) {
        MineFragment hf = new MineFragment();
        hf.mTitle = title;
        return hf;
    }
    @Override
    public int getLayoutId() {
        return R.layout.frag_mine;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        tv_home_title_bar.setText(getString(R.string.mine_centre));

    }

    @Override
    public void loadingData() {
        if (isLogin()){
            tv_user_name.setText(UserHelper.getUserInfo().getMemberInfo().getName());
        }
    }

    @OnClick({R.id.rt_user,R.id.tv_coupon,R.id.tv_wallet,R.id.tv_bank_card,R.id.tv_order,R.id.tv_bill})
    public void onClick(View view){
        if (view==rt_user){
            startActivity(new Intent(mActivity,LoginActivity.class));
        }if (view==tv_coupon){
            startActivity(new Intent(mActivity,CouponActivity.class));
        }else if (view==tv_wallet){
            startActivity(new Intent(mActivity,WalletActivity.class));
        }else if (view==tv_bank_card){
            startActivity(new Intent(mActivity,BankCardActivity.class));
        }else if (view==tv_order){
            startActivity(new Intent(mActivity,OrderActivity.class));
        }else if (view==tv_bill){
            startActivity(new Intent(mActivity,BillActivity.class));
        }
        mActivity.overridePendingTransition(R.anim.anim_right_in,R.anim.anim_right_out);
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected void receiveEvent(Event event) {
        super.receiveEvent(event);
        if (event.getCode()== EventCode.Code.LOGIN_SECCESS){
            loadingData();
            ToastyHelper.toastyNormal(mActivity,"登录成功");
        }
    }
}
