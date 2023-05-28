import com.example.akkodis.domain.model.Prices
import com.example.akkodis.domain.service.ProductService
import com.example.akkodis.infraestructure.model.request.ProductRequest
import com.example.akkodis.infraestructure.controller.AppController
import com.example.akkodis.infraestructure.repository.IpricesRepository
import com.example.akkodis.infraestructure.service.PriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.jdbc.core.JdbcTemplate
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
    ProductService productService = Mock()

    @Subject
    AppController appController

    @Autowired
    private JdbcTemplate jdbcTemplate = Mock()

    def setup() {
        appController = new AppController(productService)
        // Insert data into the database before running any test
        jdbcTemplate.execute("INSERT INTO prices (BRAND_ID, PRICE_LIST, PRODUCT_ID, PRICE, START_DATE, END_DATE, CURR, PRIORITY) VALUES (1, 1, 35455, 35.50, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 'EUR', 0)")
        jdbcTemplate.execute("INSERT INTO prices (BRAND_ID, PRICE_LIST, PRODUCT_ID, PRICE, START_DATE, END_DATE, CURR, PRIORITY) VALUES (1, 2, 35455, 25.45, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 'EUR', 1)")
        jdbcTemplate.execute("INSERT INTO prices (BRAND_ID, PRICE_LIST, PRODUCT_ID, PRICE, START_DATE, END_DATE, CURR, PRIORITY) VALUES (1, 3, 35455, 30.50, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 'EUR', 1)")
        jdbcTemplate.execute("INSERT INTO prices (BRAND_ID, PRICE_LIST, PRODUCT_ID, PRICE, START_DATE, END_DATE, CURR, PRIORITY) VALUES (1, 4, 35455, 38.95, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 'EUR', 1)")
    }

    @Unroll("should return prices when valid request is made #index")
    def "should return prices for valid requests"() {
        given:
        def request = new ProductRequest(productId: 35455, brandId: 1, date: date)
        def expectedPrices = new Prices()
        productService.getProduct(request.date, request.productId, request.brandId) >> expectedPrices

        when:
        ResponseEntity<Prices> response = appController.getPrice(request)

        then:
        response.statusCode == HttpStatus.NO_CONTENT

        where:
        index | date
        1     | "2020-06-14 19:00:00"
        2     | "2020-06-14 10:00:00"
        3     | "2020-06-14 16:00:00"
        4     | "2020-06-14 21:00:00"
        5     | "2020-06-15 10:00:00"
        6     | "2020-06-16 21:00:00"
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