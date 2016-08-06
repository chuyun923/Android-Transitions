package chuyun.com.transitions;

import android.app.ActivityOptions;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.util.List;

import chuyun.com.transitions.basictransition.BasicTransitions;
import chuyun.com.transitions.basictransition.ChangeColor;
import chuyun.com.transitions.basictransition.CustomTransition;
import chuyun.com.transitions.basictransition.DelayTransitions;
import chuyun.com.transitions.basictransition.ViewOverlayActivity;
import chuyun.com.transitions.pagetransition.ContentTransition;
import chuyun.com.transitions.pagetransition.ShareElementTransition;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTransiton();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClickListener((ViewGroup) findViewById(R.id.contianer));

        setExitSharedElementCallback(new SharedElementCallback() {
            @Override
            public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
                findViewById(R.id.share_Transition).setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        });
    }

    private void setOnClickListener(ViewGroup container) {
        for (int i=0;i<container.getChildCount();i++) {
            container.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basic_transition:
                startActivity(new Intent(MainActivity.this, BasicTransitions.class));
                break;
            case R.id.delay_transition:
                startActivity(new Intent(MainActivity.this, DelayTransitions.class));
                break;
            case R.id.custom_transition:
                startActivity(new Intent(MainActivity.this, CustomTransition.class));
                break;
            case R.id.view_overlay:
                startActivity(new Intent(MainActivity.this, ViewOverlayActivity.class));
                break;
            case R.id.overridePendingTransition:
                startActivity(new Intent(MainActivity.this, OverridePendingTransition.class));
                overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);
                break;
            case R.id.content_Transition:
                startActivity(new Intent(MainActivity.this, ContentTransition.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.share_Transition:
                startActivity(new Intent(MainActivity.this, ShareElementTransition.class), ActivityOptions.makeSceneTransitionAnimation(this, v, "share").toBundle());
                v.setBackgroundColor(0xff348902);
                break;
        }
    }

    private void setTransiton() {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setAllowReturnTransitionOverlap(false);
        Fade fade = new Fade();
        fade.setDuration(800);
        getWindow().setExitTransition(fade);


        Slide slide = new Slide(Gravity.BOTTOM);
        slide.setDuration(500);
        getWindow().setReenterTransition(slide);
        ChangeColor changeColor = new ChangeColor();
        changeColor.setDuration(800);
        getWindow().setSharedElementExitTransition(changeColor);

    }
}
