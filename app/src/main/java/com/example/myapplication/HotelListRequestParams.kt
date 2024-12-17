package com.example.myapplication

import android.location.Location

data class HotelListRequestParams(
    //是否地图搜索
    var isMapSearch: Boolean = false,

    //入住时间startTime
    var arrivalDate: String = "",

    //离店时间endTime
    var departureDate: String = "",
    //经纬度
    var location: Location? = null,

    //市id
    var cityId: String = "",

    var cityName: String = "",

    //筛选项   (位置、区域、筛选项)
    var filterTypes: ArrayList<FilterType> = arrayListOf(),

    //排序
    var sortTypeName: String = "",
)

data class FilterType(
    val filterType: String,
)