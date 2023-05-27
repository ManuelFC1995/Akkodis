package com.example.akkodis.infraestructure.controller


import com.example.akkodis.domain.model.Prices
import com.example.akkodis.domain.service.ProductService
import com.example.akkodis.infraestructure.model.request.ProductRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject


class AppControllerSpec extends Specification {

    @Shared
    ProductService productService = Mock()

    @Shared
    @Subject
    AppController appController = new AppController(productService)


    def "Test getPrice method with null prices"() {
        given:
        def request = new ProductRequest(date: "2023-05-27", productId: 123, brandId: 456)

        productService.getProduct(request.date, request.productId, request.brandId) >> null

        when:
        ResponseEntity<Prices> response = appController.getPrice(request)

        then:
        response.statusCode == HttpStatus.NO_CONTENT
        !response.hasBody()
    }
}
