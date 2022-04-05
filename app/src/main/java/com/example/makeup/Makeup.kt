package com.example.makeup

import java.util.*
import kotlin.collections.ArrayList


data class ResponseData(
 val status: String,
 val code: Number,
 val total: Number,
 val data: ArrayList<Makeup>
)

data class Makeup(
 val brand: String,
 val name: String,
 val image_link: String,
 val price: String,
val rating: Number,
 val description: String,



)



