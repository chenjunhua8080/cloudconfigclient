package com.configclient.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {
 
	@Value("${form}")
	private String form;
	
	@GetMapping("test1")
	public String getForm(){
		return form;
	}
	
	@Value("${page.size.weather}")
	private int size;
	
	@GetMapping("size")
	public int getSize(){
		return size;
	}
	
	private Environment env;
	
	@GetMapping("test2")
	public String getForm2(){
		return env.getProperty("form", "undefined");
	}

}
