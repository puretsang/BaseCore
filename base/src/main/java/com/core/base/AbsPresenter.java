package com.core.base;

import android.support.annotation.NonNull;

import com.trello.navi2.Event;
import com.trello.navi2.Listener;
import com.trello.navi2.NaviComponent;
import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * Created by waikeytsang on 2017/5/16.
 * 抽象的Presenter类
 */

public class AbsPresenter<V> implements NaviComponent, ILifeCycleProviderSupplier {

    protected final V view;
    protected NaviComponent naviComponent;

    protected LifecycleProvider<?> provider;

    public AbsPresenter(@NonNull V view) {
        this.view = view;
        if (view instanceof NaviComponent) {
            naviComponent = (NaviComponent) view;
        }
        if (view instanceof ILifeCycleProviderSupplier) {
            provider = ((ILifeCycleProviderSupplier) view).getLifecycleProvider();
        }
    }

    @Override
    public final boolean handlesEvents(Event... events) {
        return naviComponent.handlesEvents(events);
    }

    @Override
    public final <T> void addListener(@NonNull Event<T> event, @NonNull Listener<T> listener) {
        naviComponent.addListener(event, listener);
    }

    @Override
    public final <T> void removeListener(@NonNull Listener<T> listener) {
        naviComponent.removeListener(listener);
    }

    @Override
    public LifecycleProvider<?> getLifecycleProvider() {
        return provider;
    }
}
