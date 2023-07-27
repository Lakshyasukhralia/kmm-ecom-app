package core.network.di

import core.network.createHttpClient
import feature.item.data.remote.api.ItemApi
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: (enableLogging: Boolean) -> Module
    get() = { enableLogging ->
        module {
            single { createHttpClient(enableLogging) }
        }
    }