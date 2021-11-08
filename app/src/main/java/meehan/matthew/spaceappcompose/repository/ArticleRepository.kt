package meehan.matthew.spaceappcompose.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import meehan.matthew.spaceappcompose.data.ArticleResponse
import meehan.matthew.spaceappcompose.dependencyInjection.IoDispatcher
import meehan.matthew.spaceappcompose.network.ArticleAPIEndpointInterface
import retrofit2.Response
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val articleAPIEndpointInterface: ArticleAPIEndpointInterface
) {
    suspend fun getArticles(): Response<ArticleResponse> = withContext(dispatcher) {
        articleAPIEndpointInterface.getArticles()
    }
}