object Deps {
    object Org {
        object JetBrains {
            object Kotlinx {
                const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

                const val kotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
            }

            object KotlinWrappers {
                const val kotlinWrappersBom = "org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:${Versions.kotlinWrappersBom}"
                const val kotlinStyled = "org.jetbrains.kotlin-wrappers:kotlin-styled"
            }
        }
    }

    object Io {
        object Ktor {
            const val ktorClientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
            const val ktorSerializationKotlinxJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
            const val ktorClientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
            const val ktorClientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"

            // Engines
            const val ktorClientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
            const val ktorClientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"
            const val ktorClientJava = "io.ktor:ktor-client-java:${Versions.ktor}"
            const val ktorClientJs = "io.ktor:ktor-client-js:${Versions.ktor}"
        }
    }

    object Logback {
        const val logbackClassic = "ch.qos.logback:logback-classic:${Versions.logbackClassic}"
    }

    object CashApp {
        object SQLDelight {
            const val gradlePlugin = "app.cash.sqldelight:gradle-plugin:${Versions.sqlDelight}"
            const val androidDriver = "app.cash.sqldelight:android-driver:${Versions.sqlDelight}"
            const val sqliteDriver = "app.cash.sqldelight:sqlite-driver:${Versions.sqlDelight}"
            const val nativeDriver = "app.cash.sqldelight:native-driver:${Versions.sqlDelight}"
            const val sqljsDriver = "app.cash.sqldelight:sqljs-driver:${Versions.sqlDelight}"

            const val coroutinesExtensions = "app.cash.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
            const val primitiveAdapters = "app.cash.sqldelight:primitive-adapters:${Versions.sqlDelight}"
        }
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
    }

    object ArkIvanov {
        object MVIKotlin {
            const val mvikotlin = "com.arkivanov.mvikotlin:mvikotlin:${Versions.mviKotlin}"
            const val mvikotlinMain = "com.arkivanov.mvikotlin:mvikotlin-main:${Versions.mviKotlin}"
            const val mvikotlinExtensionsCoroutines = "com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:${Versions.mviKotlin}"
        }

        object Decompose {
            const val decompose = "com.arkivanov.decompose:decompose:${Versions.decompose}"
            const val extensionsCompose = "com.arkivanov.decompose:extensions-compose-jetbrains:${Versions.decompose}"
        }

        object Essenty {
            const val lifecycle = "com.arkivanov.essenty:lifecycle:${Versions.essenty}"
        }
    }

    object Github {
        const val imageLoader = "io.github.qdsfdhvh:image-loader:${Versions.imageLoader}"
    }
}