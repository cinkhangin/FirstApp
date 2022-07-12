package com.naulian.firstapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val image : Int = R.drawable.mp_logo,
    val title : String = "",
    val content : String = ""
) : Parcelable