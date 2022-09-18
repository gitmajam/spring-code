package com.spring.code;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("timeFortuneService")
public class TimeFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		// Todays date in yyyyMMdd format
		return "Enjoy your date: " + new SimpleDateFormat("yyyyMMdd").format(new Date());
	}

}
