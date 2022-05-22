package com.example.senators.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Job(
    val company: String?,
    val role: String?
) : Parcelable