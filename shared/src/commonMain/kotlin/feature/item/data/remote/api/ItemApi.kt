package feature.item.data.remote.api

import core.network.helper.handleErrors
import feature.item.data.remote.dto.ItemResponse
import feature.item.data.remote.dto.OrderResponse
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

    suspend fun getAllOrders(): List<OrderResponse> {
        return handleErrors {
            httpClient.get(allOrderRoute) {
                contentType(ContentType.Application.Json)
            }
        }
    }

    companion object {
        private const val baseUrl = "https://eb206971-8c2a-4520-9365-e695fbdeec8d.mock.pstmn.io/"
        const val allItemRoute = "$baseUrl/items/all"
        const val allOrderRoute = "$baseUrl/orders/all"
    }

}