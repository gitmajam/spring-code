package com.spring.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myCoachD")
@Scope("prototype")
public class CanicasCoach implements Coach {
	
	//using direct field inyection
	@Autowired
	private @Qualifier("timeFortuneService")FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes create a gap";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
