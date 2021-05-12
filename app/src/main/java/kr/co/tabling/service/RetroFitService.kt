package kr.co.tabling.service

import kr.co.tabling.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface RetroFitService {
    @GET("list")
    fun getItemList(): Call<List<Item>>

}