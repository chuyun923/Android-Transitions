package chuyun.com.transitions;

import android.support.v7.app.AppCompatActivity;

/**
 * Date:16/7/25
 * Time:23:56
 * Author:pengliang
 */
public class BaseActivity extends AppCompatActivity {

    protected <T> T _findViewById(int viewId) {
        return (T) findViewById(viewId);
    }
}
