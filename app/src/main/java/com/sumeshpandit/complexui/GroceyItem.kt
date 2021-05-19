package com.sumeshpandit.complexui

import android.media.Rating

data class GroceyItem(
    val itemImageView: Int,
    val offer: String,
    val off: Int,
    val company: String,
    val itemName: String,
    val itemSize: String,
    val price: Int,
    val star: Int,
    val rating: Int
)
