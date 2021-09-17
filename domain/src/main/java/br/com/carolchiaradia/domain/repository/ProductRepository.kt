package br.com.carolchiaradia.domain.repository

import br.com.carolchiaradia.domain.model.Product
import io.reactivex.Single

interface ProductRepository {
    fun getProducts(forceUpdate: Boolean): Single<List<Product>>
}