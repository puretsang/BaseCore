package com.core.base.module;

import android.util.Log;

import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Printer;
import com.orhanobut.logger.Settings;

/**
 * Created by waikeytsang on 2017/5/16.
 * log 打印日志
 */

public class LogUtil {
    // TODO: 2017/2/21 改为根据编译状态设置标志
    public static boolean DEBUG =  true;//BuildConfig.DEBUG;

    //    static {
//        //初始化Logger
//
//    }
    public static boolean isDebug() {
        return DEBUG;
    }

    public static void setDebug(boolean debug) {
        DEBUG = debug;
    }

    public static Settings init() {
        return Logger.init();
    }

    public static void xml(String xml) {
        if(DEBUG) Logger.xml(xml);
    }

    public static Settings init(String tag) {
        return Logger.init(tag);
    }

    public static void i(String message, Object... args) {
        if(DEBUG) Logger.i(message, args);
    }

    public static Printer t(int methodCount) {
        return Logger.t(methodCount);
    }

    public static void e(String message, Object... args) {
        if(DEBUG) Logger.e(message, args);
    }

    public static Printer t(String tag, int methodCount) {
        return Logger.t(tag, methodCount);
    }

    public static void d(String message, Object... args) {
        if(DEBUG) Logger.d(message, args);
    }

    public static void json(String json) {
        if(DEBUG) Logger.json(json);
    }

    public static Printer t(String tag) {
        return Logger.t(tag);
    }

    public static void w(String message, Object... args) {
        if(DEBUG) Logger.w(message, args);
    }

    public static void wtf(String message, Object... args) {
        if(DEBUG) Logger.wtf(message, args);
    }

    public static void v(String message, Object... args) {
        if(DEBUG) Logger.v(message, args);
    }

    public static void e(Throwable throwable, String message, Object... args) {
        if(DEBUG) Logger.e(throwable, message, args);
    }

    public static void d(String tag, String message) {
        if(DEBUG) Log.d(tag, message);
    }
}
