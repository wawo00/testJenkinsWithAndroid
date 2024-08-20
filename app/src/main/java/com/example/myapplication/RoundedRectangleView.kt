package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View

class CutoutRectangleView:View {

    // 圆的半径 = 高度
    // 圆的颜色
    // 矩形的颜色
    private var mRadius = 10 // 半圆的半径
    private var mRectangleHeight = 0f // 矩形的高度
    private var mRectangleWidth = 400f // 矩形的宽度
    var defaultHeightPx=20
    var mRectangleColor = Color.WHITE // 矩形的颜色
    var mRoundColor = Color.TRANSPARENT // 半圆的

    private val paint = Paint().apply {
        isAntiAlias = true
        color = mRectangleColor // 矩形的颜色
        style = Paint.Style.FILL
    }

    private val cutoutPaint = Paint().apply {
        isAntiAlias = true
        color = mRoundColor
        style = Paint.Style.FILL
        xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)
    }


    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) : super(
        context,
        attrs,
        defStyleAttr
    ) {

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HalfRoundDottedLine)
        mRadius = typedArray.getDimensionPixelSize(R.styleable.HalfRoundDottedLine_halfround_radius, 20)
//        mRadius=dp2px(mRadius)
        mRectangleColor=typedArray.getColor(R.styleable.HalfRoundDottedLine_rectangle_color1,Color.WHITE)
        mRoundColor=typedArray.getColor(R.styleable.HalfRoundDottedLine_halfround_color,Color.TRANSPARENT)
        mRectangleHeight=mRadius*2.toFloat();
//        mRectangleHeight=dp2px(mRectangleHeight.toInt()).toFloat()
        typedArray.recycle()

    }
//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
//        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
//
//        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
//        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
//
//        // 处理 wrap_content 高度
//        val measuredHeight = if (heightMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.UNSPECIFIED) {
//            dp2px(defaultHeightPx)
//        } else {
//            heightSize
//        }
//
//        // 设置测量结果
//        setMeasuredDimension(widthSize, measuredHeight)
//    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 保存 Canvas 状态
        val saveCount = canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null)
        // 绘制矩形
        paint.color = mRectangleColor
        mRectangleWidth=width.toFloat()
        canvas.drawRect(
            mRadius.toFloat(), 0f, mRectangleWidth - mRadius, mRectangleHeight,
            paint
        )

        // 绘制左侧半圆缺口
        cutoutPaint.color=mRoundColor
        Log.i("TAG", "black: "+Color.BLACK)
        Log.i("TAG", "trans: "+Color.TRANSPARENT)
        Log.i("TAG", "final trans: "+mRoundColor)
        if (mRoundColor!=Color.TRANSPARENT){
            Log.i("TAG", "onDraw: ")
            cutoutPaint.xfermode=PorterDuffXfermode(PorterDuff.Mode.SRC)
        }

        val leftCircle = RectF(0f, 0f, (2 * mRadius).toFloat(), (2 * mRadius).toFloat())
        canvas.drawArc(leftCircle, 270f, 180f, true, cutoutPaint)
        // 绘制右侧半圆缺口
        val rightCircle = RectF(
            mRectangleWidth - 2 * mRadius, 0f,
            mRectangleWidth, (2 * mRadius).toFloat()
        )
        canvas.drawArc(rightCircle, 90f, 180f, true, cutoutPaint)
        // 恢复 Canvas 状态
        canvas.restoreToCount(saveCount)
    }


}
fun View.dp2px(dp: Int) = (dp * resources.displayMetrics.density + 0.5f).toInt()