package com.spring.code;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myCoachA")
/*If we provide a singleton scope or not declare scope, the spring container instantiates the bean regardless 
 * wether we weren't instantiate the bean in the main method, but if we declare the scope as proptotype the 
 * spring container doesn't instantiate the bean unless we call the bean contructor in the main method.
 * */
@Scope("singleton")
public class BaseballCoach implements Coach {

	private FortuneService fortuneService;

	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	// using setter inyection
	@Autowired
	public void setFortuneService(@Qualifier("randomFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	@PostConstruct
	public void afterCreating() {
		System.out.println("doing after creating stuffs with BaseballCoach");
	}
	
	@PreDestroy
	public void afterClosing() {
		System.out.println("doing before closing stuffs with BaseballCoach");
	}
}
