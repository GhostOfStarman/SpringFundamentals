package com.annodemo;

import java.util.*;

import org.springframework.stereotype.Component;

//note there is this Component part
@Component
public class WarriorUlt implements UltimateAttack{

	@Override
	public int unleashUlt() {
		int[] buildUp = new int[] {10,20,30,40,50};
		Random rand = new Random();
		int power = rand.nextInt(5);
		int dmg = 0;
		for(int i = 0; i <= power; i++) {
			dmg += buildUp[i];
		}
		return dmg;
	}

}
