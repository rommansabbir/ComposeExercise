package com.rommansabbir.composeexcercise

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.rommansabbir.composeexcercise.views.BrandHeaderView
import com.rommansabbir.composeexcercise.views.InstaPostedContentLikeCommentsViewActions
import com.rommansabbir.composeexcercise.views.InstaPostedImageView
import com.rommansabbir.composeexcercise.views.InstaPostedImageViewDataModel
import com.rommansabbir.composeexcercise.views.InstaStoriesView
import com.rommansabbir.composeexcercise.views.InstaStoriesViewDataModel

object MockDataProvider {
    val getMockResponse by lazy {
        mutableListOf<InstaPostedImageViewDataModel>().apply {
            for (index in 0..100) {
                add(
                    InstaPostedImageViewDataModel(
                        index, "Test $index", R.drawable.baseline_account_circle_24
                    )
                )
            }
        }
    }
    val getStories by lazy {
        mutableListOf<InstaStoriesViewDataModel>().apply {
            for (index in 0..20) {
                add(
                    InstaStoriesViewDataModel(
                        index, "Test $index", R.drawable.baseline_account_circle_24
                    )
                )
            }
        }
    }
}

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
            /*.verticalScroll(rememberScrollState())*/
        ) {

            LazyColumn(content = {
                item {
                    LazyRow(content = {
                        items(count = MockDataProvider.getStories.size, key = {
                            MockDataProvider.getStories[it].id
                        }) { index ->
                            InstaStoriesView(model = MockDataProvider.getStories[index], onCallback = {
                                Toast.makeText(context, "Insta story clicked", Toast.LENGTH_SHORT).show()
                            })
                        }
                    })
                }

                items(count = MockDataProvider.getMockResponse.size, key = {
                    MockDataProvider.getMockResponse[it].id
                }) { index ->
                    InstaPostedImageView(MockDataProvider.getMockResponse[index]) {
                        when (it) {
                            InstaPostedContentLikeCommentsViewActions.OnSavePost -> {
                                Toast.makeText(context, "On save post", Toast.LENGTH_SHORT).show()
                            }

                            InstaPostedContentLikeCommentsViewActions.OnFavorite -> {
                                Toast.makeText(context, "On favorite post", Toast.LENGTH_SHORT)
                                    .show()
                            }

                            InstaPostedContentLikeCommentsViewActions.OnOptionSelected -> {
                                Toast.makeText(context, "On option selected", Toast.LENGTH_SHORT)
                                    .show()
                            }

                            InstaPostedContentLikeCommentsViewActions.OnShare -> {
                                Toast.makeText(context, "On share post", Toast.LENGTH_SHORT).show()
                            }

                            InstaPostedContentLikeCommentsViewActions.OnShowComments -> {
                                Toast.makeText(context, "On show comments", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                }
            })
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewInstaFeedView() {
    InstaFeedView()
}