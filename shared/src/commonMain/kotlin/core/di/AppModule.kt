package core.di

import core.network.di.networkModule
import feature.item.di.itemModule
import feature.order.di.orderModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            networkModule(enableNetworkLogs),
            itemModule(),
            orderModule()
        )
    }