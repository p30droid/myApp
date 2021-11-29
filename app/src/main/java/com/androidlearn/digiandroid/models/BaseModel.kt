package com.androidlearn.digiandroid.models

data class BaseModel(
    val AmazingOffer: List<Product>,
    val `data`: Data,
    val discount: List<Product>,
    val makeup: List<Product>,
    val mobile: List<Product>,
    val news: List<News>
)