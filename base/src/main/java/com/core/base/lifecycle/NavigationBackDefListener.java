package com.core.base.lifecycle;

import android.app.Activity;
import android.view.View;

/**
 * Created by waikeytsang on 2017/5/16.
 *  导航返回默认监听器
 */

public class NavigationBackDefListener implements View.OnClickListener {
    private final Activity activity;

    public NavigationBackDefListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.onBackPressed();
    }
}
