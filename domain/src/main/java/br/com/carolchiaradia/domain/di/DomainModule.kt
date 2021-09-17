package br.com.carolchiaradia.domain.di

import br.com.carolchiaradia.domain.usecases.GetProductsUseCase
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetProductsUseCase(
            productRepository = get(),
            scheduler = Schedulers.io()
        )
    }
}

val domainModule = listOf(useCaseModule)