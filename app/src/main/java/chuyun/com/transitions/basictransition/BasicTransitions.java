package chuyun.com.transitions.basictransition;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import chuyun.com.transitions.BaseActivity;
import chuyun.com.transitions.R;

public class BasicTransitions extends BaseActivity implements View.OnClickListener {


    private static final String TAG = "BasicTransitions";
    ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_transitions);
        rootView = _findViewById(R.id.rootView);

        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(1500);

        findViewById(R.id.begin).setOnClickListener(this);
        findViewById(R.id.addtarget).setOnClickListener(this);
//        findViewById(R.id.delayTransition).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.begin:
                defaultTransition();
                break;
            case R.id.addtarget:
                addTarget();
                break;
//            case R.id.delayTransition:
//                delayTransition();
//                break;
        }
    }

    private void defaultTransition() {
        Scene scene2 = Scene.getSceneForLayout(rootView, R.layout.scene2, BasicTransitions.this);
        TransitionManager.go(scene2, new ChangeBounds());
    }

    private void addTarget() {
        Scene scene2 = Scene.getSceneForLayout(rootView, R.layout.scene2, BasicTransitions.this);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.addTarget(R.id.image1);
        TransitionManager.go(scene2, changeBounds);
    }

//    private void delayTransition() {
//
//        Transition transition = new AutoTransition();
//        transition.addListener(new Transition.TransitionListener() {
//            @Override
//            public void onTransitionStart(Transition transition) {
//
//            }
//
//            @Override
//            public void onTransitionEnd(Transition transition) {
//
//                TransitionSet transitionSet = new TransitionSet();
//                transitionSet.setDuration(1000);
//                ChangeBounds changeBounds = new ChangeBounds();
//                changeBounds.setDuration(1000);
//                transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);
//                transitionSet.addTransition(changeBounds);
//                Fade fade = new Fade();
//                fade.setDuration(1000);
//                transitionSet.addTransition(fade);
//
//                TransitionManager.beginDelayedTransition(rootView,transitionSet);
//                rootView.findViewById(R.id.contianer).setVisibility(View.VISIBLE);
//                ViewGroup.LayoutParams layoutParams = rootView.findViewById(R.id.image1).getLayoutParams();
//                layoutParams.height = 800;
//                layoutParams.width = 800;
//                rootView.findViewById(R.id.image1).setLayoutParams(layoutParams);
//            }
//
//            @Override
//            public void onTransitionCancel(Transition transition) {
//
//            }
//
//            @Override
//            public void onTransitionPause(Transition transition) {
//
//            }
//
//            @Override
//            public void onTransitionResume(Transition transition) {
//
//            }
//        });
//        TransitionManager.beginDelayedTransition(rootView,transition);
//        rootView.findViewById(R.id.contianer).setVisibility(View.GONE);
//    }
}
