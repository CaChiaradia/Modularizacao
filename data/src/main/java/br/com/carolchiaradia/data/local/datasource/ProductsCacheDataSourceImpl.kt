package br.com.carolchiaradia.data.local.datasource

import br.com.carolchiaradia.data.local.database.ProductsDao
import br.com.carolchiaradia.data.local.mapper.ProductCacheMapper
import br.com.carolchiaradia.domain.model.Product
import io.reactivex.Single

class ProductCacheDataSourceImpl (
    private val productDao: ProductsDao
) : ProductCacheDataSource {

    override fun getProducts(): Single<List<Product>> {
        return productDao.getProducts().map { ProductCacheMapper.map(it) }
    }

    override fun insertData(products: List<Product>) {
        productDao.insertAll(ProductCacheMapper.mapProductToProductCache(products))
    }

    override fun updateData(products: List<Product>) {
        productDao.updateData(ProductCacheMapper.mapProductToProductCache(products))
    }
}