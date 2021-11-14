package meehan.matthew.spaceappcompose.ui.articleList

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter
import meehan.matthew.spaceappcompose.R
import meehan.matthew.spaceappcompose.theme.SpaceAppTheme

@Composable
fun ArticleViewHolder(
    state: ArticleViewHolderState,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (
            articleTitleView,
            articleSubtitleView,
            articleImageView
        ) = createRefs()

        val standardMargin = dimensionResource(
            id = R.dimen.margin_standard
        )
        ArticleViewHolderImageView(
            photoUrl = state.photoUrl,
            modifier = Modifier
                .constrainAs(articleImageView) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
                .size(
                    width = dimensionResource(
                        id = R.dimen.article_view_holder_image_size
                    ),
                    height = dimensionResource(
                        id = R.dimen.article_view_holder_image_size
                    )
                )
        )
        ArticleViewHolderTitleView(
            title = state.title,
            modifier = Modifier
                .constrainAs(articleTitleView) {
                    width = Dimension.fillToConstraints
                    start.linkTo(
                        anchor = articleImageView.end,
                        margin = standardMargin
                    )
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(articleSubtitleView.top)
                }
        )
        ArticleViewHolderSubtitleView(
            subtitle = state.subtitle,
            modifier = Modifier
                .constrainAs(articleSubtitleView) {
                    width = Dimension.fillToConstraints
                    start.linkTo(
                        anchor = articleImageView.end,
                        margin = standardMargin
                    )
                    top.linkTo(articleTitleView.bottom)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Composable
fun ArticleViewHolderTitleView(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        color = MaterialTheme.colors.onBackground,
        modifier = modifier
    )
}

@Composable
fun ArticleViewHolderSubtitleView(
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = subtitle,
        color = Color.Gray,
        modifier = modifier
    )
}

@Composable
fun ArticleViewHolderImageView(
    photoUrl: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = rememberImagePainter(
            data = photoUrl,
            builder = {
                placeholder(
                    drawable = ColorDrawable(
                        MaterialTheme.colors.primary.toArgb()
                    )
                )
            }
        ),
        contentScale = ContentScale.FillBounds,
        contentDescription = null,
        modifier = modifier
    )
}

@Preview
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun ArticleViewHolderPreview() {
    SpaceAppTheme {
        ArticleViewHolder(
            state = ArticleViewHolderState(
                title = "Test Title",
                subtitle = "Test Subtitle",
                photoUrl = "",
                onClick = {}
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    all = dimensionResource(
                        id = R.dimen.padding_standard
                    )
                )
        )
    }
}