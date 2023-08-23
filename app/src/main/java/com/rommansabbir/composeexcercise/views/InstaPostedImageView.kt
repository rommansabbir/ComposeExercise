package com.rommansabbir.composeexcercise.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rommansabbir.composeexcercise.R


/**
 * Model that represent a insta posted image.
 *
 * @param id Identifier
 * @param title Title to be shown
 * @param image Image to be shown
 */
data class InstaPostedImageViewDataModel(
    val id: Int, val title: String, @DrawableRes val image: Int, val additionalData: Any = Any()
)

@Composable
fun InstaPostedImageView(
    model: InstaPostedImageViewDataModel,
    onCallback: (action: InstaPostedContentLikeCommentsViewActions) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        InstaPostedImageVideoUserInfoView(
            title = "user", image = R.drawable.baseline_account_circle_24
        ) {
            onCallback.invoke(InstaPostedContentLikeCommentsViewActions.OnOptionSelected)
        }
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(400.dp)
        )
        InstaPostedContentLikeCommentsView(
            data = InstaPostedContentLikeCommentsViewDataModel(
                likedBy = "Liked by you and others",
                postDescription = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                comments = "View all comments",
                postedOn = "10 minutes ago"

            ), onCallback = onCallback
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewInstaPostedImageView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
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
            InstaPostedImageView(models[index]){
            }
        }
    }
}