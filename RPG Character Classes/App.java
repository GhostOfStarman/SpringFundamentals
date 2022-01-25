package com.firstspringproject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		//NOTE: 2 main types of dependecy injections are Constructor and Setter (method) injections
		
		//loading spring configuration file (applicationContext.xml):
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/firstspringproject/applicationContext.xml");
		
		//getting bean from spring container:
		Player p1 = context.getBean("archer", Player.class);
		
		//call a method on the bean
		System.out.println(p1.playerAttack() + " damage done!");
		
		//can call this method after dependencies have been injected, this is where the ArcherUlt class comes into play
		System.out.println("Ultra Unleashed! " + p1.unleashUlt() + " damage done!");
		
		//used as an example for setter injection, the bean type is Wizard because getMp is only available in the Wizard class and not the Player interface
		Wizard wiz = context.getBean("wizard", Wizard.class);
		wiz.setMp(200);
		System.out.println(wiz.getMp());
		
		//close context
		context.close();

	}

}
