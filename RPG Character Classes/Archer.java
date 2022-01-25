package com.firstspringproject;

public class Archer implements Player{
	private String name;
	private int hp;
	private int attack;
	private int defense;
	
	//this field is for constructor dependency injection:
	private UltimateAttack ult;
	
	public Archer() {}
	
	public Archer(String name) {
		this.name = name;
	}
	
	public Archer(String name, int hp, int attack, int defense) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
	}
	
	//this constructor was created later to include the dep. injection service:
	public Archer(String name, int hp, int attack, int defense, UltimateAttack ult) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.ult = ult;
	}
	
	//This is the constructor for dependency injection (refer to UltimateAttack):
	public Archer(UltimateAttack ult) {
		this.ult = ult;
	}
	//----------------------------------------------------
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

	public UltimateAttack getUlt() {
		return ult;
	}

	public void setUlt(UltimateAttack ult) {
		this.ult = ult;
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
