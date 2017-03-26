package com.bsuir.mpp.travelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class TravelAgencyApplication {

	public static void main(String[] args) {
		ApplicationContext apx =  SpringApplication.run(TravelAgencyApplication.class, args);
		String[] array = apx.getBeanDefinitionNames();
		for (String bean: array) {
			System.out.println(bean);
		}
	}
}
