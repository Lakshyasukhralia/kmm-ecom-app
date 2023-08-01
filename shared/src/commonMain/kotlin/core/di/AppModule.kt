package core.di

import core.network.di.networkModule
import feature.item.di.itemModule
import feature.order.di.orderModule
import org.koin.core.context.startKoin

fun initKoin() =
    startKoin {
        modules(
            networkModule(false),
            itemModule(),
            orderModule()
        )
    }