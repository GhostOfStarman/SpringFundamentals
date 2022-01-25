package com.firstspringproject;
import java.util.*;

public class ArcherUlt implements UltimateAttack{

	@Override
	public int unleashUlt() {
		Random rand = new Random();
		int shots = rand.nextInt(5,9);
		
		return shots * 10;
	}


}
