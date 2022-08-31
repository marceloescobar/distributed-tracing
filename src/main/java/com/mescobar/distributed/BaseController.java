package com.mescobar.distributed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/service")
public class BaseController {

	 private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	    private RestTemplate restTemplate;
	    
	    @Value("${spring.application.name}")
	    private String applicationName;

	    public BaseController(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }
	    
	    @GetMapping("/path1")
	    public ResponseEntity path1() {

	        logger.info("Incoming request at {} for request /path1 ", applicationName);
	        String response = restTemplate.getForObject("http://localhost:8090/service/path2", String.class);
	        return ResponseEntity.ok("response from /path1 + " + response);
	    }

	    @GetMapping("/path2")
	    public ResponseEntity path2() {
	        logger.info("Incoming request at {} at /path2", applicationName);
	        return ResponseEntity.ok("response from /path2 ");
	    }
}
