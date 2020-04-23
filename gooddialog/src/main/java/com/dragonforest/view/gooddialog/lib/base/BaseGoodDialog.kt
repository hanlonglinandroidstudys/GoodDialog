package com.dragonforest.view.gooddialog.lib.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import com.dragonforest.view.gooddialog.lib.R
import kotlinx.android.synthetic.main.gooddialog_layout_base.*

/**
 *
 * author: DragonForest
 * time: 2020/4/13
 */
open class BaseGoodDialog(context: Context) : Dialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.gooddialog_layout_base)

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setWindowAnims(R.style.BaseDialogStyle)
        setWindowGravity(Gravity.CENTER)
        setWindowSize(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setCustomView(null)
    }

    /**
     * 设置进入进出动画
     */
    open fun setWindowAnims(windowStyleAnim: Int) {
        window?.setWindowAnimations(windowStyleAnim)
    }

    /**
     * 设置窗口位置
     */
    open fun setWindowGravity(gravity: Int) {
        window?.attributes?.gravity = gravity
    }

    /**
     * 设置窗口大小
     */
    fun setWindowSize(width: Int, height: Int) {
        window?.attributes?.width = width
        window?.attributes?.height = height
    }

    /**
     * 设置是否充满屏幕宽度
     */
    fun setFillScreenWidth(){
        window?.decorView?.setBackgroundColor(Color.WHITE)
        window?.decorView?.setPadding(0,0,0,0)
    }

    /**
     * 设置自定义布局
     */
    open fun setCustomView(customView: View?) {
        if (customView == null) return
        container.removeAllViews()
        var param = LinearLayout.LayoutParams(-1, -1)
        container.addView(customView, param)
    }

    open fun setCustomView(layoutId: Int) {
        var customView = LayoutInflater.from(context).inflate(layoutId, null, false)
        setCustomView(customView)
    }


}