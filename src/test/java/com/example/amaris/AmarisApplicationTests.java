package com.example.amaris;

import com.example.amaris.model.Prices;
import com.example.amaris.repository.IpricesRepository;
import com.example.amaris.service.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class AmarisApplicationTests {
	@Mock
	IpricesRepository ipricesRepository;
	@InjectMocks
	PriceService priceService;
	@Test
	void contextLoads() {
		Prices price1 = new Prices(1,1,35455,35.5f,"2020-06-14 00:00:00","2020-12-31 23:59:59","EUR",1);
		Mockito.when(priceService.getPrice("2020-06-14 10:00:00",35455,1)).thenReturn(price1);

		Prices price2 = new Prices(1,1,35455,35.5f,"2020-06-14 00:00:00","2020-12-31 23:59:59","EUR",1);
		Mockito.when(priceService.getPrice("2020-06-14 16:00:00",35455,1)).thenReturn(price1);

		Prices price3 = new Prices(1,1,35455,35.5f,"2020-06-14 00:00:00","2020-12-31 23:59:59","EUR",1);
		Mockito.when(priceService.getPrice("2020-06-14 21:00:00",35455,1)).thenReturn(price1);

		Prices price4 = new Prices(1,1,35455,35.5f,"2020-06-14 00:00:00","2020-12-31 23:59:59","EUR",1);
		Mockito.when(priceService.getPrice("2020-06-15 10:00:00",35455,1)).thenReturn(price1);

		Prices price5 = new Prices(1,1,35455,35.5f,"2020-06-14 00:00:00","2020-12-31 23:59:59","EUR",1);
		Mockito.when(priceService.getPrice("2020-06-16 21:00:00",35455,1)).thenReturn(null);

	}

}
