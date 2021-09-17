package br.com.carolchiaradia.data.di

import br.com.carolchiaradia.data.repository.ProductRepositoryImpl
import br.com.carolchiaradia.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<ProductRepository> {
        ProductRepositoryImpl(
            productsCacheDataSource = get(),
            productRemoteDataSource = get()
        )
    }
}
val dataModules = listOf(remoteDataSourceModule, repositoryModule,
    cacheDataModule)