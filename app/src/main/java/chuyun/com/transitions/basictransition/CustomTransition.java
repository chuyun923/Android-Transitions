package chuyun.com.transitions.basictransition;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import chuyun.com.transitions.BaseActivity;
import chuyun.com.transitions.R;

/**
 * Date:16/7/26
 * Time:08:32
 * Author:pengliang
 */
public class CustomTransition extends BaseActivity {
    ViewGroup rootView;
    View animatorView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_transition);
        rootView = _findViewById(R.id.rootView);
        animatorView = _findViewById(R.id.animatorView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TransitionManager.beginDelayedTransition(rootView, new ChangeColor());
                animatorView.setBackgroundColor(0xff346567);
            }
        }, 2000);
    }


}
