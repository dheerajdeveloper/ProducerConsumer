package com.test.coding;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class LookUp<T> {

	Map<T, Integer> m;

	List<T> list;

	Stack<Node<T>> s;

	int currIndex;

	public LookUp() {
		m = new LinkedHashMap<T, Integer>();
		list = new ArrayList<T>();
		s = new Stack<Node<T>>();

		currIndex = 0;
	}

	void add(T val) {
		if (list.size() > currIndex) {
			list.set(currIndex, val);
		} else {
			list.add(currIndex, val);
		}
		Node<T> node = new Node<T>(val, currIndex);
		s.push(node);
		m.put(val, currIndex);
		currIndex++;

		System.out.println("add: " + list.toString());
	}

	void delete(T val) {
		if (m.containsKey(val)) {
			int elementIndex = m.get(val);
			System.out.println("Index: " + val + " " + elementIndex);
			m.remove(val);

			list.set(elementIndex, list.get(currIndex - 1));
			currIndex--;

			Node<T> topNode = s.peek();
			if (topNode.getIndex().equals(elementIndex)) {
				s.pop();
			}
		}
		System.out.println("delete: " + list.toString() + " curr index"
				+ currIndex);
	}

	boolean contains(T val) {
		if (m.containsKey(val)) {
			return true;
		}
		return false;
	}

	T getRecent() {
		if (!s.isEmpty()) {
			return s.peek().getVal();
		}
		return null;
	}

	T getRandom() {

		Random rand = new Random();
		int randomIndex = rand.nextInt((currIndex - 0) ) + 0;

		System.out.println("random index: " + randomIndex);
		return list.get(randomIndex);

	}

}
