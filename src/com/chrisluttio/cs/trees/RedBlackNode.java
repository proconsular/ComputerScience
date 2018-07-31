package com.chrisluttio.cs.trees;

public class RedBlackNode<T> {
	public int key, color;
	public T value;
	public RedBlackNode<T> left, right, parent;
	
	public RedBlackNode(int key, T value) {
		this.key = key;
		this.value = value;
	}
}
