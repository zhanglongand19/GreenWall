package com.example.greenwall.find;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.greenwall.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
/**
 * Created by hackware on 2016/9/13.
 */

public class TestFragment1 extends Fragment {
    public static final String EXTRA_TEXT = "extra_text";
    MyJzvdStd myJzvdStd;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.simple_fragment_layout1, container, false);

        initView(view);
        return view;
    }



    private void initView(View view) {
        Button btn = (Button) view.findViewById(R.id.btn_open_wey_travel);
        Bundle bundle = getArguments();
        if (bundle != null) {
            btn.setText(bundle.getString(EXTRA_TEXT));
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myJzvdStd.startVideo();
            }
        });

        Button start=view.findViewById(R.id.btn_start_wey_video);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myJzvdStd.startVideo();
            }
        });

        String videoUrl = "https://auto.pcvideo.com.cn/pcauto/vpcauto/2017/04/24/1493017067564-vpcauto-78629-1.mp4";/*调试用*/
        myJzvdStd = (MyJzvdStd) view.findViewById(R.id.jz_video);
        myJzvdStd.setUp("https://auto.pcvideo.com.cn/pcauto/vpcauto/2017/04/24/1493017067564-vpcauto-78629-1.mp4"
                , "");
        Glide.with(getContext()).load("http://b-ssl.duitang.com/uploads/blog/201312/04/20131204184148_hhXUT.jpeg").into(myJzvdStd.thumbImageView);


    }
}
