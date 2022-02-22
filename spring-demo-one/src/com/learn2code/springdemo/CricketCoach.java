package com.learn2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	//our setter method, this will be called by spring to inject dependency
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
