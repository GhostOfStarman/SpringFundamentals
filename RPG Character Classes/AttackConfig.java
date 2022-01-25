package com.annodemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//this class is used to demonstrate defining spring beans with Java code/no XML
//and injecting dependencies into a bean
//Ex: Injecting an UltimateAttack into a Tank

@Configuration
@ComponentScan("attackConfig")
public class AttackConfig {
	
	//Bean for ultimateAttck
	@Bean
	public UltimateAttack ult() {
		return new TankUlt();
	}
	
	//Bean for Tank AND the dependency injection
	@Bean
	public Tank tank() {
//		Tank tank = new Tank(ult());
//		return tank;
		return new Tank(ult());
	}
	
}
