package br.com.carolchiaradia.data.remote.mapper

import br.com.carolchiaradia.data.remote.model.ProductPayload
import br.com.carolchiaradia.domain.model.Product

object ProductPayloadMapper {
    fun map(products: List<ProductPayload>) = products.map { map(it) }
    private fun map(productPayload: ProductPayload) = Product(
        name = productPayload.name,
        imageURL = productPayload.imageURL,
        description = productPayload.description
    )
}