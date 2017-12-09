package com.core.base.module;


/**
 * 防止多次重复点击
 * Created by waikeytsang on 2017/12/9.
 */

public class FastClickUtils {

    private static final String LAST_CLICK_TIME = "lastClickTime";

    /**
     * 防止多次重复点击
     * false 可以点击
     * true 不响应
     */
    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        long lastClickTime = BaseSettings.Companion.getLong(LAST_CLICK_TIME, 0);
        if (time - lastClickTime < 500) {
            return true;
        }
        BaseSettings.Companion.putLong(LAST_CLICK_TIME, time);
        return false;
    }
}
