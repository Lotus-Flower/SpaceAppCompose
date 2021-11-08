package meehan.matthew.spaceappcompose.ui.articleList

sealed class ArticleListViewState {
    object Loading: ArticleListViewState()
    data class Loaded(val data: List<ArticleViewHolderState>): ArticleListViewState()
}

data class ArticleViewHolderState(
    val title: String,
    val subtitle: String,
    val photoUrl: String,
    val onClick: () -> Unit
)
