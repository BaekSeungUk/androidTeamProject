package com.example.groupproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EmgMedService {
    @GET("/6260000/FoodService/getFoodKr")
    fun getEmgMedData(
        @Query("serviceKey") serviceKey:String?,
        @Query("pageNo") pageNo:String?,
        @Query("numOfRows") numOfRows:String?,
        @Query("resultType") resultType:String?,
        @Query("GUGUN_NM") GUGUN_NM:String?
    ): Call<EmgMedResponse>


}