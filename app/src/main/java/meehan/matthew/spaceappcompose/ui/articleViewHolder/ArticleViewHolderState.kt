package meehan.matthew.spaceappcompose.ui.articleViewHolder

data class ArticleViewHolderState(
    val title: String,
    val subtitle: String,
    val photoUrl: String,
    val onClick: () -> Unit
)