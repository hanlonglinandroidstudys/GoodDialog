package com.dragonforest.view.gooddialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dragonforest.view.gooddialog.lib.base.BaseGoodDialog
import com.dragonforest.view.gooddialog.lib.styledialogs.alert.GoodAlertDialog
import com.dragonforest.view.gooddialog.lib.styledialogs.alert.GoodTopAlertDialog
import com.dragonforest.view.gooddialog.lib.styledialogs.bottomsheet.GoodBottomSheetDialog
import com.dragonforest.view.gooddialog.lib.styledialogs.loading.GoodLoadingDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        println("这里是onResume(),界面是否显示？")
    }

    fun OnBtnClick(view: View) {
        var dialog: BaseGoodDialog? = null
        when (view.id) {
            R.id.btn1 -> {
                dialog = GoodAlertDialog(this)
            }
            R.id.btn2 -> {
                dialog = GoodBottomSheetDialog(this)
            }
            R.id.btn3 -> {
                dialog = GoodTopAlertDialog(this)
            }
            R.id.btn4 -> {
                dialog = GoodLoadingDialog(this)
            }
            else -> {
            }
        }
        dialog?.show()
    }

}
