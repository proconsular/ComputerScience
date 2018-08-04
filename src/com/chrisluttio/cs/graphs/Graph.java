package com.chrisluttio.cs.graphs;

import com.chrisluttio.cs.lists.single.LinkedList;
import com.chrisluttio.cs.trees.RedBlackTree;

import sun.misc.Queue;

/*
 * Using RedBlackTree for dynamic add.
 * Should use a dynamic HashTable but this is cooler.
 */

public class Graph<T> {
	private static final int WHITE = 0, GRAY = 1, BLACK = 2;
	
	public RedBlackTree<GraphNode<T>> vertices;
	public RedBlackTree<RedBlackTree<Integer>> edges;
	
	private int time;
	
	public Graph() {
		vertices = new RedBlackTree<>();
		edges = new RedBlackTree<>();
	}
	
	public void insert(T value) {
		int key = vertices.size();
		vertices.insert(key, new GraphNode<T>(key, value));
	}
	
	public void connect(int key1, int key2) {
		RedBlackTree<Integer> adj = edges.get(key1);
		if (adj == null) {
			adj = new RedBlackTree<Integer>();
			edges.insert(key1, adj);
		}
		adj.insert(adj.size(), key2);
	}
	
	public int traverse(int vertex, int edge) {
		return edges.get(vertex).get(edge);
	}
	
	public void breathFirstSearch(int source_key) {
		vertices.iterate(vertex -> {
			vertex.color = WHITE;
			vertex.d = Integer.MAX_VALUE;
			vertex.parent = null;
		});
		GraphNode<T> source = vertices.get(source_key);
		source.color = GRAY;
		source.d = 0;
		source.parent = null;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.prepend(source_key);
		while (!queue.isEmpty()) {
			Integer u_key = queue.getFirst();
			queue.removeFirst();
			GraphNode<T> u = vertices.get(u_key);
			edges.get(u_key).iterate(edge -> {
				GraphNode<T> v = vertices.get(edge);
				if (v.color == WHITE) {
					v.color = GRAY;
					v.d = u.d + 1;
					v.parent = u;
					queue.append(edge);
				}
			});
			u.color = BLACK;
		}
	}
	
	public void depthFirstSearch() {
		vertices.iterate(vertex -> {
			vertex.color = WHITE;
			vertex.parent = null;
		});
		time = 0;
		vertices.iterate(vertex -> {
			if (vertex.color == WHITE) {
				depthVisit(vertex);
			}
		});
	}
	
	private void depthVisit(GraphNode<T> u) {
		time += 1;
		u.d = time;
		u.color = GRAY;
		edges.get(u.key).iterate(edge -> {
			GraphNode<T> v = vertices.get(edge);
			if (v.color == WHITE) {
				v.parent = u;
				depthVisit(v);
			}
		});
		u.color = BLACK;
		time += 1;
		u.f = time;
	}
}
