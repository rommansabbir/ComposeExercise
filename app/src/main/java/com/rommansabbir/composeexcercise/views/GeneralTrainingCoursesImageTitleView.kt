package com.rommansabbir.composeexcercise.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rommansabbir.composeexcercise.R


@Composable
fun GeneralTrainingCoursesImageTitleView(
    title: String,
    @DrawableRes iconLocal: Int? = null,
    iconRemote: String? = null,
    showBorder: Boolean = true
) {
    Column(FillMaxWidth()) {
        Row(
            FillMaxWidth().padding(top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_account_circle_24),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Black),
                modifier = Modifier
                    .weight(.2F)
                    .size(50.dp)
            )
            Text(
                text = title,
                modifier = Modifier.weight(.8F),
                textAlign = TextAlign.Start
            )

        }
        if (showBorder) {
            Column(
                FillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray)
            ) {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGeneralTrainingCoursesImageTitleView() {
    Column(modifier = Modifier.fillMaxSize()) {
        GeneralTrainingCoursesImageTitleView("You have to pay non-refundable BDT 00 to enroll in this course")
        GeneralTrainingCoursesImageTitleView("You will get your an enrollment card after payment")
        GeneralTrainingCoursesImageTitleView("You have to complete your payment BDT 00 in time of downloading certificate")
        GeneralTrainingCoursesImageTitleView("You have to scan your enrollment card for attendance")
    }
}