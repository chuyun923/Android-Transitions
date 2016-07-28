package chuyun.com.transitions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import chuyun.com.transitions.basictransition.BasicTransitions;
import chuyun.com.transitions.basictransition.CustomTransition;
import chuyun.com.transitions.basictransition.DelayTransitions;
import chuyun.com.transitions.basictransition.ViewOverlayActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClickListener((ViewGroup) findViewById(R.id.contianer));
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
        }
    }
}
