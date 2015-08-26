package com.test.coding;

import org.junit.Before;
import org.junit.Test;

public class LookUpTest {
	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void HappyCase(){
		LookUp<Integer> lookUp = new LookUp<Integer>();
		lookUp.add(4);
		lookUp.add(5);
		lookUp.add(6);
		lookUp.add(1);
		lookUp.add(3);
		lookUp.delete(3);
		lookUp.delete(1);
		lookUp.add(7);
		lookUp.add(9);

		System.out.println(lookUp.getRandom());
		System.out.println(lookUp.getRecent());
		System.out.println(lookUp.contains(3));
		System.out.println(lookUp.contains(1));
		System.out.println(lookUp.contains(6));

	}

}
