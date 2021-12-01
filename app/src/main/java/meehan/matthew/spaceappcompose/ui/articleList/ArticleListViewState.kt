package meehan.matthew.spaceappcompose.ui.articleList

import meehan.matthew.spaceappcompose.ui.articleViewHolder.ArticleViewHolderState

sealed class ArticleListViewState {
    object Loading: ArticleListViewState()
    data class Loaded(val data: List<ArticleViewHolderState>): ArticleListViewState()
}
