package meehan.matthew.spaceappcompose.network

import meehan.matthew.spaceappcompose.data.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET

interface ArticleAPIEndpointInterface {
    @GET("articles")
    suspend fun getArticles(): Response<ArticleResponse>
}