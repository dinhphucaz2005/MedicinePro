package com.example.medicinepro.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicinepro.R
import com.example.medicinepro.ui.theme.MedicineProTheme
import java.util.Calendar

@Preview
@Composable
fun PreviewCalendarView() {
    MedicineProTheme {
        CalendarView()
    }
}

@Composable
fun CalendarView() {
    val calendar = Calendar.getInstance()
    val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
    val currentMonth = calendar.get(Calendar.MONTH) + 1
    val currentYear = calendar.get(Calendar.YEAR)


    // Chuyển đến đầu tháng để lấy thông tin
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    val daysInMonth =
        calendar.getActualMaximum(Calendar.DAY_OF_MONTH) // Tổng số ngày trong tháng hiện tại
    val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) // Ngày đầu tiên của tháng

    val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val monthNames = listOf(
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    )
    val left = firstDayOfWeek - 2
    val right = left + daysInMonth - 1

    val cellModifier = Modifier
        .aspectRatio(1f)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),

        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Align all children vertically
        ) {
            Text(
                "${monthNames[currentMonth - 1]} $currentYear",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp),
                color = Color(0xFF111928),
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier.size(26.dp),
                tint = Color(0xFF9ca3af)
            )
            Icon(
                painter = painterResource(R.drawable.ic_fwd),
                contentDescription = null,
                modifier = Modifier.size(26.dp),
                tint = Color(0xFF1c2a3a)
            )
        }



        Spacer(modifier = Modifier.height(4.dp))

        Row {
            daysOfWeek.forEach { day ->
                Box(
                    modifier = cellModifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = day,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF4b5563),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
        }


        for (row in 0 until 6) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                for (col in 0 until 7) {
                    val dayIndex = row * 7 + col
                    val dayNumber = if (dayIndex in left..right) {
                        dayIndex - left + 1
                    } else {
                        null
                    }

                    Box(
                        modifier = cellModifier
                            .weight(1f)
                            .clip(RoundedCornerShape(6.dp))
                            .background(
                                if (currentDay == dayNumber) Color(0xFF1c2a3a)
                                else Color.Transparent
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = dayNumber?.toString() ?: "",
                            style = MaterialTheme.typography.bodyLarge,
                            color = when {
                                dayNumber == currentDay -> Color.White
                                col == 5 || col == 6 -> Color(0xFFd1d5db)
                                else -> Color(0xFF6b7280)
                            }
                        )
                    }
                }
            }
        }
    }
}
