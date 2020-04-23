package com.dragonforest.view.gooddialog.lib.utils

import android.content.res.Resources

/**
 *
 * author: DragonForest
 * time: 2020/4/14
 */
object ScreenUtil {
    fun getScreenWidth():Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun getScreenHeight():Int{
        return Resources.getSystem().displayMetrics.heightPixels;
    }
}