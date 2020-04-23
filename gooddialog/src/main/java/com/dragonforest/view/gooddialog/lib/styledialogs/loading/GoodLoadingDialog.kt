package com.dragonforest.view.gooddialog.lib.styledialogs.loading

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import com.dragonforest.view.gooddialog.lib.R
import com.dragonforest.view.gooddialog.lib.base.BaseGoodDialog
import kotlinx.android.synthetic.main.gooddialog_loading1.*

/**
 *
 * author: DragonForest
 * time: 2020/4/15
 */
class GoodLoadingDialog(context: Context) : BaseGoodDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setCustomView(R.layout.gooddialog_loading1)
        setWindowAnims(R.style.DialogFadeShowStyle)
        setWindowSize(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun show() {
        super.show()
        loadView?.startLoading()
        tv_loading_msg.text = "努力加载中..."
    }

}