package com.example.myapplication

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.strategy.TAGMM


class MainActivity : AppCompatActivity() {
    val TAG = "roywan"
    var param = MutableLiveData<HotelListRequestParams>()
    private val LOCATION_PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        param.value = HotelListRequestParams(
            isMapSearch = false,
            arrivalDate = "2024-12-16",
            departureDate = "2024-12-17",
            location = null,
            cityId = "201",
            cityName = "青岛",
            filterTypes = arrayListOf(FilterType("位置"), FilterType("区域"), FilterType("筛选项")),
            sortTypeName = "距离最近"
        )

        // 观察 LiveData 数据的变化
//        param.observe(this) { updatedParams ->
//            // 这里可以更新 UI，例如：
//            Log.d(TAG, "Updated HotelListRequestParams: $updatedParams")
//        }
//        getLocationUsingLocationManager()
    }

    fun changParam(view: View) {
        Log.i(TAG, "changParam: ")
        val currentParams = param.value
        currentParams?.let {
            // 修改 isMapSearch 为 true
            val updatedParams = it.copy(isMapSearch = true, filterTypes = it.filterTypes.apply {
                add(FilterType("价格"))
            })
            param.value = updatedParams // 更新 LiveData 的值
        }
        Log.i(TAGMM, "changParam: ")
    }
//
//
//    private val mNativeLocationListener = object : LocationListener {
//        override fun onLocationChanged(location: Location) {
//            val latitude = location.latitude
//            val longitude = location.longitude
//            "请求定位结果返回 Latitude: $latitude, Longitude: $longitude".logw("roywan ")
//            stopLocation()
//            requestLocationByWebrequestLocationByWeb(latitude.toString(), longitude.toString())
//        }
//
//        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
//        override fun onProviderEnabled(provider: String) {}
//        override fun onProviderDisabled(provider: String) {}
//    }

    override fun onResume() {
        super.onResume()
        //
        //存储权限
        checkLocationPermission()
    }


    fun checkLocationPermission() {
        Log.i(TAG, "checkLocationPermission: ")
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            Log.i(TAG, "getLocationUsingLocationManager: ")
            getLocationUsingLocationManager()
        }
    }

    fun getLocationUsingLocationManager() {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // Check if the permissions are granted
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request permissions if not granted
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }

        Log.i(TAG, "getLocationUsingLocationManager: 1111")
        val isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if (!isGPSEnabled && !isNetworkEnabled) {
            // No provider enabled
            Toast.makeText(this, "No location provider enabled", Toast.LENGTH_SHORT).show()
        } else {
            val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val locationListener = object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    // 处理位置变化
                    Log.i(TAG, "onLocationChanged: ${location.altitude} ${location.latitude} ${location.longitude}")
                }

                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                    super.onStatusChanged(provider, status, extras)
                    Log.i(TAG, "onStatusChanged: $provider $status $extras")
                }
                override fun onProviderEnabled(provider: String) {
                    super.onProviderEnabled(provider)
                    Log.i(TAG, "onProviderEnabled: $provider")
                }
                // ... 其他重写的方法
            }

// 请求位置更新
            Log.i(TAG, "getLocationUsingLocationManager: ")
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, locationListener)
//            // 使用 GPS 提供者获取位置更新
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, locationListener)
//            // 或者使用网络提供者获取位置更新
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)

            // Choose the best provider
//            val provider =
//                if (isGPSEnabled) LocationManager.GPS_PROVIDER else LocationManager.NETWORK_PROVIDER
//
//            // Request a single location update
//            locationManager.requestLocationUpdates(provider, 2000L, 10f, object : LocationListener {
//                override fun onLocationChanged(location: Location) {
//                    val latitude = location.latitude
//                    val longitude = location.longitude
//                    Log.i(TAG, "onLocationChanged: $latitude, $longitude")
//                    Toast.makeText(
//                        this@MainActivity,
//                        "Lat: $latitude, Lon: $longitude",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    locationManager.removeUpdates(this)
//                }
//
//                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
//                    Log.i(TAG, "onStatusChanged:  $status $extras")
//                }
//                override fun onProviderEnabled(provider: String) {
//                    Log.i(TAG, "onProviderEnabled: $provider")
//                }
//                override fun onProviderDisabled(provider: String) {
//                    Log.i(TAG, "onProviderDisabled: $provider")
//                }
//            })
        }


    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocationUsingLocationManager()
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
