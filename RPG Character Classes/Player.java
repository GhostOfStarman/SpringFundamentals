package com.firstspringproject;

public interface Player {

	public int playerAttack();
	
	public int defend(int damage);
	
	public void setName(String name);
	
	public void setDefense(int defense);
	
	public void setAttack(int attack);
	
	public void setHp(int hp);
	
	public int getHp();
	
	public int getAttack();
	
	public int getDefense();

	public int unleashUlt();
}
