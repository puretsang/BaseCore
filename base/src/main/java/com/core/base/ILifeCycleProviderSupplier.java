package com.core.base;

import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * Created by waikeytsang on 2017/5/16.
 *  生命周期提供者持有者
 */

public interface ILifeCycleProviderSupplier<E> {
    LifecycleProvider<E> getLifecycleProvider();
}
