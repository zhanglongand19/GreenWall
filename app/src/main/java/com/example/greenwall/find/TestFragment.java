package com.example.greenwall.find;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.greenwall.R;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by hackware on 2016/9/13.
 */

public class TestFragment extends Fragment {
    public static final String EXTRA_TEXT = "extra_text";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        Button btn = (Button) view.findViewById(R.id.btn_rx);
        Bundle bundle = getArguments();
        if (bundle != null) {
            textView.setText(bundle.getString(EXTRA_TEXT));
        }
        test_1();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                test_1();
            }
        });
    }
    Observable<String> oble;//Observable（被观察者）
    Observer<String> oser;//  Observer（观察者）
    private void test_1() {
       oble = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("hello");
                e.onNext(test());
               // e.onNext(error());
                e.onComplete();

            }
        });

       oser = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.w("kaelpu","onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.w("kaelpu","onNext = "+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.w("kaelpu","onError" + e);
            }

            @Override
            public void onComplete() {
                Log.w("kaelpu","onComplete");
            }
        };

        Log.w("kaelpu","subscribe");
        oble.subscribe(oser);//Subscriber （订阅）

    }

    private String error() throws Exception {
        throw new Exception();
    }

    private String test()  {
        return "test";
    }
}
