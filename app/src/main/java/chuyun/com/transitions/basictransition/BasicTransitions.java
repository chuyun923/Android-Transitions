package chuyun.com.transitions.basictransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;

import chuyun.com.transitions.R;

public class BasicTransitions extends AppCompatActivity {

    ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_transitions);
        rootView =(ViewGroup) findViewById(R.id.rootView);

        findViewById(R.id.begin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scene scene2 = Scene.getSceneForLayout(rootView,R.layout.scene2,BasicTransitions.this);
                TransitionManager.go(scene2,new ChangeBounds());
            }
        });
    }
}
