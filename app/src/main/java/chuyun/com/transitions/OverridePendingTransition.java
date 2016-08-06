package chuyun.com.transitions;

import android.os.Bundle;

public class OverridePendingTransition extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_override_pending_transition);

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.activity_left_in, R.anim.activity_right_out);
    }
}
