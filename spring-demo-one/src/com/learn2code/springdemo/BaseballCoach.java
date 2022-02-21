package com.learn2code.springdemo;

public class BaseballCoach implements Coach {

	//define a private field
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	
	
	public BaseballCoach(FortuneService thefortuneService) {
		this.fortuneService = thefortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on batting practise";
	}

	@Override
	public String getDailyFortune() {
		//use my fortuneServ
		return fortuneService.getFortune();
	}
}
