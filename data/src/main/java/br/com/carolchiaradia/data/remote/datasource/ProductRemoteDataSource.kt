package br.com.carolchiaradia.data.remote.datasource

import br.com.carolchiaradia.domain.model.Product
import io.reactivex.Single

interface ProductRemoteDataSource {
    fun getProducts() : Single<List<Product>>
}