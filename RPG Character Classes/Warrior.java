package com.annodemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//syntax: @Component("anyBeanID")
@Component("thatWarrior")
//Scope can be configured using this annotation
@Scope("singleton")
public class Warrior implements Player{
	//NOTE: Constructor/Setter/Field injection offer the same functionality, chose one, be consistent
	
	//For field injections. Autowired can also be used to automatically set field using Java Reflection
	@Autowired
	@Qualifier("warriorUlt") //for beans with multiple annotations
	private UltimateAttack ult;
	
	private String name;
	private int hp;
	private int attack;
	private int defense;
	
	//using the Autowired annotation, Spring will find SCANE FOR COMPONENTS and find a bean (class/interface) that implements UltimateAttack
	//in this case, it will find the WarriorUlt class
	//if there are multiple implementations using the @Qualifier annotation comes into use
	//@Autowired
	public Warrior(UltimateAttack ult) {
		this.ult = ult;
	}
	
	
	//this is how to use @Qualifier in constructors
	public Warrior(@Qualifier("warriorUlt") String name, UltimateAttack ult) {
		this.name = name;
		this.ult = ult;
	}
	
	
	//no-arg constructor for setter injection
	public Warrior() {
		System.out.println("Inside no-arg constructor");
	}
	
	//----------------------------------------------------
	public void enterBattle() {
		System.out.println("Warrior has been born!");
	}
	
	@PostConstruct
	public void attackMode() {
		System.out.println("Warrior is in attack mode!");
	}
	
	//PreDestroy won't work for prototype scopes
	@PreDestroy
	public void exitBattle() {
		System.out.println("Warrior has exited the battle.");

	}
	
	public UltimateAttack getUlt() {
		return ult;
	}

	
	//use @Autowired on set methods for setter injectsions
	//@Autowired
	public void setUlt(UltimateAttack ult) {
		this.ult = ult;
	}
	
	//Autowired can also be used on other methods AKA method injection
	//@Autowired
	@Override
	public int playerAttack() {
		System.out.println(this.name + " attacks!");
		return this.attack;
	}

	@Override
	public int defend(int damage) {
		System.out.println(this.name + " has taken damage");
		int damageTaken = this.defense - damage;
		hp -= damageTaken;
		if(hp <= 0) {
			System.out.println("Player has died");
		}
		return damageTaken;
	}
	
	@Override
	public int unleashUlt() {
		return ult.unleashUlt();
	}
	//----------------------------------------------------
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefense(int defense) {
		this.defense = defense;
		
	}

	@Override
	public void setAttack(int attack) {
		this.attack = attack;
		
	}

	@Override
	public void setHp(int hp) {
		this.hp = hp;
		
	}
	//----------------------------------------------------
	@Override
	public int getHp() {
		return this.hp;
	}

	@Override
	public int getAttack() {
		return this.attack;
	}

	@Override
	public int getDefense() {
		return this.defense;
	}


}
