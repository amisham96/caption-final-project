package com.myapp.candyshop.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.candyshop.entity.Shop;
import com.myapp.candyshop.exception.service.CandyShopServiceException;
import com.myapp.candyshop.repository.ShopRepository;
import com.myapp.candyshop.service.ShopService;

@SpringBootTest
public class ShopServiceImplTest {

	@Mock
	private ShopService shopService;

	@Mock
	private ShopRepository shopRepository;

	Shop shop = new Shop(1, "Shop1", null);

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddShop() throws CandyShopServiceException {

		when(shopService.addShop(shop)).thenReturn(shop);
		assertEquals(shop, shopService.addShop(shop));

	}
}
