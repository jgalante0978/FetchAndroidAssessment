package com.example.fetchtakehome_josephgalante.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fetchtakehome_josephgalante.domain.CustomViewModel

@Composable
fun ItemGroups(viewModel: CustomViewModel, modifier: Modifier = Modifier) {
    LazyRow(
        modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val map = viewModel.groupedMap.value
        items(map.keys.toList()) { key ->
            Group(key, viewModel)
        }
    }
}