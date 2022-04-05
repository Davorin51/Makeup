package com.example.makeup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.ims.RcsUceAdapter
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import kotlinx.android.synthetic.main.makeup.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnSearch.setOnClickListener {
            val request = ServiceBuilder.buildService(MakeupEndPoints::class.java)
            val call = request.getMakeup(etSearch.text.toString())

            call.enqueue(object : Callback<List<Makeup>> {
                override fun onResponse(
                    call: Call<List<Makeup>>,
                    response: Response<List<Makeup>>
                ) {
                    if(response.isSuccessful){
                        findViewById<RecyclerView>(R.id.makeupList).apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = MakeupRecyclerAdapter(response.body()!!)
                        }
                    }
                }

                override fun onFailure(call: Call<List<Makeup>>, t: Throwable) {
                    TODO("Not yet implemented")
                }


            })
        }
    }





}