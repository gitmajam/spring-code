package com.spring.code;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("myCoachB") this command is disable because this bean is configured manualy e the SportConfig class
public class TejoCoach implements Coach {

	private FortuneService fortuneService;

	// using constructor inyection without @Autowired annotation but we need create the Beans en the SportConfig class.
	public TejoCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on raising elbow";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void afterCreating() {
		System.out.println("doing after creating stuffs with TejoCoach");
	}
	
	@PreDestroy
	public void afterClosing() {
		System.out.println("doing before closing stuffs with TejoCoach");
	}
}
