package com.example.fetchtakehome_josephgalante.domain

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchtakehome_josephgalante.data.data.Item
import com.example.fetchtakehome_josephgalante.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {
    private val TAG = CustomViewModel::class.java.simpleName
    val uiData: MutableState<List<Item>> = mutableStateOf(mutableListOf())
    val groupedMap: MutableState<Map<Int, List<Item>>> = mutableStateOf(mutableMapOf())

    init {
        networkRequest()
    }


    private fun networkRequest() {
        viewModelScope.launch {
            repository.doNetworkRequest().collect { response ->
                Log.d(TAG, "${response.body()}")
                response.body()?.let { body ->
                    groupedMap.value = body.filter { item ->
                        !item.name.isNullOrBlank()
                    }.sortedWith(
                        compareBy<Item> { it.listId }
                            .thenBy { it.name?.length }
                            .thenBy { it.name }
                    ).groupBy { it.listId }

                    Log.d(TAG, "map: ${groupedMap.value}")
                }
            }
        }
    }
}