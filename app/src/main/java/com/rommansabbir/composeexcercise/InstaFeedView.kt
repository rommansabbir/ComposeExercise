package com.rommansabbir.composeexcercise

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rommansabbir.composeexcercise.views.BrandHeaderView
import com.rommansabbir.composeexcercise.views.InstaStoriesView
import com.rommansabbir.composeexcercise.views.InstaStoriesViewDataModel

@Composable
fun InstaFeedView() {
    Column(modifier = Modifier.fillMaxSize()) {
        //Insta view column
        BrandHeaderView("Banglagram") {
        }
        val list = mutableListOf<InstaStoriesViewDataModel>().apply {
            for (index in 0..20) {
                add(
                    InstaStoriesViewDataModel(
                        index, "Test $index", R.drawable.baseline_account_circle_24
                    )
                )
            }
        }
        InstaStoriesView(list = list, onCallback = {

        })
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewInstaFeedView() {
    InstaFeedView()
}