package feature.item.di

import feature.item.data.remote.api.ItemApi
import feature.item.domain.repository.ItemRepository
import feature.item.data.repository.ItemRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val itemModule: () -> Module
    get() = {
        module {
            single { ItemApi(httpClient = get()) }
            single<ItemRepository> { ItemRepositoryImpl() }
        }
    }