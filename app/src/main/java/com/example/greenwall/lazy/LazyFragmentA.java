package com.example.greenwall.lazy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.greenwall.R;
import com.example.greenwall.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
public class LazyFragmentA extends BaseFragment {
    private TextView tv;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initData() {
        Log.e("initData","2");
        tv=root.findViewById(R.id.tv);
        tv.setText(View.VISIBLE);
    }
}
