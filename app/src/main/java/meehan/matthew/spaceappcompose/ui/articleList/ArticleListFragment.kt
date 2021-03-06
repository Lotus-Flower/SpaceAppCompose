package meehan.matthew.spaceappcompose.ui.articleList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import meehan.matthew.spaceappcompose.theme.SpaceAppTheme

@AndroidEntryPoint
class ArticleListFragment : Fragment() {

    private val viewModel: ArticleListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                SpaceAppTheme {
                    ArticleListScreen(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}