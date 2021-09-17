package br.com.carolchiaradia.domain.usecases

import br.com.carolchiaradia.domain.model.Product
import br.com.carolchiaradia.domain.repository.ProductRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class GetProductsUseCase(
    private val productRepository: ProductRepository,
    private val scheduler: Scheduler
) {
    fun execute(forceUpdate: Boolean): Single<List<Product>> {
        return productRepository.getProducts(forceUpdate)
            .subscribeOn(scheduler)
    }
}