package com.chrisluttio.cs.trees;

import java.util.ArrayList;

public class BinarySearchTree<T> {
	private BinaryNode<T> root;
	private int size;
	
	public void insert(int key, T value) {
		BinaryNode<T> node = new BinaryNode<>(key, value);
		if (root == null) {
			root = node;
		} else {
			BinaryNode<T> parent = search(root, key);
			node.parent = parent;
			if (key < parent.key)
				parent.left = node;
			else
				parent.right = node;
		}
		size++;
	}
	
	private BinaryNode<T> search(BinaryNode<T> node, int key) {
		if (node.left != null)
			if (key < node.key)
				return search(node.left, key);
		if (node.right != null)
			if (key >= node.key)
				return search(node.right, key);
		return node;
	}
	
	public T get(int key) {
		BinaryNode<T> node = find(root, key);
		return node != null ? node.value : null;
	}
	
	private BinaryNode<T> find(BinaryNode<T> node, int key) {
		if (node.key == key)
			return node;
		if (node.left != null)
			if (key < node.key)
				return find(node.left, key);
		if (node.right != null)
			if (key >= node.key)
				return find(node.right, key);
		return null;
	}
	
	public void remove(int key) {
		BinaryNode<T> z = find(root, key);
		if (z == null)
			return;
		if (z.left == null)
			transplant(z, z.right);
		else if (z.right == null)
			transplant(z, z.left);
		else {
			BinaryNode<T> y = getMinimumNode(z.right);
			if (y.parent != z) {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
		}
		size--;
	}
	
	private void transplant(BinaryNode<T> u, BinaryNode<T> v) {
		if (u.parent == null)
			root = v;
		else if (u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		if (v != null)
			v.parent = u.parent;
	}
	
	public T getMinimum() {
		BinaryNode<T> min = getMinimumNode(root);
		return min != null ? min.value : null;
	}
	
	private BinaryNode<T> getMinimumNode(BinaryNode<T> node) {
		BinaryNode<T> current = node;
		while (current.left != null)
			current = current.left;
		return current;
	}
	
	public ArrayList<T> getInorderTraversal() {
		return Inorder(root);
	}
	
	private ArrayList<T> Inorder(BinaryNode<T> node) {
		ArrayList<T> list = new ArrayList<>();
		if (node.left != null)
			list.addAll(Inorder(node.left));
		list.add(node.value);
		if (node.right != null)
			list.addAll(Inorder(node.right));
		return list;
	}
}
