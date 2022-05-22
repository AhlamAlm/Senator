package com.example.senators.senatorslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.senators.models.Senator
import com.google.gson.Gson

class SenatorsListViewModel : ViewModel() {

    val senators = MutableLiveData<List<Senator>>()

    fun getSenatorsList(jsonString: String?) {

        jsonString?.let {
            val senatorList =
                Gson().fromJson(it, Array<Senator>::class.java)
            senators.value = senatorList.toMutableList()
        }
    }
}