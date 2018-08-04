package com.chrisluttio.cs.graphs;

public class GraphNode<T> {
	public int key;
	public T value;
	public int color;
	public int d, f;
	public GraphNode<T> parent;
	
	public GraphNode(int key, T value) {
		this.key = key;
		this.value = value;
	}
}
