package com.dragonforest.view.gooddialog.lib.styledialogs.alert

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.dragonforest.view.gooddialog.lib.R
import com.dragonforest.view.gooddialog.lib.base.BaseGoodDialog
import kotlinx.android.synthetic.main.gooddialog_top_alert.*

/**
 *
 * author: DragonForest
 * time: 2020/4/14
 */
class GoodTopAlertDialog(context: Context):BaseGoodDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCustomView(R.layout.gooddialog_top_alert)
        setWindowGravity(Gravity.TOP)
//        setFillScreenWidth()
        setWindowAnims(R.style.DialogTopShowStyle)

        initView()
    }

    private fun initView() {
        tv_ok.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                dismiss()
            }
        })
    }
}