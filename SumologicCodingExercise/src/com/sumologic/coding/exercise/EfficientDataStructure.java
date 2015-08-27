package com.sumologic.coding.exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EfficientDataStructure {

	private PriorityQueue<Node> minPriorityQueue = null;

	private PriorityQueue<Node> maxPriorityQueue = null;

	Node rootNode = null;

	public EfficientDataStructure() {
		minPriorityQueue = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node node1, Node node2) {
				if (node1.getVal() > node2.getVal()) {
					return 1;
				} else if (node1.getVal() < node2.getVal()) {
					return -1;
				}
				return 0;
			}
		});

		maxPriorityQueue = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node node1, Node node2) {
				if (node1.getVal() < node2.getVal()) {
					return 1;
				} else if (node1.getVal() > node2.getVal()) {
					return -1;
				}
				return 0;
			}
		});

		rootNode = new Node();
	}

	public void insert(Integer val) {

		MinPriorityQueueEntry minPriorityQueueEntry = new MinPriorityQueueEntry(
				val);
		MaxPriorityQueueEntry maxPriorityQueueEntry = new MaxPriorityQueueEntry(
				val);

		Node node = new Node(val, null, rootNode, minPriorityQueueEntry,
				maxPriorityQueueEntry);

		// Adding the element at the head of the link list
		rootNode.setPreviousNode(node);
		rootNode = node;

		minPriorityQueue.add(node);
		maxPriorityQueue.add(node);
	}

	public Integer getMax() {
		if (!maxPriorityQueue.isEmpty()) {
			return maxPriorityQueue.peek().getVal();
		}
		return null;
	}

	public Integer getMin() {
		if (!minPriorityQueue.isEmpty()) {
			return minPriorityQueue.peek().getVal();
		}
		return null;
	}

	public void deleteMin() {
		if (minPriorityQueue.isEmpty()) {
			return;
		}

		// delete the element from the min priority queue and get the link list
		// node
		Node minNode = minPriorityQueue.poll();

		MaxPriorityQueueEntry maxPriorityQueueEntry = minNode
				.getMaxPriorityQueueEntry();

		// remove the element via the pointer to the element
		maxPriorityQueue.remove(maxPriorityQueueEntry);

		deleteElementFromLinkList(minNode);

	}

	public void deleteMax() {
		if (maxPriorityQueue.isEmpty()) {
			return;
		}

		// delete the element from the max priority queue and get the link list
		// node
		Node maxNode = maxPriorityQueue.poll();

		MinPriorityQueueEntry minPriorityQueueEntry = maxNode
				.getMinPriorityQueueEntry();

		// remove the element via the pointer to the element
		minPriorityQueue.remove(minPriorityQueueEntry);

		deleteElementFromLinkList(maxNode);

	}

	public void delete(Integer val) {
		Node elementNode = find(val);
		if(elementNode == null){
			System.out.println("val is null");
			return;
		}
		if (maxPriorityQueue.isEmpty()) {
			return;
		}

		MaxPriorityQueueEntry maxPriorityQueueEntry = elementNode
				.getMaxPriorityQueueEntry();

		// remove the element via the pointer to the element
		maxPriorityQueue.remove(maxPriorityQueueEntry);


		MinPriorityQueueEntry minPriorityQueueEntry = elementNode
				.getMinPriorityQueueEntry();

		// remove the element via the pointer to the element
		minPriorityQueue.remove(minPriorityQueueEntry);

		deleteElementFromLinkList(elementNode);

	}

	private Node find(Integer val) {
		Node tempNode = rootNode;
		while (tempNode != null) {
			if (tempNode.getVal() == val) {
				return tempNode;
			}
			tempNode = tempNode.nextNode;
		}
		return null;
	}

	private void deleteElementFromLinkList(Node minNode) {

		// remove the entry from the link list
		// check if node is a single entry
		if (minNode.previousNode == null && minNode.nextNode == null) {
			minNode = null;
		}

		// check if the node is present at the start
		else if (minNode == rootNode) {
			rootNode = rootNode.nextNode;
		}

		// check if the node is present at the last
		else if (minNode.nextNode == null) {
			Node minNodePrevNode = minNode.previousNode;
			minNodePrevNode.nextNode = null;
			minNode = null;
		}

		// if minNode is present in between
		else {
			Node minNodePrevNode = minNode.previousNode;
			Node minNodeNextNode = minNode.nextNode;
			minNodePrevNode.nextNode = minNodeNextNode;
			minNodeNextNode.previousNode = minNodeNextNode;
			minNode = null;
		}

	}

}
