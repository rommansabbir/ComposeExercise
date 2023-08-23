package com.rommansabbir.composeexcercise

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.rommansabbir.composeexcercise.views.BrandHeaderView
import com.rommansabbir.composeexcercise.views.InstaPostedImageView
import com.rommansabbir.composeexcercise.views.InstaPostedImageViewDataModel
import com.rommansabbir.composeexcercise.views.InstaStoriesView
import com.rommansabbir.composeexcercise.views.InstaStoriesViewDataModel

@Composable
fun InstaFeedView() {
    Column(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        //Insta view column
        BrandHeaderView("Banglagram") {
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
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
                Toast.makeText(context, "Insta story clicked", Toast.LENGTH_SHORT).show()
            })

            val models = mutableListOf<InstaPostedImageViewDataModel>().apply {
                add(
                    InstaPostedImageViewDataModel(
                        0, "Test $0", R.drawable.baseline_account_circle_24
                    )
                )
                add(
                    InstaPostedImageViewDataModel(
                        1, "Test $1", R.drawable.baseline_account_circle_24
                    )
                )
                add(
                    InstaPostedImageViewDataModel(
                        2, "Test $2", R.drawable.baseline_account_circle_24
                    )
                )
                add(
                    InstaPostedImageViewDataModel(
                        3, "Test $3", R.drawable.baseline_account_circle_24
                    )
                )
            }
            repeat(models.size) { index ->
                InstaPostedImageView(models[index])
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewInstaFeedView() {
    InstaFeedView()
}