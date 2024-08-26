package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class GapDottedLine : View {

    // 圆的半径 = 高度
    // 圆的颜色
    // 矩形的颜色
    private var mRadius = 10f // 半圆的半径
    private var mRectangleHeight = 0f // 矩形的高度
    private var mRectangleWidth = 400f // 矩形的宽度
    var defaultHeightPx = 20
    var mRectangleColor = Color.WHITE // 矩形的颜色
    var mRoundColor = Color.TRANSPARENT // 半圆的
    private val TAG = "DashView"
    val DEFAULT_DASH_WIDTH = 100
    val DEFAULT_LINE_WIDTH = 100
    val DEFAULT_LINE_HEIGHT = 10
    val DEFAULT_LINE_COLOR = 10395294
    val ORIENTATION_HORIZONTAL = 0
    val ORIENTATION_VERTICAL = 1
    val DEFAULT_DASH_ORIENTATION = 0
    private var dashWidth = 0f
    private var lineHeight = 0f
    private var lineWidth = 0f
    private var lineColor = 0
    private var dashOrientation = 0
    private var mPaint: Paint? = null
    private var widthSize = 0
    private var heightSize = 0
    private var paint = Paint().apply {
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

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.GapDottedLine)
        mRadius =
            typedArray.getDimensionPixelSize(R.styleable.GapDottedLine_halfround_radius, 20).toFloat()
        mRectangleColor =
            typedArray.getColor(R.styleable.GapDottedLine_rectangle_color, Color.WHITE)
        mRoundColor =
            typedArray.getColor(R.styleable.GapDottedLine_halfround_color, Color.TRANSPARENT)
        mRectangleHeight = mRadius * 2.toFloat();
        mPaint = Paint(1)
        dashWidth = typedArray.getDimension(R.styleable.GapDottedLine_mt_dashWidth, 100.0f)
        lineHeight = typedArray.getDimension(R.styleable.GapDottedLine_mt_lineHeight, 10.0f)
        lineWidth = typedArray.getDimension(R.styleable.GapDottedLine_mt_lineWidth, 100.0f)
        lineColor = typedArray.getColor(R.styleable.GapDottedLine_mt_lineColor, 10395294)
        dashOrientation = typedArray.getInteger(R.styleable.GapDottedLine_mt_dashOrientation, 0)
        mPaint!!.setColor(lineColor)
        mPaint!!.strokeWidth = lineHeight
        typedArray.recycle()

    }

        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

         widthSize = MeasureSpec.getSize(widthMeasureSpec)
         heightSize = MeasureSpec.getSize(heightMeasureSpec)

        // 处理 wrap_content 高度
        val measuredHeight = if (heightMode == MeasureSpec.AT_MOST) {
            dp2px(defaultHeightPx)
        } else {
            heightSize
        }
        // 设置测量结果
        setMeasuredDimension(widthSize, measuredHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 保存 Canvas 状态
        val saveCount = canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null)
        // 绘制矩形
        paint.color = mRectangleColor
        mRectangleWidth = width.toFloat()
        canvas.drawRect(
            0f, 0f, mRectangleWidth , mRectangleHeight,
            paint
        )
        // 恢复 Canvas 状态
        when (dashOrientation) {
            1 -> this.drawVerticalLine(canvas)
            else -> this.drawHorizontalLine(canvas)
        }

        // 绘制左侧半圆缺口
        cutoutPaint.color = mRoundColor
        if (mRoundColor != Color.TRANSPARENT) {
            cutoutPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
        }

        val leftCircle = RectF(-mRadius, 0f, mRadius,  mRadius*2)
        canvas.drawArc(leftCircle, 0F, 360F, true, cutoutPaint)
        // 绘制右侧半圆缺口
        val rightCircle = RectF(
            mRectangleWidth-mRadius, 0f,
            mRectangleWidth+mRadius, mRectangleHeight
        )
        canvas.drawArc(rightCircle, 0f, 360f, true, cutoutPaint)
        canvas.restoreToCount(saveCount)


    }
    fun drawHorizontalLine(canvas: Canvas) {
        var totalWidth = 0.0f
        canvas.save()
        val pts = floatArrayOf(0.0f, 0.0f, lineWidth, 0.0f)
        canvas.translate(mRadius,mRadius)
        while (totalWidth <= (widthSize-mRadius*2)) {
            canvas.drawLines(pts, mPaint!!)
            canvas.translate(lineWidth + dashWidth, 0.0f)
            totalWidth += lineWidth + dashWidth
        }
        canvas.restore()
    }

    @Deprecated("没实现")
    fun drawVerticalLine(canvas: Canvas) {
        var totalWidth = 0.0f
        canvas.save()
        val pts = floatArrayOf(0.0f, 0.0f, 0.0f, lineWidth)
        canvas.translate(lineHeight / 2.0f, 0.0f)
        while (totalWidth <= heightSize.toFloat()) {
            canvas.drawLines(pts, mPaint!!)
            canvas.translate(0.0f, lineWidth + dashWidth)
            totalWidth += lineWidth + dashWidth
        }
        canvas.restore()
    }

}

fun View.dp2px(dp: Int) = (dp * resources.displayMetrics.density + 0.5f).toInt()