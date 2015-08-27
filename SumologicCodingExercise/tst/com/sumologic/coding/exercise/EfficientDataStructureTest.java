package com.sumologic.coding.exercise;

import org.junit.Test;

public class EfficientDataStructureTest {

	@Test
	public void HappyCase() {
		EfficientDataStructure dataStructure = new EfficientDataStructure();
		dataStructure.insert(3);
		dataStructure.insert(6);
		dataStructure.insert(1);
		dataStructure.insert(4);
		dataStructure.insert(9);

		System.out.println(dataStructure.getMax());
		System.out.println(dataStructure.getMin());

		dataStructure.delete(9);
		dataStructure.delete(1);

		System.out.println(dataStructure.getMax());
		System.out.println(dataStructure.getMin());
	}

}
