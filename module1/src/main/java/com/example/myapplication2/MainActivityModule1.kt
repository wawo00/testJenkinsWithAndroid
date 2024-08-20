package com.example.myapplication2

import android.os.Bundle
import android.webkit.WebView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivityModule1 : ComponentActivity() {
    val TAG = "roywan"
    private val webView: WebView? = null
    private val progressBar: ProgressBar? = null
    private val txtCommonTitle: TextView? = null

    private val url = "http://q.huijingcai.top/b/pay?payOrderNo=21100811012001970631000501060"
    private val title = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

//    private fun initFlexLayout() {
//        findViewById<TextView>(R.id.dividerDrawable1).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).dividerDrawableHorizontal = resources.getDrawable(R.drawable.divider1)
//            findViewById<TextView>(R.id.dividerDrawable0).text = "dividerDrawableHorizontal"
//            Toast.makeText(this, "dividerDrawableHorizontal", Toast.LENGTH_SHORT).show()
//        }
//        findViewById<TextView>(R.id.dividerDrawable2).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).dividerDrawableVertical = resources.getDrawable(R.drawable.divider2)
//            findViewById<TextView>(R.id.dividerDrawable0).text = "dividerDrawableVertical"
//        }
//        findViewById<TextView>(R.id.dividerDrawable3).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).setDividerDrawable(resources.getDrawable(R.drawable.divider3))
//            findViewById<TextView>(R.id.dividerDrawable0).text = "findViewById<TextView>(R.id.dividerDrawable"
//        }
//
//        //水平
//        findViewById<TextView>(R.id.showDividerHorizontal1).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).showDividerHorizontal = FlexboxLayout.SHOW_DIVIDER_NONE
//            findViewById<TextView>(R.id.showDividerHorizontal0).text = "水平分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_NONE"
//        }
//        findViewById<TextView>(R.id.showDividerHorizontal2).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).showDividerHorizontal = FlexboxLayout.SHOW_DIVIDER_BEGINNING
//            findViewById<TextView>(R.id.showDividerHorizontal0).text = "水平分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_BEGINNING"
//        }
//        findViewById<TextView>(R.id.showDividerHorizontal3).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).showDividerHorizontal = FlexboxLayout.SHOW_DIVIDER_MIDDLE
//            findViewById<TextView>(R.id.showDividerHorizontal0).text = "水平分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_MIDDLE"
//        }
//        findViewById<TextView>(R.id.showDividerHorizontal4).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).showDividerHorizontal = FlexboxLayout.SHOW_DIVIDER_END
//            findViewById<TextView>(R.id.showDividerHorizontal0).text = "水平分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_END"
//        }
//
//        //垂直
//        findViewById<TextView>(R.id.showDividerVertical1).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).showDividerVertical = FlexboxLayout.SHOW_DIVIDER_NONE
//            findViewById<TextView>(R.id.showDividerVertical0).text = "垂直分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_NONE"
//        }
//        findViewById<TextView>(R.id.showDividerVertical2).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).showDividerVertical = FlexboxLayout.SHOW_DIVIDER_BEGINNING
//            findViewById<TextView>(R.id.showDividerVertical0).text = "垂直分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_BEGINNING"
//        }
//        findViewById<TextView>(R.id.showDividerVertical3).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).showDividerVertical = FlexboxLayout.SHOW_DIVIDER_MIDDLE
//            findViewById<TextView>(R.id.showDividerVertical0).text = "垂直分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_MIDDLE"
//        }
//        findViewById<TextView>(R.id.showDividerVertical4).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).showDividerVertical = FlexboxLayout.SHOW_DIVIDER_END
//            findViewById<TextView>(R.id.showDividerVertical0).text = "垂直分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_END"
//        }
//
//        //水平+垂直
//        findViewById<TextView>(R.id.setShowDivider1).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).setShowDivider(FlexboxLayout.SHOW_DIVIDER_NONE)
//            findViewById<TextView>(R.id.setShowDivider0).text = "水平 + 垂直分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_NONE"
//        }
//        findViewById<TextView>(R.id.setShowDivider2).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).setShowDivider(FlexboxLayout.SHOW_DIVIDER_BEGINNING)
//            findViewById<TextView>(R.id.setShowDivider0).text = "水平 + 垂直分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_BEGINNING"
//        }
//        findViewById<TextView>(R.id.setShowDivider3).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).setShowDivider(FlexboxLayout.SHOW_DIVIDER_MIDDLE)
//            findViewById<TextView>(R.id.setShowDivider0).text = "水平 + 垂直分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_MIDDLE"
//        }
//        findViewById<TextView>(R.id.setShowDivider4).setOnClickListener {
//            findViewById<FlexboxLayout>(R.id.flexboxLayout).setShowDivider(FlexboxLayout.SHOW_DIVIDER_END)
//            findViewById<TextView>(R.id.setShowDivider0).text = "水平 + 垂直分割线 : findViewById<TextView>(R.id.SHOW_DIVIDER_END"
//        }
//    }




}


