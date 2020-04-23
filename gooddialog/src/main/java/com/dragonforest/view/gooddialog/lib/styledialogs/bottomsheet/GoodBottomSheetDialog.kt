package com.dragonforest.view.gooddialog.lib.styledialogs.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import com.dragonforest.view.gooddialog.lib.R
import com.dragonforest.view.gooddialog.lib.base.BaseGoodDialog

/**
 *
 * author: DragonForest
 * time: 2020/4/14
 */
class GoodBottomSheetDialog(context: Context):BaseGoodDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFillScreenWidth()
        setCustomView(R.layout.gooddialog_bottom_sheet1)
        setWindowGravity(Gravity.BOTTOM)
        setWindowAnims(R.style.DialogBottomShowStyle)

    }
}