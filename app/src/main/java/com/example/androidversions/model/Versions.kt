package com.example.androidversions.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Versions (
    val versionName: String,
    val apiLevel: Double

):Parcelable
