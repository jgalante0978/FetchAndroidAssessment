package com.example.fetchtakehome_josephgalante.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fetchtakehome_josephgalante.domain.CustomViewModel

@Composable
fun Group(key: Int, viewModel: CustomViewModel, modifier: Modifier = Modifier) {
    Column() {
        Text("List ID: $key", style = MaterialTheme.typography.titleMedium)
        LazyColumn(horizontalAlignment = Alignment.Start) {
            viewModel.groupedMap.value.get(key)?.let { list ->
                items(list) { item ->
                    Text(text = item.name!!)
                }
            }
        }
    }
}