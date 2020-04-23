package com.dragonforest.view.gooddialog.lib.styledialogs.alert

import android.content.Context
import android.os.Bundle
import com.dragonforest.view.gooddialog.lib.R
import com.dragonforest.view.gooddialog.lib.base.BaseGoodDialog

/**
 *
 * author: DragonForest
 * time: 2020/4/14
 */
class GoodAlertDialog(context: Context):BaseGoodDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCustomView(R.layout.gooddialog_alert1)
        setWindowAnims(R.style.DialogXScaleShowStyle)
//        setWindowAnims(R.style.DialogRotateStyle)
    }
}