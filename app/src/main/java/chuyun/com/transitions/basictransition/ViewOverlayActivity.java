package chuyun.com.transitions.basictransition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;

import chuyun.com.transitions.BaseActivity;
import chuyun.com.transitions.R;

public class ViewOverlayActivity extends BaseActivity {

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_overlay);
        button = _findViewById(R.id.click_me);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ViewGroup container = (ViewGroup) button.getParent().getParent();
                container.getOverlay().add(button);

                ObjectAnimator anim = ObjectAnimator.ofFloat(button, "translationY", container.getHeight());
                ObjectAnimator rotate = ObjectAnimator.ofFloat(button, "rotation", 0, 360);
                rotate.setRepeatCount(Animation.INFINITE);
                rotate.setRepeatMode(Animation.REVERSE);
                rotate.setDuration(350);

                anim.addListener(new Animator.AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator arg0) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator arg0) {
                    }

                    @Override
                    public void onAnimationEnd(Animator arg0) {
                        container.getOverlay().remove(button);
                    }

                    @Override
                    public void onAnimationCancel(Animator arg0) {
                        container.getOverlay().remove(button);
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(anim, rotate);
                animatorSet.start();
            }
        });

    }
}
