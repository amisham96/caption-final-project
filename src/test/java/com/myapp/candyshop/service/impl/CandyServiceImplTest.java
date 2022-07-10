package com.myapp.candyshop.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.candyshop.entity.Candy;
import com.myapp.candyshop.exception.service.CandyShopServiceException;
import com.myapp.candyshop.repository.CandyRepository;
import com.myapp.candyshop.service.CandyService;

@SpringBootTest
public class CandyServiceImplTest {
	
	@Mock
	private CandyService candyService;
	
	@Mock
	private CandyRepository candyRepository;
	
	Candy candy = new Candy(1, "Choco", 100, null);
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddHospital() throws CandyShopServiceException{
		when(candyService.addCandy(candy, 1)).thenReturn(candy);
		assertEquals(candy, candyService.addCandy(candy, 1));
	}
	
}
