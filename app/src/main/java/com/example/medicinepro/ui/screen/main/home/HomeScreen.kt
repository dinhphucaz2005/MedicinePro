package com.example.medicinepro.ui.screen.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicinepro.R
import com.example.medicinepro.ui.components.ExTextField
import com.example.medicinepro.ui.theme.MedicineProTheme

@Preview
@Composable
private fun Preview() {
    MedicineProTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {


    val defaultModifier = Modifier.fillMaxWidth()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Location")
        }
        item {
            Row(
                modifier = defaultModifier
            ) {
                Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                Text(
                    "Ho Chi Minh, Viet Nam",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.ic_notification),
                    contentDescription = null
                )
            }
        }
        item {
            ExTextField(
                text = "", placeHolder = "Search", modifier = defaultModifier,
                painter = painterResource(R.drawable.ic_search)
            ) { }
        }
        item {
            BannerSlider(
                modifier = defaultModifier
                    .height(164.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF282c34))
            )
        }
        item {
            Row(
                modifier = defaultModifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Categories",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "See all",
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        item {
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = defaultModifier.height(184.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(20) { index ->
                    Text(
                        text = "Item $index",
                        Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                    )
                }
            }
        }
        item {
            Row(
                modifier = defaultModifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Nearby Medical Centers",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "See all",
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}