package feature.item.data.remote.api

import core.network.helper.handleErrors
import feature.item.data.remote.dto.ItemResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ItemApi(
    private val httpClient: HttpClient
) {

    suspend fun getAllItems(): List<ItemResponse> {
        return handleErrors {
            httpClient.get(allItemRoute) {
                contentType(ContentType.Application.Json)
            }
        }
    }

    companion object {
        const val baseUrl = "https://eb206971-8c2a-4520-9365-e695fbdeec8d.mock.pstmn.io/"
        const val allItemRoute = baseUrl + "all"
    }

}