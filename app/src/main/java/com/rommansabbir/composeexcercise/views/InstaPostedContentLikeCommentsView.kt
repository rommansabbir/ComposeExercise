package com.rommansabbir.composeexcercise.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rommansabbir.composeexcercise.R

/**
 * Data class to show the total like counts or liked by,
 * post description, total counts of comments and when posted.
 *
 * @param likedBy How many people liked it
 * @param postDescription Post description
 * @param comments How many comments have this post
 * @param postedOn When the post was created
 */
data class InstaPostedContentLikeCommentsViewDataModel(
    val likedBy: String, val postDescription: String, val comments: String, val postedOn: String
)

/**
 * Define those actions that should be managed by the developer.
 */
sealed class InstaPostedContentLikeCommentsViewActions {
    object OnFavorite : InstaPostedContentLikeCommentsViewActions()
    object OnShowComments : InstaPostedContentLikeCommentsViewActions()
    object OnShare : InstaPostedContentLikeCommentsViewActions()
    object OnSavePost : InstaPostedContentLikeCommentsViewActions()

    object OnOptionSelected : InstaPostedContentLikeCommentsViewActions()
}

/**
 * Show availabe action in a post view with the post description.
 *
 * @param data [InstaPostedContentLikeCommentsViewDataModel] that represent the UI
 * @param onCallback Callback that need to be managed
 */
@Composable
fun InstaPostedContentLikeCommentsView(
    data: InstaPostedContentLikeCommentsViewDataModel,
    onCallback: (action: InstaPostedContentLikeCommentsViewActions) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)) {
                Box(modifier = Modifier.weight(.1F)) {
                    Image(painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            onCallback.invoke(
                                InstaPostedContentLikeCommentsViewActions.OnFavorite
                            )
                        })
                }
                Box(modifier = Modifier.weight(.1F)) {
                    Image(painter = painterResource(id = R.drawable.baseline_comment_24),
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            onCallback.invoke(
                                InstaPostedContentLikeCommentsViewActions.OnShowComments
                            )
                        })
                }
                Box(modifier = Modifier.weight(.1F)) {
                    Image(painter = painterResource(id = R.drawable.baseline_send_24),
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            onCallback.invoke(
                                InstaPostedContentLikeCommentsViewActions.OnShare
                            )
                        })
                }
                Text(text = "", Modifier.weight(.6F))
                Box(modifier = Modifier.weight(.1F)) {
                    Image(painter = painterResource(id = R.drawable.baseline_save_24),
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            onCallback.invoke(
                                InstaPostedContentLikeCommentsViewActions.OnSavePost
                            )
                        })
                }
            }
        }
        var showDescription by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = data.likedBy,
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )
            Text(text = data.postDescription,
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                color = Color.White,
                maxLines = if (showDescription) 100 else 1,
                overflow = if (showDescription) TextOverflow.Visible else TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showDescription = !showDescription })
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )
            Text(
                text = data.comments,
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )
            Text(
                text = data.postedOn,
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewInstaPostedContentLikeCommentsView() {
    Column(modifier = Modifier.fillMaxSize()) {
        InstaPostedContentLikeCommentsView(
            InstaPostedContentLikeCommentsViewDataModel(
                likedBy = "Liked by you and others",
                postDescription = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                comments = "View all comments",
                postedOn = "10 minutes ago"

            )
        ) {

        }
    }
}