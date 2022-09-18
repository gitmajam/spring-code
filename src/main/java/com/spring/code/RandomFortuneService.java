package com.spring.code;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

//@Component("randomFortuneService") this command is disable because this bean is configured manualy e the SportConfig class
public class RandomFortuneService implements FortuneService{
	
	private List<String> fortunes;

	@Override
	public String getFortune() {
		int randomIndex = (int) Math.floor(Math.random()*fortunes.size());
		return fortunes.get(randomIndex);
	}
	
	@PostConstruct
	public void readFortunes() {
		fortunes = Readers.readerTxt("fortunes.txt");
	}

}
