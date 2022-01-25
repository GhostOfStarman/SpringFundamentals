package com.annodemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

	public static void main(String[] args) {
		
		//Doing it without using XML using Spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AttackConfig.class);

//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/annodemo/annotationContext.xml");
		
		//Retrieving bean from container
		Warrior warrior = context.getBean("thatWarrior", Warrior.class);
		
		//call a method on the bean
		warrior.enterBattle();
		
		Tank tank = context.getBean("tank", Tank.class);
		
		
		
		//close context
		context.close();

	}

}
