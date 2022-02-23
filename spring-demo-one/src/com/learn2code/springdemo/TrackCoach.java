package com.learn2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it: " + fortuneService.getFortune();
	}
	
	//init-method for bean lifecycle
	public void myStartupStuff() {
		System.out.println("Inside method myStartupStuff");
	}
	
	//destroy-method for bean lifecycle
	public void myShutdownStuff() {
		System.out.println("Inside method myShutdownStuff");
	}
}
