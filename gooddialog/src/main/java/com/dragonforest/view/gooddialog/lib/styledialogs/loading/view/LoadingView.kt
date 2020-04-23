package com.dragonforest.view.gooddialog.lib.styledialogs.loading.view

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator

/**
 *
 * author: DragonForest
 * time: 2020/4/15
 */
class LoadingView : View {

    var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    /** 动画 */
    var animator: ObjectAnimator? = null
    /** 线条宽度 */
    var strokeWidth = 30f
    /** 半径 */
    var radius = 60f
    /** 开始颜色 */
    var startColor = Color.parseColor("#C1C1C1")
    /** 结束颜色 */
//    var endColor = Color.parseColor("#575757")
    var endColor = Color.RED
    /** 间隔时间 */
    var duration = 2000L
    /** 开始的角度*/
    var startAngle = 0f
        set(value) {
            field = value
            invalidate()
        }
    lateinit var shader: Shader
    var shaderMatrix: Matrix = Matrix()
    var cMatrix: Matrix = Matrix()

    init {
        mPaint.strokeWidth = strokeWidth
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.strokeJoin = Paint.Join.ROUND

    }

    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        shader = SweepGradient(
            measuredWidth.toFloat() / 2,
            measuredHeight.toFloat() / 2,
            startColor,
            endColor
        )
        shader.getLocalMatrix(shaderMatrix)
        mPaint.shader = shader
        if (radius == 0f) {
            radius = (Math.min(measuredHeight, measuredWidth) - strokeWidth * 2) / 2
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        Log.e("", "正在刷新...")
        shader.getLocalMatrix(shaderMatrix)
        shaderMatrix.setRotate(startAngle, width.toFloat() / 2, height.toFloat() / 2)
        shader.setLocalMatrix(shaderMatrix)
        canvas?.drawArc(
            RectF(
                width.toFloat() / 2 - radius,
                height.toFloat() / 2 - radius,
                width.toFloat() / 2 + radius,
                height.toFloat() / 2 + radius
            ),
            0f,
            360f,
            false,
            mPaint
        )
    }


    fun startLoading() {
        if (animator == null) {
            animator = ObjectAnimator.ofFloat(this, "startAngle", 0f, 360f)
        }
        if (animator!!.isRunning) {
            return
        }
        animator?.interpolator = LinearInterpolator()
        animator?.duration = duration
        animator?.repeatCount = Animation.INFINITE
        animator?.start()
    }

    fun stopLoading() {
        if (animator == null) {
            return
        }
        if (!animator!!.isRunning) {
            return
        }
        animator?.cancel()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.e("LoadingView", "onDetachedFromWindow(),停止动画")
        stopLoading()
    }

}