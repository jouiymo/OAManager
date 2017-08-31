package com.neusoft;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestException {

	@GetMapping(value = "/testEX")
	public String testException() throws Exception {

		throw new Exception("10001");
		
		

	}

}
