package com.mahzizo.tammam.service.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JSONParsingService implements ParsingService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Object parse(String url) {
		
		return restTemplate.getForObject(url, Object.class) ;
	}

}
