package com.chrisluttio.cs.trees;

public class BinaryNode<T> {
	public int key;
	public T value;
	public BinaryNode<T> left, right, parent;
	
	public BinaryNode(int key, T value) {
		this.key = key;
		this.value = value;
	}
}
