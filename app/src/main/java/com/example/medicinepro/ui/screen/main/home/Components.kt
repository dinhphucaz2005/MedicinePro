package com.example.medicinepro.ui.screen.main.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.medicinepro.R
import com.example.medicinepro.ui.theme.MedicineProTheme
import kotlin.math.absoluteValue

private val urls = listOf(
    "https://firebasestorage.googleapis.com/v0/b/my-music-app-f24ab.appspot.com/o/banner%2Fimage1.jpg?alt=media&token=ea936fba-a106-4002-a5e4-a38b1c7d63b7",
    "https://firebasestorage.googleapis.com/v0/b/my-music-app-f24ab.appspot.com/o/banner%2Fimage2.jpg?alt=media&token=b77a26f5-5faf-4864-b347-cafbd39b497c",
    "https://firebasestorage.googleapis.com/v0/b/my-music-app-f24ab.appspot.com/o/banner%2Fimage3.jpg?alt=media&token=07b6d06b-71db-462c-affe-e9ffb526e78a"
)

@Composable
fun BannerSlider(modifier: Modifier = Modifier) {

    val pagerState = rememberPagerState(0) { urls.count() }

    HorizontalPager(state = pagerState, modifier = modifier.graphicsLayer {
        val pageOffset = pagerState.currentPageOffsetFraction
        this.translationX = pageOffset * size.width
        this.cameraDistance = 1f
        this.rotationY = pageOffset * 30f
        this.alpha = 1f - pageOffset.absoluteValue
        this.scaleX = 1f - 0.2f * pageOffset.absoluteValue
        this.scaleY = 1f - 0.2f * pageOffset.absoluteValue
        this.clip = true
    }) { page ->
        AsyncImage(
            model = urls[page],
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Composable
fun Item(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .size(232.dp, 252.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.secondary)
    ) {
        AsyncImage(
            model = urls.random(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(121.dp)
                .background(Color(0xFF282c34))
        )
        val temp = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 12.dp)
            .fillMaxWidth()

        Text(
            text = "Item",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = temp
        )
        Row(
            modifier = temp, verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(R.drawable.ic_location), contentDescription = null)
            Text(
                "123 Oak Street, CA 98765",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        Row(
            modifier = temp, verticalAlignment = Alignment.CenterVertically
        ) {
            Text("5.0", style = MaterialTheme.typography.bodySmall)
            for (i in 0..4) {
                Icon(
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 1.dp),
                    tint = Color(0xFFfeb052)
                )
            }
            Text("(58 Reviews)", style = MaterialTheme.typography.titleSmall)
        }
        HorizontalDivider(thickness = 0.5.dp, modifier = temp)
        Row(
            modifier = temp
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_distance),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                "1.2 km/40min",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 4.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.ic_hospital),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Text("Hospital", style = MaterialTheme.typography.titleSmall)
        }
    }
}

@Composable
fun Filter(modifier: Modifier = Modifier) {
    val selectedItem = List(5) { index -> "Item $index" }.toMutableList()
    val unselectedItem = List(5) { index -> "Item $index" }.toMutableList()

    LazyColumn {
        itemsIndexed(selectedItem) { _, item ->
            Button(
                onClick = {
                    unselectedItem.add(item)
                    selectedItem.remove(item)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0D1F2D), contentColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                border = null,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = item)
            }
        }
        itemsIndexed(unselectedItem) { _, item ->
            Button(
                onClick = {
                    selectedItem.add(item)
                    unselectedItem.remove(item)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White, contentColor = Color(0xFF0d1f2d)
                ),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, Color(0xFF0D1F2D)),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = item)
            }
        }
    }
}

@Preview
@Composable
private fun Preview3() {
    MedicineProTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxSize()
                .padding(12.dp)
        ) {
            DoctorItem()
        }
    }
}

@Composable
fun DoctorItem(modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row(
            modifier = modifier
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxWidth()
                .height(132.dp)
                .padding(12.dp)
        ) {
            AsyncImage(
                model = urls.random(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.primary),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Text(
                        "Dr.David Patel",
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier.weight(1f),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_favourite),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                HorizontalDivider()
                Text(
                    "Cardiologist",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Row {
                    Icon(
                        painter = painterResource(R.drawable.ic_location),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Cardiology Center, USA",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(start = 4.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_star),
                        contentDescription = null,
                        tint = Color(0xFFfeb052)
                    )
                    Text(
                        text = "5.0 | 1,8762 Reviews",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(start = 4.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}