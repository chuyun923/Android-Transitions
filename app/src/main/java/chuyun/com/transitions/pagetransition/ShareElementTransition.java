package chuyun.com.transitions.pagetransition;

import android.os.Bundle;
import android.view.View;

import chuyun.com.transitions.BaseActivity;
import chuyun.com.transitions.R;

public class ShareElementTransition extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        setTransiton();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_transition);
//        setExitSharedElementCallback(new SharedElementCallback() {
//            @Override
//            public void onSharedElementStart(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
//                findViewById(R.id.back).setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
//            }
//        });

        getWindow().getDecorView().setVisibility();
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
                findViewById(R.id.back).setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
            }
        });
    }

//    private void setTransiton() {
//        ChangeColor changeColor = new ChangeColor();
//        changeColor.setDuration(500);
//        getWindow().setSharedElementReturnTransition(changeColor);
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
