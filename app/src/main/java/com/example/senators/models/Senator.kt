package com.example.senators.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Senator(
    val avatar: String?,
    val bio: String?,
    val birth_day: String?,
    val city: String?,
    val contact: Contact,
    val country: String?,
    val education: String?,
    val first_name: String?,
    val gender: String?,
    val id: Int,
    val job: Job,
    val last_name: String?,
    val pet_animal: String?
) : Parcelable