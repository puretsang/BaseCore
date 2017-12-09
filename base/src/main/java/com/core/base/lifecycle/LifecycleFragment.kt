package com.core.base.lifecycle

import com.core.base.ILifeCycleProviderSupplier
import com.trello.navi2.component.support.NaviFragment
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.navi.NaviLifecycle

/**
 * Created by waikeytsang on 2017/12/9.
 * 生命周期Fragment，提供对外的生命周期监听器
 */
class LifecycleFragment : NaviFragment(), ILifeCycleProviderSupplier<FragmentEvent> {

    protected val provider = NaviLifecycle.createFragmentLifecycleProvider(this)

    override fun getLifecycleProvider(): LifecycleProvider<FragmentEvent> = provider
}