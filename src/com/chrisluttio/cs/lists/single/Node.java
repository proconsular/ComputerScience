package com.chrisluttio.cs.lists.single;

public class Node<T> {
	public T value;
	public Node<T> next;
	
	public Node(T value) {
		this.value = value;
		next = null;
	}
}
