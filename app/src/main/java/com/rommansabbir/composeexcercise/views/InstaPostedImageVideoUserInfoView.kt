package com.rommansabbir.composeexcercise.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rommansabbir.composeexcercise.R

/**
 * Insta posted image or video user info view.
 *
 * @param title Title to be shown
 * @param image [DrawableRes] image to be shown
 * @param onCallback Callback to manage menu action
 */
@Composable
fun InstaPostedImageVideoUserInfoView(
    title: String,
    @DrawableRes image: Int,
    onCallback: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(.1F)) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                )
            }
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier.weight(.8F),
                textAlign = TextAlign.Start
            )
            Box(modifier = Modifier.weight(.1F)) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_segment_24),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .clickable { onCallback.invoke() }
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewInstaPostedImageVideoUserInfoView() {
    Column(modifier = Modifier.fillMaxSize()) {
        InstaPostedImageVideoUserInfoView(
            title = "Test",
            image = R.drawable.baseline_account_circle_24
        ) {

        }
    }
}