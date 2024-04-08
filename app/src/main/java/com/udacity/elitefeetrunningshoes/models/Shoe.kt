package com.udacity.elitefeetrunningshoes.models

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable