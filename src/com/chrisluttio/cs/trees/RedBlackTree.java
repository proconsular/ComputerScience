package com.chrisluttio.cs.trees;

public class RedBlackTree<T> {
	public static final int BLACK = 0, RED = 1;
	
	private final RedBlackNode<T> sentinal;
	private RedBlackNode<T> root;
	
	public RedBlackTree() {
		sentinal = new RedBlackNode<T>(0, null);
		root = sentinal;
	}
	
	public void insert(int key, T value) {
		RedBlackNode<T> z = new RedBlackNode<T>(key, value);
		RedBlackNode<T> y = sentinal;
		RedBlackNode<T> x = root;
		while (x != sentinal) {
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		z.parent = y;
		if (y == sentinal)
			root = z;
		else if (z.key < y.key)
			y.left = z;
		else
			y.right = z;
		z.left = sentinal;
		z.right = sentinal;
		z.color = RED;
		rebalance(z);
	}
	
	private void rebalance(RedBlackNode<T> z) {
		while (z.parent.color == RED) {
			if (z.parent == z.parent.parent.left) {
				RedBlackNode<T> y = z.parent.parent.right;
				if (y.color == RED) {
					z.parent.color = BLACK;
					y.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.right) {
						z = z.parent;
						rotateLeft(z);
					}
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					rotateRight(z.parent.parent);
				}
			} else {
				RedBlackNode<T> y = z.parent.parent.left;
				if (y.color == RED) {
					z.parent.color = BLACK;
					y.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.left) {
						z = z.parent;
						rotateRight(z);
					}
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					rotateLeft(z.parent.parent);
				}
			}
		}
		root.color = BLACK;
	}
	
	public void delete(int key) {
		RedBlackNode<T> z = findNode(key);
		RedBlackNode<T> y = z;
		RedBlackNode<T> x = sentinal;
		int y_original_color = y.color;
		if (z.left == sentinal) {
			x = z.right;
			transplant(z, z.right);
		} else if (z.right == sentinal) {
			x = z.left;
			transplant(z, z.left);
		} else {
			y = getMinimumNode(z.right);
			y_original_color = y.color;
			x = y.right;
			if (y.parent == z)
				x.parent = y;
			else {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;
		}
		if (y_original_color == BLACK)
			delete_rebalance(x);
	}
	
	private void transplant(RedBlackNode<T> u, RedBlackNode<T> v) {
		if (u.parent == sentinal)
			root = v;
		else if (u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		v.parent = u.parent;
	}
	
	public T getMinimum() {
		return getMinimumNode(root).value;
	}
	
	private RedBlackNode<T> getMinimumNode(RedBlackNode<T> x) {
		RedBlackNode<T> y = x;
		while (y.left != sentinal)
			y = y.left;
		return y;
	}
	
	private void delete_rebalance(RedBlackNode<T> x) {
		while (x != root && x.color == BLACK) {
			if (x == x.parent.left) {
				RedBlackNode<T> w = x.parent.right;
				if (w.color == RED) {
					w.color = BLACK;
					x.parent.color = RED;
					rotateLeft(x.parent);
					w = x.parent.right;
				}
				if (w.left.color == BLACK && w.right.color == BLACK) {
					w.color = RED;
					x = x.parent;
				} else {
					if (w.right.color == BLACK) {
						w.left.color = BLACK;
						w.color = RED;
						rotateRight(w);
						w = x.parent.right;
					}
					w.color = x.parent.color;
					x.parent.color = BLACK;
					w.right.color = BLACK;
					rotateLeft(x.parent);
					x = root;
				}
			} else {
				RedBlackNode<T> w = x.parent.left;
				if (w.color == RED) {
					w.color = BLACK;
					x.parent.color = RED;
					rotateRight(x.parent);
					w = x.parent.left;
				}
				if (w.right.color == BLACK && w.left.color == BLACK) {
					w.color = RED;
					x = x.parent;
				} else {
					if (w.left.color == BLACK) {
						w.right.color = BLACK;
						w.color = RED;
						rotateLeft(w);
						w = x.parent.left;
					}
					w.color = x.parent.color;
					x.parent.color = BLACK;
					w.left.color = BLACK;
					rotateRight(x.parent);
					x = root;
				}
			}
		}
		x.color = BLACK;
	}
	
	public T get(int key) {
		return findNode(key).value;
	}
	
	private RedBlackNode<T> findNode(int key) {
		RedBlackNode<T> x = root;
		while (x != sentinal) {
			if (x.key == key)
				return x;
			if (key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		return x;
	}
	
	private void rotateLeft(RedBlackNode<T> x) {
		RedBlackNode<T> y = x.right;
		x.right = y.left;
		if (y.left != sentinal)
			y.left.parent = x;
		y.parent = x.parent;
		if (x.parent == sentinal)
			root = y;
		else if (x == x.parent.left)
			x.parent.left = y;
		else
			x.parent.right = y;
		y.left = x;
		x.parent = y;
	}
	
	private void rotateRight(RedBlackNode<T> x) {
		RedBlackNode<T> y = x.parent;
		x.parent = y.parent;
		if (y.parent == sentinal)
			root = x;
		else if (y.parent.left == y)
			x.parent.left = x;
		else
			x.parent.right = x;
		y.left = x.right;
		if (x.right != sentinal)
			x.right.parent = y;
		x.right = y;
		y.parent = x;
	}
	
}
