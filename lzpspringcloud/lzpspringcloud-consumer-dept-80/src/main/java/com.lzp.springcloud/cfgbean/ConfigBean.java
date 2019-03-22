package com.lzp.springcloud.cfgbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean //<bean id = 'configBean' class = 'com.lzp.springccloud.cfgbean.Configbean'>
{
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
