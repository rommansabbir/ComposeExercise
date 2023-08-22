package com.rommansabbir.composeexcercise.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rommansabbir.composeexcercise.R

@Composable
fun GeneralTrainingCandidateProfileInfoView(
    image: String?,
    name: String,
    passportNumber: String,
    mobile: String
) {
    Card(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        Row(
            modifier = FillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = FillMaxWidth()
                    .weight(.3F)
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                )
                Box(
                    modifier = Modifier
                        .size(100.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_account_circle_24),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }
            Column(
                modifier = FillMaxWidth()
                    .weight(.7F)
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val finalPassport = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("Passport Number: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(passportNumber)
                    }
                }
                val finalMobileNumber = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("Mobile Number: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(mobile)
                    }
                }
                Text(
                    text = name,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    modifier = FillMaxWidth().padding(top = 8.dp, bottom = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = finalPassport,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    modifier = FillMaxWidth().padding(top = 8.dp, bottom = 8.dp)
                )
                Text(
                    text = finalMobileNumber,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    modifier = FillMaxWidth().padding(top = 8.dp, bottom = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGeneralTrainingCandidateProfileInfoView() {
    Column(FillMaxSize()) {
        GeneralTrainingCandidateProfileInfoView(
            image = "",
            name = "Md. Romman Sabbir",
            passportNumber = "A01670361",
            mobile = "+8801681588063"
        )
    }
}