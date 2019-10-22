package com.example.greenwall.about;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.greenwall.R;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/**
 * <p>Title      : []_[Object]</p>
 * <p>Description:
 * <p>Copyright  : Copyright (c) 2019-10-15</p>
 * <p>Company    : 北京四维图新科技股份有限公司</p>
 * <p>Department : </p>
 *
 * @author : zhanglong
 * @version : 1.0
 */
public class CustomBottomBarView extends LinearLayout implements View.OnClickListener {
    private Context mContext;
    private CustomTabEnum currentTab = CustomTabEnum.FIND;
    private OnBottomSwitchListener onBottomSwitchListener;

    private TextView weyTv, findTv, mineTv, serveTv,shopTv;
    private ImageView weyIv, findIv, mineIv, serveIv,shopIv;
    private LinearLayout weyLnl, findLnl, serveLnl, mineLnl,shopLnl;


    public CustomBottomBarView(Context context) {
        super(context);
        this.mContext = context;
    }

    public CustomBottomBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.main_bottom_bar_vlayout, this, true);
        initView(view);
        updateView();
    }
    private void initView(View view) {
        if(view == null) {
            return;
        }

        weyLnl = (LinearLayout) view.findViewById(R.id.main_bottom_wey_lnl);
        findLnl = (LinearLayout) view.findViewById(R.id.main_bottom_find_lnl);
        mineLnl = (LinearLayout) view.findViewById(R.id.main_bottom_mine_lnl);
        serveLnl = (LinearLayout) view.findViewById(R.id.main_bottom_serve_lnl);
        shopLnl = view.findViewById(R.id.main_bottom_shop_lnl);

        weyIv = (ImageView) view.findViewById(R.id.main_bottom_wey_iv);
        findIv = (ImageView) view.findViewById(R.id.main_bottom_find_iv);
        mineIv = (ImageView) view.findViewById(R.id.main_bottom_mine_iv);
        serveIv = (ImageView) view.findViewById(R.id.main_bottom_serve_iv);
        shopIv = (ImageView) view.findViewById(R.id.main_bottom_shop_iv);

        weyTv = (TextView) view.findViewById(R.id.main_bottom_wey_tv);
        findTv = (TextView) view.findViewById(R.id.main_bottom_find_tv);
        mineTv = (TextView) view.findViewById(R.id.main_bottom_mine_tv);
        serveTv = (TextView) view.findViewById(R.id.main_bottom_serve_tv);
        shopTv = (TextView) view.findViewById(R.id.main_bottom_shop_tv);

        weyLnl.setOnClickListener(this);
        findLnl.setOnClickListener(this);
        mineLnl.setOnClickListener(this);
        serveLnl.setOnClickListener(this);
        shopLnl.setOnClickListener(this);
    }

    public void setOnBottomSwitchListener(OnBottomSwitchListener onBottomSwitchListener) {
        this.onBottomSwitchListener = onBottomSwitchListener;
    }

    @Override
    public void onClick(View v) {
        if(v == null) {
            return;
        }

        switch (v.getId()) {
            case R.id.main_bottom_wey_lnl:
                setCurrentTab(CustomTabEnum.SHOW);
                break;
            case R.id.main_bottom_find_lnl:
                setCurrentTab(CustomTabEnum.FIND);
                break;
            case R.id.main_bottom_mine_lnl:
                setCurrentTab(CustomTabEnum.MINE);
                break;
            case R.id.main_bottom_serve_lnl:
                setCurrentTab(CustomTabEnum.SERVE);
                break;
            case R.id.main_bottom_shop_lnl:
                setCurrentTab(CustomTabEnum.SHOP);
                break;
            default:
                break;
        }
    }
    public void setCurrentTab(CustomTabEnum tabEnum) {

        if(currentTab == tabEnum) {
            return;
        }

        currentTab = tabEnum;
        updateView();
        if(onBottomSwitchListener != null) {
            onBottomSwitchListener.onBottomSwitch(currentTab);
        }
    }

    private void updateView() {

        weyIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tabbar_i_car_and));

        findIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tab_i_find_and));

        serveIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tab_i_serve_and));

        shopIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tabbar_i_shop));

//            mineIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tab4_hui_red_and));
            mineIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tab_i_my_and));

        setUnSelect(weyTv);
        setUnSelect(findTv);
        setUnSelect(mineTv);
        setUnSelect(serveTv);
        setUnSelect(shopTv);

        switch (currentTab) {
            case SHOW:
                weyIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tabbar_i_carsel_and));
                setSelect(weyTv);
                break;
            case FIND:
                findIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tab_i_find_sel_and));
//                findIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tab_i_find_sel_2019));
                setSelect(findTv);
                break;
            case SHOP:
                shopIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tabbar_i_shop_checked));
                setSelect(shopTv);
                break;
            case MINE:
//                    mineIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tab4_sel_red_and));
                    mineIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tab_i_my_sel_and));
                setSelect(mineTv);
                break;
            case SERVE:
                serveIv.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.tab_i_serve_sel_and));
                setSelect(serveTv);
                break;
            default:
                break;
        }
    }

    private void setSelect(TextView tv) {
        if(tv == null) {
            return;
        }
        tv.setTextColor(ContextCompat.getColor(getContext(), R.color.moudle_main_text_select_color));
    }

    private void setUnSelect(TextView tv) {
        if(tv == null) {
            return;
        }
        tv.setTextColor(ContextCompat.getColor(getContext(), R.color.moudle_main_text_unselect_color));
    }
}
