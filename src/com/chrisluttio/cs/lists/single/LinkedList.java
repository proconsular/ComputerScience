package com.chrisluttio.cs.lists.single;

public class LinkedList<T> {
	public Node<T> head;
	
	public void prepend(T value) {
		Node<T> node = new Node<>(value);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public T get(int index) {
		Node<T> node = getNode(index);
		if (node == null) 
			return null;
		return node.value;
	}
	
	public void removeFirst() {
		if (head != null)
			head = head.next;
	}
	
	public void removeLast() {
		if (head == null)
			return;
		if (head.next == null) {
			head = null;
		} else {
			Node<T> current = head;
			while(current.next.next != null)
				current = current.next;
			current.next = null;
		}
	}
	
	public void remove(int index) {
		Node<T> node = getNode(index - 1);
		if (node == null)
			return;
		node.next = node.next.next;
	}
	
	public void append(T value) {
		Node<T> node = new Node<>(value);
		if (head == null) {
			head = node;
		} else {
			Node<T> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}
	
	public void insert(int index, T value) {
		Node<T> newNode = new Node<>(value);
		if (head == null && index == 0) {
			head = newNode;
		} else {
			if (index == 0) {
				prepend(value);
			} else {
				Node<T> node = getNode(index - 1);
				if (node == null)
					return;
				newNode.next = node.next;
				node.next = newNode;
			}
		}
	}
	
	private Node<T> getNode(int index) {
		int currentIndex = 0;
		Node<T> current = head;
		while (currentIndex < index && current != null) {
			currentIndex++;
			current = current.next;
		}
		return current;
	}
	
	public T getFirst() {
		return get(0);
	}
	
	public T getLast() {
		Node<T> node = getLastNode();
		if (node == null)
			return null;
		return node.value;
	}
	
	public void union(LinkedList<T> other) {
		Node<T> last = getLastNode();
		last.next = other.head;
	}
	
	private Node<T> getLastNode() {
		if (head == null)
			return null;
		Node<T> current = head;
		while (current.next != null)
			current = current.next;
		return current;
	}
	
	public void clear() {
		head = null;
	}
	
	public int getSize() {
		int count = 0;
		Node<T> current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public LinkedList<T> split(int index) {
		Node<T> node = getNode(index - 1);
		LinkedList<T> other = new LinkedList<>();
		other.head = node.next;
		node.next = null;
		return other;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
}
