package com.example.myapplication

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.widget.RelativeLayout

class CustomRelativeLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

     var cutoutRectangleView: CutoutRectangleView
     var dashView: DashView

    init {
        // Inflate and add the layout
        inflate(context, R.layout.custom_relative_layout, this)

        cutoutRectangleView = findViewById(R.id.cutoutRectangleView)
        dashView = findViewById(R.id.dashView)

        // Load custom attributes
        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomRelativeLayout, defStyleAttr, 0)

        val roundRadius = a.getDimension(R.styleable.CustomRelativeLayout_round_radius, 0f)
        val roundColor = a.getColor(R.styleable.CustomRelativeLayout_round_color, Color.BLACK)
        val rectangleColor = a.getColor(R.styleable.CustomRelativeLayout_rectangle_color, Color.WHITE)

        cutoutRectangleView.mRoundColor=roundRadius.toInt()
        cutoutRectangleView.mRoundColor=roundColor
        cutoutRectangleView.mRectangleColor=rectangleColor

        val dashWidth = a.getDimension(R.styleable.CustomRelativeLayout_dashWidth1, 0f)
        val lineWidth = a.getDimension(R.styleable.CustomRelativeLayout_lineWidth1, 0f)
        val lineColor = a.getColor(R.styleable.CustomRelativeLayout_lineColor1, Color.GREEN)
        val dashOrientation = a.getInt(R.styleable.CustomRelativeLayout_dashOrientation1, 0)
        val lineHeight = a.getDimension(R.styleable.CustomRelativeLayout_lineHeight1, 0f)
//        var utils=DashViewPropertiesUtils()
//        utils.setDashViewProperties(dashView,dashWidth,lineWidth,lineColor,dashOrientation,lineHeight)
//        dashView.dashWidth=dashWidth
//        dashView.lineWidth=lineWidth
//        dashView.lineColor=lineColor
//        dashView.dashOrientation=dashOrientation
//        dashView.lineHeight=lineHeight
//        dashView.let {
//            it.dashWidth=dashWidth
//            it.lineWidth=lineWidth
//            it.lineColor=lineColor
//            it.dashOrientation=dashOrientation
//            it.lineHeight=lineHeight
//            it.invalidate()
//        }
        dashView.post{
            dashView.dashWidth=dashWidth
            dashView.lineWidth=lineWidth
            dashView.lineColor=lineColor
            dashView.dashOrientation=dashOrientation
            dashView.lineHeight=lineHeight
            dashView.invalidate()
        }
        a.recycle()
    }


}
