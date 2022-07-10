package com.myapp.candyshop.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.candyshop.dto.CandyDto;
import com.myapp.candyshop.entity.Candy;
import com.myapp.candyshop.exception.service.CandyShopServiceException;
import com.myapp.candyshop.service.CandyService;

@SpringBootTest
public class CandyControllerTest {

	@Mock
	private ModelMapper modelMapper;

	private ModelMapper modelMapper1 = new ModelMapper();

	@Mock
	private CandyService candyService;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddCandy() throws CandyShopServiceException {

		CandyDto candyDto = new CandyDto("Choco", 100);

		Candy candy = modelMapper1.map(candyDto, Candy.class);
		when(candyService.addCandy(candy, 1)).thenReturn(candy);
		assertEquals(candy, candyService.addCandy(candy, 1));

	}

}
