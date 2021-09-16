package com.in28minutes.rest.webservices.restfulwebservices.requestchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.in28minutes.rest.webservices.restfulwebservices.requestchange.Bill;
import com.in28minutes.rest.webservices.restfulwebservices.requestchange.Coins;
import com.in28minutes.rest.webservices.restfulwebservices.requestchange.RequestChangeController;
import com.in28minutes.rest.webservices.restfulwebservices.requestchange.RequestChangeDAOService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class RequestChangeControllerTest {
	
		@Spy
	    @InjectMocks
	    RequestChangeController requestChangeController = new RequestChangeController();
	     
	    @Mock
	    RequestChangeDAOService service;
	    
	     
	    @Test
	    public void testAddCoinCapacity() 
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	         
	        Coins coin = new Coins();
	        coin.setFiveCount(100);
	        coin.setOneCount(100);
	        coin.setTenCount(100);
	        coin.setTwentyFiveCount(100);
	        
	        ResponseEntity<Object> responseEntity = requestChangeController.addCoinCapacity(coin.getOneCount(), coin.getFiveCount(), coin.getTenCount(), coin.getTwentyFiveCount());
	        assertEquals(responseEntity.getStatusCodeValue(),201);
	        assertEquals(responseEntity.getHeaders().getLocation().getPath(),"/100/100/100/100");
	    }
	     
	    @Test
	    public void testShowCoins() 
	    {
	    	
	    	 Coins coin = new Coins();
	         coin.setFiveCount(100);
	         coin.setOneCount(100);
	         coin.setTenCount(100);
	         coin.setTwentyFiveCount(100);
 
	        Coins coinsFromservice = service.showCoins();
	        Coins coinFromController = requestChangeController.displayCoins();
	        
	        assertEquals(coinsFromservice.getOneCount(), coinFromController.getOneCount());
	        assertEquals(coinsFromservice.getTenCount(), coinFromController.getTenCount());
	        assertEquals(coinsFromservice.getFiveCount(), coinFromController.getFiveCount());
	        assertEquals(coinsFromservice.getTwentyFiveCount(), coinFromController.getTwentyFiveCount());
	        
	    }
	    
	    @Test
	    public void testMinCoins() 
	    {
	 
	        Bill billFromservice = service.getLeastChange(1);
	        Bill billFromController = requestChangeController.receiveLeastChange(1);
	        
	        assertEquals(billFromservice.getChange(), billFromController.getChange());
	        assertEquals(billFromservice.getTenCount(), billFromController.getTenCount());
	        assertEquals(billFromservice.getFiveCount(), billFromController.getFiveCount());
	        assertNotEquals(billFromservice.getTwentFiveCount(), billFromController.getTwentFiveCount());
	        assertEquals(billFromservice.getOneCount(), billFromController.getOneCount());
	        assertEquals(billFromservice.getCalculatedBill(), billFromController.getCalculatedBill());
	        
	    }
	    
	    @Test
	    public void testMaxCoins() 
	    {
	 
	        Bill billFromservice = service.getMaxChange(1);
	        Bill billFromController = requestChangeController.receiveMaxChange(1);
	        
	        assertNotEquals(billFromservice.getChange(), billFromController.getChange());
	        assertEquals(billFromservice.getTenCount(), billFromController.getTenCount());
	        assertNotEquals(billFromservice.getFiveCount(), billFromController.getFiveCount());
	        assertEquals(billFromservice.getTwentFiveCount(), billFromController.getTwentFiveCount());
	        assertEquals(billFromservice.getOneCount(), billFromController.getOneCount());
	        assertEquals(billFromservice.getCalculatedBill(), billFromController.getCalculatedBill());
	        
	    }
	}

