package com.core.base.lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * * 带导航相关功能，返回按钮和Home按钮
 */

public abstract class NavigationActivity extends  LifecycleActivity {
    private View.OnClickListener backListener;
    private View.OnClickListener homeListener;

    private View backView, homeView;
    private int visibilityBackView, visibilityHomeView;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setBackDef();
        setHomeDef();
        initByConfig();
    }

    public void setBackListener(View.OnClickListener listener) {
        backView = getNavigationBackView();
        if(backView == null) return;
        backListener = listener;
        backView.setOnClickListener(listener);
    }

    public void setHomeListener(View.OnClickListener listener) {
        homeView = getNavigationHomeView();
        if(homeView == null) return;
        homeListener = listener;
        homeView.setOnClickListener(listener);
    }

    @Nullable
    protected View getNavigationBackView() {
        // FIXME: 2017/12/9 自己定义的返回键
        return null;//findViewById(R.id.backView);
    }

    @Nullable
    protected View getNavigationHomeView() {
        // FIXME: 2017/12/9 自己定义的Home
        return null;//findViewById(R.id.homeView);
    }

    private void setBackDef() {
        View view = getNavigationBackView();
        if(view == null) return;
        if(backListener == null) setBackListener(new NavigationBackDefListener(this));
    }

    private void setHomeDef() {
        View view = getNavigationHomeView();
        if(view == null) return;
        if(homeListener == null) setHomeListener(new NavigationHomeDefListener(this));
    }

    public int getVisibilityBackView() {
        if(backView!=null) return backView.getVisibility();
        return visibilityBackView;
    }

    public void setVisibilityBackView(int visibility) {
        this.visibilityBackView = visibility;
        if(backView!=null) backView.setVisibility(visibility);
    }

    public int getVisibilityHomeView() {
        if(homeView != null) return homeView.getVisibility();
        return visibilityHomeView;
    }

    public void setVisibilityHomeView(int visibility) {
        this.visibilityHomeView = visibility;
        if(homeView != null) homeView.setVisibility(visibility);
    }

    private void initByConfig() {
        if(backView!=null) backView.setVisibility(visibilityBackView);
        if(homeView!=null) homeView.setVisibility(visibilityHomeView);
    }
}
