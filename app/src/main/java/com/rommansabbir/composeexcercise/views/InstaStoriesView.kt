package com.rommansabbir.composeexcercise.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rommansabbir.composeexcercise.R

/**
 * Define those actions that should be managed by the developer for [InstaStoriesView]
 */
sealed class InstaStoriesViewActions {
    class OnViewStory(model: InstaStoriesViewDataModel) : InstaStoriesViewActions()
}

/**
 * Model that represent a insta story.
 *
 * @param id Identifier
 * @param title Title to be shown
 * @param image Image to be shown
 */
data class InstaStoriesViewDataModel(
    val id: Int, val title: String, @DrawableRes val image: Int, val additionalData: Any = Any()
)

/**
 * View that shows user all stories.
 *
 * @param list List of [InstaStoriesViewDataModel] to be shown
 * @param onCallback Callback of action triggered by the user
 */
@Composable
fun InstaStoriesView(
    list: MutableList<InstaStoriesViewDataModel>,
    onCallback: (action: InstaStoriesViewActions) -> Unit
) {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(list.size) { index ->
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .size(80.dp)
                    .clickable {
                        onCallback.invoke(
                            InstaStoriesViewActions.OnViewStory(
                                list[index]
                            )
                        )
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box {
                    Image(
                        painter = painterResource(id = list[index].image),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                }
                Text(text = list[index].title, color = Color.White, fontSize = 12.sp)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewInstaStoriesView() {
    Column(modifier = Modifier.fillMaxSize()) {
        InstaStoriesView(list = mutableListOf<InstaStoriesViewDataModel>().apply {
            for (index in 0..20) {
                add(
                    InstaStoriesViewDataModel(
                        index, "Test $index", R.drawable.baseline_account_circle_24
                    )
                )
            }
        }) {

        }
    }
}