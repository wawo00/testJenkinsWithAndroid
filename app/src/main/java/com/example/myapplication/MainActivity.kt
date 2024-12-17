package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.lifecycle.MutableLiveData


class MainActivity : ComponentActivity() {
    val TAG = "roywan"
     var param=MutableLiveData<HotelListRequestParams>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            param.value=HotelListRequestParams(
            isMapSearch = false,
            arrivalDate = "2024-12-16",
            departureDate = "2024-12-17",
            location = null,
            cityId = "201",
            cityName = "青岛",
            filterTypes = arrayListOf(FilterType("位置"),FilterType("区域"),FilterType("筛选项")),
            sortTypeName = "距离最近"
        )

        // 观察 LiveData 数据的变化
        param.observe(this) { updatedParams ->
            // 这里可以更新 UI，例如：
            Log.d(TAG, "Updated HotelListRequestParams: $updatedParams")
        }
    }

    fun changParam(view: View){
        Log.i(TAG, "changParam: ")
        val currentParams = param.value
        currentParams?.let {
            // 修改 isMapSearch 为 true
            val updatedParams = it.copy(isMapSearch = true,filterTypes= it.filterTypes.apply {
                add(FilterType("价格"))
            })
            param.value = updatedParams // 更新 LiveData 的值
        }
    }
}


