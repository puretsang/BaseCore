package com.core.base.lifecycle;

import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.view.View;

/**
 * Created by waikeytsang on 2017/5/16.
 *   导航Home默认监听器
 */

public class NavigationHomeDefListener implements View.OnClickListener {
    private final Activity activity;

    public NavigationHomeDefListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        NavUtils.navigateUpFromSameTask(activity);
    }
}
