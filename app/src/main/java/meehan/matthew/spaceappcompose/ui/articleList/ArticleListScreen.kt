package meehan.matthew.spaceappcompose.ui.articleList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import meehan.matthew.spaceappcompose.R

@Composable
fun ArticleListScreen(viewModel: ArticleListViewModel) {
    val state by viewModel.state.collectAsState()

    ArticleListView(
        state = state,
        modifier = Modifier
            .fillMaxSize()
    )
}

@Composable
fun ArticleListView(
    state: ArticleListViewState,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (progressView, articleListRecyclerView) = createRefs()
        when (state) {
            ArticleListViewState.Loading -> CircularProgressIndicator(
                modifier = Modifier
                    .constrainAs(progressView) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
            is ArticleListViewState.Loaded -> ArticleListRecyclerView(
                stateList = state.data,
                modifier = Modifier
                    .constrainAs(articleListRecyclerView) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)

                        height = Dimension.fillToConstraints
                    }
            )
        }
    }
}

@Composable
fun ArticleListRecyclerView(
    stateList: List<ArticleViewHolderState>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            stateList
        ) { viewHolderState ->
            ArticleViewHolder(
                state = viewHolderState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        all = dimensionResource(
                            id = R.dimen.padding_standard
                        )
                    )
                    .clickable {
                        viewHolderState.onClick.invoke()
                    }
            )
            Divider(
                color = MaterialTheme.colorScheme.outline,
                thickness = dimensionResource(
                    id = R.dimen.divider_size
                ),
                modifier = Modifier
                    .padding(
                        bottom = dimensionResource(
                            id = R.dimen.divider_size
                        )
                    )
            )
        }
    }
}

@Preview
@Composable
fun ArticleListViewLoadingPreview() {
    ArticleListView(
        state = ArticleListViewState.Loading,
        modifier = Modifier
            .fillMaxSize()
    )
}

@Preview
@Composable
fun ArticleListViewPreview() {
    ArticleListView(
        state = ArticleListViewState.Loaded(
            data = listOf(
                ArticleViewHolderState(
                    title = "Test Title 1",
                    subtitle = "Test Subtitle 1",
                    photoUrl = "",
                    onClick = {}
                ),
                ArticleViewHolderState(
                    title = "Test Title 2",
                    subtitle = "Test Subtitle 2",
                    photoUrl = "",
                    onClick = {}
                ),
                ArticleViewHolderState(
                    title = "Test Title 3",
                    subtitle = "Test Subtitle 3",
                    photoUrl = "",
                    onClick = {}
                )
            )
        ),
        modifier = Modifier
            .fillMaxSize()
    )
}