package com.springboot.backend.rest.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.springboot.backend.rest.service.GddService;

/**
* @author gonzaloguzman97@gmail.com
*/
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class GddRestController {

	@Autowired
	private GddService gddService;
	
	/**
	 * EndPoint principal
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/get")
	public JsonNode getServiceResponse() throws IOException {
		return gddService.getGddResponse();
	}
	
}
