package br.com.carolchiaradia.data.remote.datasource

import br.com.carolchiaradia.data.remote.api.ProductAPI
import br.com.carolchiaradia.data.remote.mapper.ProductPayloadMapper
import br.com.carolchiaradia.domain.model.Product
import io.reactivex.Single

class ProductRemoteDataSourceImpl(private val productAPI: ProductAPI) : ProductRemoteDataSource {


    override fun getProducts(): Single<List<Product>> {
        return productAPI.getProducts().map { ProductPayloadMapper.map(it) }
    }
}