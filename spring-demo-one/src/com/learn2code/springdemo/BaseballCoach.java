package com.learn2code.springdemo;

public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on batting practise";
	}
}
