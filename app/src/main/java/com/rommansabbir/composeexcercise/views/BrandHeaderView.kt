package com.rommansabbir.composeexcercise.views

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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rommansabbir.composeexcercise.R

/**
 * Define those actions that should be managed by the developer.
 */
sealed class BrandHeaderViewAction {
    object OnLogoClick : BrandHeaderViewAction()
    object OnNotificationClick : BrandHeaderViewAction()
    object OnMessageClick : BrandHeaderViewAction()
}

/**
 * Brand header view for our app.
 * Provide access to notification and message module from here.
 *
 * @param title Title for the header view.
 * @param onAction Callback of action triggered by the user.
 */
@Composable
fun BrandHeaderView(
    title: String,
    onAction: (action: BrandHeaderViewAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier
                    .weight(.6F)
                    .clickable {
                        onAction.invoke(
                            BrandHeaderViewAction.OnLogoClick
                        )
                    },
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.4F),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                onAction.invoke(
                                    BrandHeaderViewAction.OnNotificationClick
                                )
                            }
                    )
                }
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_message_24),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                onAction.invoke(
                                    BrandHeaderViewAction.OnMessageClick
                                )
                            }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBrandHeaderView() {
    Column(modifier = Modifier.fillMaxSize()) {
        BrandHeaderView(title = "Test", onAction = {})
    }
}