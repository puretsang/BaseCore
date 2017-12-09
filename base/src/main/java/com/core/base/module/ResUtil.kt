package com.ibona.businese.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import com.core.base.BaseApplication


/**
 * 资源工具
 */
object ResUtil {

    fun getDimension(@DimenRes id: Int): Float =
            BaseApplication.instance!!.resources.getDimension(id)

    fun getString(stringId: Int): String = BaseApplication.instance!!.getString(stringId)

    fun getString(stringId: Int, vararg formatArgs: Any): String =
            BaseApplication.instance!!.getString(stringId, *formatArgs)

    fun getColor(@ColorRes color: Int): Int =
            ContextCompat.getColor(BaseApplication.instance!!, color)

    fun getBoolean(@BoolRes bool: Int): Boolean =
            BaseApplication.instance!!.resources.getBoolean(bool)

    fun getInteger(@IntegerRes integer: Int): Int =
            BaseApplication.instance!!.resources.getInteger(integer)

    fun getDrawable(@DrawableRes drawableRes: Int): Drawable =
            ContextCompat.getDrawable(BaseApplication.instance!!, drawableRes)!!

    /**
     * 从属性中获取颜色，application样式
     * @param color 属性颜色id
     * *
     * @return 属性相应颜色
     */
    fun getColorOfAttr(color: Int): Int = getColorOfAttr(BaseApplication.instance(), color)

    /**
     * 从属性中获取颜色，context对应样式
     * @param color 属性颜色id
     * *
     * @return 属性相应颜色
     */
    fun getColorOfAttr(context: Context, color: Int): Int {
        val defaultColor = 0xFF000000.toInt()
        val attrsArray = intArrayOf(color)
        val typedArray = context.obtainStyledAttributes(attrsArray)
        val retColor = typedArray.getColor(0, defaultColor)
        // don't forget the resource recycling
        typedArray.recycle()
        return retColor
    }
}
