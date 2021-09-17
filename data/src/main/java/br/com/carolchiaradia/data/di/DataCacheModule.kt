package br.com.carolchiaradia.data.di

import br.com.carolchiaradia.data.local.database.ProductDataBase
import br.com.carolchiaradia.data.local.datasource.ProductCacheDataSource
import br.com.carolchiaradia.data.local.datasource.ProductCacheDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheDataModule = module {

    single { ProductDataBase.createDataBase(androidContext()) }

    factory<ProductCacheDataSource> { ProductCacheDataSourceImpl(productDao = get()) }
}