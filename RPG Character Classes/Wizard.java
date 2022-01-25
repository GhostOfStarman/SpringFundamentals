package com.firstspringproject;

public class Wizard implements Player{
	
	private String name;
	private int mp;
	private int hp;
	private int attack;
	private int defense;
	private UltimateAttack ult;
	
	private Wizard() {
		System.out.println("inside no-arg constructor");
	}
	
	public Wizard(String name, int mp, int hp, int attack, int defense, UltimateAttack ult) {
		super();
		this.name = name;
		this.mp = mp;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.ult = ult;
	}
	
	public Wizard(String name, int hp, int attack, int defense, UltimateAttack ult) {
		super();
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.ult = ult;
	}
	
	//----------------------------------------------------
	public int heal() {
		return hp += 10;
	}

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
	//used for injection:
	public void setUlt(UltimateAttack ult) {
		System.out.println("inside setter method");
		this.ult = ult;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
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
	
	public void setMp(int mp) {
		this.mp = mp;
	}
	//----------------------------------------------------
	public int getMp() {
		return this.mp;
	}

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
	//----------------------------------------------------
	
	public void enterBattle() {
		System.out.println("Wizard has entered the battle!");
	}
	
	public void exitBattle() {
		System.out.println("Battle over");
	}
}
