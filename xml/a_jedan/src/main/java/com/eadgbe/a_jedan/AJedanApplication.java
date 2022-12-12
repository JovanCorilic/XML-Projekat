package com.eadgbe.a_jedan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication//(scanBasePackages={"com.eadgbe.a_jedan.controller"})
public class AJedanApplication {

	public static void main(String[] args) {
		SpringApplication.run(AJedanApplication.class, args);
	}

}
