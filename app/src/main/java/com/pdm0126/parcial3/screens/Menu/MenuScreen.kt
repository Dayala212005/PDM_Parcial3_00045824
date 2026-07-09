package com.pdm0126.parcial3.screens.Menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdm0126.parcial3.components.OptionItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    navigateToQuestions: () -> Unit,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.provideFactory())
) {
    val options by viewModel.options.collectAsStateWithLifecycle()
    val selectedPlace by viewModel.selectedOption.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("RankeUCA - Vota") },
            )
        }
    ) { innerPadding ->
        if (options.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "No hay opciones para votar",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Agrega opciones desde el menú.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(options, key = { it.id }) { option ->
                    OptionItem(
                        option = option,
                        selected = selectedPlace == option.id,
                        onClick = { viewModel.selectedOption(option.id) }
                    )
                }
            }
        }
    }
}