package chuyun.com.transitions.basictransition;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import chuyun.com.transitions.BaseActivity;
import chuyun.com.transitions.R;

/**
 * Date:16/7/25
 * Time:23:47
 * Author:pengliang
 */
public class DelayTransitions extends BaseActivity {

    Handler handler;
    private ViewGroup rootView;
    private View circulView1, circulView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delay_transition);
        rootView = _findViewById(R.id.rootView);
        circulView1 = _findViewById(R.id.circulView1);
        circulView2 = _findViewById(R.id.circulView2);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goDelayTransition();
            }
        }, 3000);
    }

    private void goDelayTransition() {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(1000);
        TransitionManager.beginDelayedTransition(rootView, changeBounds);
        ViewGroup.LayoutParams layoutParams = circulView1.getLayoutParams();
        layoutParams.height = 400;
        layoutParams.width = 400;
        circulView1.setLayoutParams(layoutParams);

        ViewGroup.LayoutParams layoutParams2 = circulView2.getLayoutParams();
        layoutParams2.height = 100;
        layoutParams2.width = 100;
        circulView2.setLayoutParams(layoutParams2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
