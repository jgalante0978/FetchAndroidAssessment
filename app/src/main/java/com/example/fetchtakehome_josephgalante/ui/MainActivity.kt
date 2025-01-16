package com.example.fetchtakehome_josephgalante.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fetchtakehome_josephgalante.domain.CustomViewModel
import com.example.fetchtakehome_josephgalante.ui.composable.ItemGroups
import com.example.fetchtakehome_josephgalante.ui.theme.FetchTakeHome_JosephGalanteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = hiltViewModel<CustomViewModel>()
            FetchTakeHome_JosephGalanteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ItemGroups(viewModel, Modifier.padding(innerPadding))
                }
            }
        }
    }
}
