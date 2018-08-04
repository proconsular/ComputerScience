package cs.chrisluttio.cs.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.chrisluttio.cs.trees.RedBlackTree;

public class RedBlackTreeTester {
	
	@Test
	public void testInit() {
		RedBlackTree<String> tree = new RedBlackTree<>();
		assertNotEquals(null, tree);
	}
	
	@Test
	public void testInsertAndGet() {
		RedBlackTree<String> tree = new RedBlackTree<>();
		tree.insert(4, "Jon");
		tree.insert(9, "Timmy");
		tree.insert(2, "Timith");
		tree.insert(5, "Jordan");
		assertEquals("Jon", tree.get(4));
		assertEquals("Timmy", tree.get(9));
		assertEquals("Timith", tree.get(2));
		assertEquals("Jordan", tree.get(5));
		assertEquals(null, tree.get(11));
	}
	
	@Test
	public void testRemoval() {
		RedBlackTree<String> tree = new RedBlackTree<>();
		tree.insert(5, "Baker");
		tree.insert(3, "Bartender");
		tree.insert(10, "Banker");
		assertEquals("Bartender", tree.get(3));
		tree.delete(3);
		assertEquals(null, tree.get(3));
		assertEquals("Baker", tree.get(5));
		assertEquals("Banker", tree.get(10));
		tree.insert(1, "Teller");
		assertEquals("Teller", tree.get(1));
	}
	
	@Test
	public void testMassInput() {
		final int amount = 1000000;
		ArrayList<Integer> list = new ArrayList<>();
		RedBlackTree<Integer> tree = new RedBlackTree<>();
		for (int i = 0; i < amount; i++) {
			list.add((int)(Math.random() * (double)amount));
		}
		for (int i = 0; i < amount; i++) {
			tree.insert(i, list.get(i));
		}
		for (int i = 0; i < amount; i++) {
			assertEquals(list.get(i), tree.get(i));
		}
		for (int i = 0; i < amount; i++) {
			tree.delete(i);
		}
		for (int i = 0; i < amount; i++) {
			assertEquals(null, tree.get(i));
		}
	}
	
	@Test
	public void testInOrderTraversal() {
		RedBlackTree<Integer> tree = new RedBlackTree<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		for (int i = 0; i < 100; i++) {
			tree.insert(i, i);
		}
		list.sort((a, b) -> {
			return a.compareTo(b);
		});
		ArrayList<Integer> tl = tree.getTraversal();
		assertArrayEquals(list.toArray(), tl.toArray());
	}
	
	@Test
	public void testIterate() {
		RedBlackTree<Integer> tree = new RedBlackTree<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		for (int i = 0; i < 100; i++) {
			tree.insert(i, i);
		}
		int[] x = new int[1];
		x[0] = 0;
		tree.iterate(value -> {
			assertEquals(list.get(x[0]), value);
			x[0]++;
		});
	}
	
}
