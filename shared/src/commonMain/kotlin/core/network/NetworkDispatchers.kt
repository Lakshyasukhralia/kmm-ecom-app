package core.network

import kotlinx.coroutines.CoroutineDispatcher

interface NetworkDispatchers {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

expect val networkDispatchers: NetworkDispatchers