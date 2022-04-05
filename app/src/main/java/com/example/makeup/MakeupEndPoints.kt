package com.example.makeup


import android.view.View
import android.widget.EditText
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Query


interface MakeupEndPoints {
    @GET(
        "/api/v1/products.json?brand=maybelline"
)


    //fun createPost(@Body dataModal: Makeup): Call<Makeup>

    fun getMakeup(@Query("Brand") brand: String): Call<List<Makeup>>

}