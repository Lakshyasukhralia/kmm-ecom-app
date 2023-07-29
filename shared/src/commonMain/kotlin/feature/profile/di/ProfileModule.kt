package feature.profile.di

import feature.profile.data.remote.api.ProfileApi
import feature.profile.domain.repository.ProfileRepository
import feature.profile.data.repository.ProfileRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val profileModule: () -> Module
    get() = {
        module {
            single { ProfileApi(httpClient = get()) }
            single<ProfileRepository> { ProfileRepositoryImpl() }
        }
    }