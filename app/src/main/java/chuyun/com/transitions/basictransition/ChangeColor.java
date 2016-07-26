package chuyun.com.transitions.basictransition;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

/**
 * Date:16/7/26
 * Time:19:59
 * Author:pengliang
 */
public class ChangeColor extends Transition {
    private static final String PROPNAME_BACKGROUND =
            "chuyun.com.transitions.basictransition:changecolor:background";

    // 开始的状态，这里会对视图树中所有的View调用，这里我们可以记录一下View的我们感兴趣的状态，比如这里：background
    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        if (transitionValues.view.getBackground() instanceof ColorDrawable) {
            captureValues(transitionValues);
        }
    }

    // 结束也会对所有的View进行调用
    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        if (transitionValues.view.getBackground() instanceof ColorDrawable) {
            captureValues(transitionValues);
        }
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        transitionValues.values.put(PROPNAME_BACKGROUND, ((ColorDrawable) transitionValues.view.getBackground()).getColor());
    }

    //新建动画
    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        if (null == startValues || null == endValues) {
            return null;
        }
        final View view = endValues.view;
        int startBackground = (Integer) startValues.values.get(PROPNAME_BACKGROUND);
        int endBackground = (Integer) endValues.values.get(PROPNAME_BACKGROUND);

        if (startBackground != endBackground) {
            ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(),
                    startBackground, endBackground);
            animator.setDuration(1000);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Object value = animation.getAnimatedValue();
                    if (null != value) {
                        view.setBackgroundColor((Integer) value);
                    }
                }
            });
            return animator;
        }
        return null;
    }

    //返回我们定义的一些存储Key，注意，这里一定要复写
    @Override
    public String[] getTransitionProperties() {
        return new String[]{
                PROPNAME_BACKGROUND
        };
    }
}
