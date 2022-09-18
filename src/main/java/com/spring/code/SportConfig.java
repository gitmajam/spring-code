package com.spring.code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//This anotation lets spring container to register all the classes with @Component annotation.
@ComponentScan("com.spring.code")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	//this anotation lets spring container instantiate clases without @Component annotation 
	@Bean("randomFortuneService")
	public FortuneService randomFortuneService() {
		return new RandomFortuneService();
	}
	
	@Bean("myCoachB")
	public Coach tejoCoach() {
		return new TejoCoach(this.randomFortuneService());
	}
	
}
