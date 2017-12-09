package com.core.base.module;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.core.base.BaseApplication;


/**
 * Created by waikeytsang on 2017/6/14.
 * 网络监听器
 */

public class NetWorkHelper {

    //监测网络是否连接
    public static boolean isNetConnected() {
        ConnectivityManager cm = (ConnectivityManager) BaseApplication.Companion.instance().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            //需要添加 ACCESS_NETWORK_STATE 权限
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return networkInfo.isConnected();
        }
        return false;
    }


}
