package com.annodemo;

public class Tank implements Player{
	
	private String name;
	private int hp;
	private int attack;
	private int defense;
	
	private UltimateAttack ult;
	
	//----------------------------------------------------
	
	//Remember this is used for constructor injection
	public Tank(UltimateAttack ult) {
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
	
	
	//Remember, this method calls to the UlimateAttack class and the unleashUlt() method within it
	@Override
	public int unleashUlt() {
		return ult.unleashUlt();
	}
	
	public void protect() {
		this.defense += 20;
		System.out.println("Tank improved it's defense!");
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
	//----------------------------------------------------}
}
