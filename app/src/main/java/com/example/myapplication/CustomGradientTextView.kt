package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView

class CustomGradientTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val backgroundPaint = Paint().apply {
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        val text = text.toString()
        val textWidth = paint.measureText(text)
        val textHeight = paint.fontMetrics.bottom - paint.fontMetrics.top
        val rectLeft = (width - textWidth) / 2
        val rectTop = height - textHeight / 2 // top是上面的字体中心往下偏移一点
        val rectRight = rectLeft + textWidth
        val rectBottom = rectTop + 20 //矩形高度20px

        // 创建渐变
        val gradient = LinearGradient(
            rectLeft, rectTop, rectRight, rectBottom,
            intArrayOf(0xFFFF6E00.toInt(), 0xFFFFEEE0.toInt()), // Gradient colors
            null,
            Shader.TileMode.CLAMP
        )
        backgroundPaint.shader = gradient

        //绘制圆角矩形
        "rectLeft: $rectLeft, rectTop: $rectTop, rectRight: $rectRight, rectBottom: $rectBottom"
        val rectF = RectF(rectLeft, rectTop, rectRight, rectBottom)
        canvas.drawRoundRect(rectF, 20f, 20f, backgroundPaint) // 圆角矩形弧度20

        super.onDraw(canvas)
    }
}

fun String.logwan(){
    Log.i("roywan", this)
}
