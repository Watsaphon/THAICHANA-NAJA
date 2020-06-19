package com.example.thaichana_naja.Database

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderApi {

    @GET("{id}")
    fun getUser(@Path(value = "id" ) id :String ): Call<ShopEntity>



}
