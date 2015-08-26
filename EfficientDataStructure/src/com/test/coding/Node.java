package com.test.coding;

public class Node<T> {

	private T val;
	private Integer index;

	public Integer getIndex() {
		return index;
	}

	public T getVal() {
		return val;
	}

	public Node(T val2, int lastIndex) {
		val = val2;
		index = lastIndex;
	}
}
