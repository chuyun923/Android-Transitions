package chuyun.com.transitions.pagetransition;

import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import chuyun.com.transitions.BaseActivity;
import chuyun.com.transitions.R;

public class ContentTransition extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTransiton();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_transition);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
    }

    private void setTransiton() {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setAllowReturnTransitionOverlap(false);
        Slide slide = new Slide(Gravity.TOP);
        slide.setDuration(500);

        getWindow().setEnterTransition(slide);

        Slide slide1 = new Slide();
        slide1.setDuration(500);
        slide1.setSlideEdge(Gravity.RIGHT);
        getWindow().setReturnTransition(slide1);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
