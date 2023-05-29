import com.example.akkodis.domain.model.Prices
import com.example.akkodis.domain.service.ProductService
import com.example.akkodis.infraestructure.model.request.ProductRequest
import com.example.akkodis.infraestructure.controller.AppController
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ActiveProfiles
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import javax.transaction.Transactional

@ActiveProfiles('test')
@DataJpaTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional
@ComponentScan
class AppControllerTest extends Specification {

    @Shared
    ProductService productService

    @Subject
    AppController appController


    def setup() {
        productService = Mock()
        appController = new AppController(productService)
    }


    @Unroll("should return prices when valid request is made #index")
    def "should return prices for valid requests"() {
        given:
        def request = new ProductRequest(productId: 35455, brandId: 1, date: date)
        def expectedPrices = new Prices()
        expectedPrices.setProductId(35455)
        expectedPrices.setBrandId(1)
        expectedPrices.setPrice(price)
        productService.getProduct(request.date, request.productId, request.brandId) >> expectedPrices

        when:
        ResponseEntity<Prices> response = appController.getPrice(request)

        then:

        response.statusCode == HttpStatus.OK
        response.getBody().getPrice() == expectedPrices.getPrice()


        where:
        index | date                  | price
        1     | "2020-06-14 19:00:00" | 35.5
        2     | "2020-06-14 10:00:00" | 35.5
        3     | "2020-06-14 16:00:00" | 25.45
        4     | "2020-06-14 21:00:00" | 35.5
        5     | "2020-06-15 10:00:00" | 30.5
        6     | "2020-06-16 21:00:00" | 38.95
    }


    def "should return bad request when invalid date format is provided"() {
        given:
        def request = new ProductRequest(productId: 1, brandId: 1, date: "invalid date")

        when:
        ResponseEntity<Prices> response = appController.getPrice(request)

        then:
        response.statusCode == HttpStatus.BAD_REQUEST
    }

}