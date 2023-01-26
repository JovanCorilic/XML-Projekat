package com.xml.zig.zigbackapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
	
}
