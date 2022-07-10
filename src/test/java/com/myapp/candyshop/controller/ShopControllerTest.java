package com.myapp.candyshop.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.candyshop.dto.ShopDto;
import com.myapp.candyshop.entity.Shop;
import com.myapp.candyshop.exception.service.CandyShopServiceException;
import com.myapp.candyshop.service.ShopService;

@SpringBootTest
public class ShopControllerTest {

	@Mock
	private ModelMapper modelMapper;

	@Mock
	private ShopService shopService;

	private ModelMapper modelMapper1 = new ModelMapper();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddShop() throws CandyShopServiceException {
		ShopDto shopDto = new ShopDto("Shop1");
		Shop shop = modelMapper1.map(shopDto, Shop.class);

		when(shopService.addShop(shop)).thenReturn(shop);
		assertEquals(shop, shopService.addShop(shop));
	}

}
