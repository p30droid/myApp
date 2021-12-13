package com.androidlearn.digiandroid.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gallery(
    val img: String
): Parcelable{}