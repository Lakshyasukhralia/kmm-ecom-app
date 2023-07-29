package feature.profile.data.remote.api

import core.network.helper.handleErrors
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ProfileApi(
    private val httpClient: HttpClient
) {

    suspend fun callApi(): Any {
        return handleErrors {
            httpClient.get(someRoute) {
                contentType(ContentType.Application.Json)
            }
        }
    }

    companion object {
        private const val baseUrl = "https://eb206971-8c2a-4520-9365-e695fbdeec8d.mock.pstmn.io/"
        const val someRoute = baseUrl.plus("/some_route")
    }

}