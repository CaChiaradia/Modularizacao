package br.com.carolchiaradia.data.local.datasource

import br.com.carolchiaradia.domain.model.Product
import io.reactivex.Single

interface ProductCacheDataSource {

    fun getProducts() : Single<List<Product>>

    fun insertData(products: List<Product>)

    fun updateData(products: List<Product>)
}