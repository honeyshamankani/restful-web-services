package com.in28minutes.rest.webservices.restfulwebservices.requestchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestChangeController {
	
	@Autowired
	private RequestChangeDAOService service;
	
	@GetMapping("/bills/min/{bill}")
	public Bill receiveLeastChange(@PathVariable int bill) {
		Bill b = service.getLeastChange(bill);
		return b;
	}
	
	@GetMapping("/bills/max/{bill}")
	public Bill receiveMaxChange(@PathVariable int bill) {
		Bill b = service.getMaxChange(bill);
		return b;
	}
	
	@PostMapping("/coins/{oneCentCount}/{fiveCentCount}/{tenCentCount}/{twentyFiveCentCount}")
	public ResponseEntity<Object> addCoinCapacity(@PathVariable int oneCentCount, @PathVariable int fiveCentCount, @PathVariable int tenCentCount, @PathVariable int twentyFiveCentCount) {
		ResponseEntity<Object> responseEntity = service.setCoinCapacity(oneCentCount, fiveCentCount, tenCentCount, twentyFiveCentCount);
		return responseEntity;
	}
	
	@GetMapping("/coins")
	public Coins displayCoins() {
		Coins coin = service.showCoins();
		return coin;
	}

}
