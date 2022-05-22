package com.example.senators.senatordetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.senators.models.Senator

class SenatorDetailsViewModel : ViewModel() {

    val senator = MutableLiveData<Senator>()


    fun setSenator(senator: Senator){
        this.senator.value = senator
    }
}