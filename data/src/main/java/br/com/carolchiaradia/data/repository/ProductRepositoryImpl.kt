package br.com.carolchiaradia.data.repository

import br.com.carolchiaradia.data.local.datasource.ProductCacheDataSource
import br.com.carolchiaradia.data.remote.datasource.ProductRemoteDataSource
import br.com.carolchiaradia.domain.model.Product
import br.com.carolchiaradia.domain.repository.ProductRepository
import io.reactivex.Single

class ProductRepositoryImpl (
    private val productsCacheDataSource: ProductCacheDataSource,
    private val productRemoteDataSource: ProductRemoteDataSource): ProductRepository {

    override fun getProducts(forceUpdate: Boolean): Single<List<Product>> {
        return if (forceUpdate)
            getProductsRemote(forceUpdate)
        else
            productsCacheDataSource.getProducts()
                .flatMap { listJobs ->
                    when {
                        listJobs.isEmpty() -> getProductsRemote(false)
                        else -> Single.just(listJobs)
                    }
                }
    }

    private fun getProductsRemote(isUpdate: Boolean): Single<List<Product>> {
        return productRemoteDataSource.getProducts()
            .flatMap { products ->
                if (isUpdate)
                    productsCacheDataSource.updateData(products)
                else
                    productsCacheDataSource.insertData(products)
                Single.just(products)
            }
    }
}