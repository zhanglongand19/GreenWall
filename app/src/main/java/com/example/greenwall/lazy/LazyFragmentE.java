package com.example.greenwall.lazy;

import android.view.View;
import android.widget.TextView;

import com.example.greenwall.R;
import com.example.greenwall.base.BaseFragment;

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
public class LazyFragmentE extends BaseFragment {
    private TextView tv;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initData() {

        tv=root.findViewById(R.id.tv);
        tv.setText(View.VISIBLE);
    }
}
