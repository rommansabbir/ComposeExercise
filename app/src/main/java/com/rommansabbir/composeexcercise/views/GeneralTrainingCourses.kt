package com.rommansabbir.composeexcercise.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rommansabbir.composeexcercise.R

@Composable
fun FillMaxWidth(): Modifier = Modifier.fillMaxWidth()

@Composable
fun FillMaxSize(): Modifier = Modifier.fillMaxSize()

@Composable
fun TrainingCoursesCourseInformation(

) {
    Card(
        modifier = FillMaxWidth().padding(start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(15.dp)

    ) {
        Column(FillMaxWidth().background(Color.White)) {
            Row(
                FillMaxWidth().padding(top = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    FillMaxWidth().weight(.1F),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(FillMaxWidth().height(40.dp), contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_account_circle_24),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(
                                Color.Black
                            ),
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                Column(
                    FillMaxWidth()
                        .weight(.8F)
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = "Title",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            val list = mutableListOf<Pair<String, String>>().apply {
                add(Pair("Course name:", "Welding & Fabrication "))
                add(Pair("Session:", "September 2023 - November 2023"))
                add(Pair("Session Start date:", "11 March 2022"))
                add(Pair("Class Time:", "11:00 AM - 01:00 PM"))
                add(Pair("Training Center:", "TTC, Mirpur Road "))
            }
            Column(
                FillMaxWidth()
                    .background(Color.White)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                repeat(list.size) { index ->
                    Row(FillMaxWidth().padding(top = 8.dp, bottom = 8.dp)) {
                        Text(
                            text = list[index].first,
                            modifier = Modifier.weight(.5F),
                            color = Color.Black
                        )
                        Text(
                            text = list[index].second,
                            modifier = Modifier.weight(.5F),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    Column(
                        modifier = Modifier
                            .background(Color.Gray)
                            .height(1.dp)
                            .fillMaxWidth()
                    ) {}
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTrainingCoursesCourseInformation() {
    Column(modifier = Modifier.fillMaxSize()) {
        TrainingCoursesCourseInformation()
    }
}