package feature.order.di

import feature.order.data.remote.api.OrderApi
import feature.order.domain.repository.OrderRepository
import feature.order.data.repository.OrderRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val orderModule: () -> Module
    get() = {
        module {
            single { OrderApi(httpClient = get()) }
            single<OrderRepository> { OrderRepositoryImpl() }
        }
    }