package com.pdm0126.parcial3.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.pdm0126.parcial3.data.model.Option
import com.pdm0126.parcial3.data.model.Question

@Composable
fun OptionItem(
    option: Question,
    selected: Boolean,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {

        Column {

            Text(
                text = option.title,
                modifier = Modifier.padding(16.dp)
            )

            if (selected) {
                Text(
                    text = "Votado",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}