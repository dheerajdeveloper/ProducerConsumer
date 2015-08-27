package com.sumologic.coding.exercise;

// linked list node helper data type
public class Node {
	Integer val;
	Node previousNode;

	public Node() {

	}

	public Node(Integer val, Node previousNode, Node nextNode,
			MinPriorityQueueEntry minPriorityQueueEntry,
			MaxPriorityQueueEntry maxPriorityQueueEntry) {
		this.val = val;
		this.previousNode = previousNode;
		this.nextNode = nextNode;
		this.minPriorityQueueEntry = minPriorityQueueEntry;
		this.maxPriorityQueueEntry = maxPriorityQueueEntry;
	}

	Node nextNode;
	MinPriorityQueueEntry minPriorityQueueEntry;
	MaxPriorityQueueEntry maxPriorityQueueEntry;

	public MinPriorityQueueEntry getMinPriorityQueueEntry() {
		return minPriorityQueueEntry;
	}

	public void setMinPriorityQueueEntry(
			MinPriorityQueueEntry minPriorityQueueEntry) {
		this.minPriorityQueueEntry = minPriorityQueueEntry;
	}

	public MaxPriorityQueueEntry getMaxPriorityQueueEntry() {
		return maxPriorityQueueEntry;
	}

	public void setMaxPriorityQueueEntry(
			MaxPriorityQueueEntry maxPriorityQueueEntry) {
		this.maxPriorityQueueEntry = maxPriorityQueueEntry;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public Node getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Node) {
			Node c = (Node) o;
			return val == c.val;
		}
		return false;
	}

}