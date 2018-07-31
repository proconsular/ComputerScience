package cs.chrisluttio.cs.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chrisluttio.cs.trees.BinarySearchTree;

public class BinarySearchTreeTester {
	
	@Test
	public void testInit() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		assertNotEquals(null, tree);
	}
	
	@Test
	public void testInsertAndGet() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.insert(3, "John");
		tree.insert(5, "Ryan");
		tree.insert(2, "Jake");
		tree.insert(7, "Jonny");
		tree.insert(4, "Ronny");
		assertEquals("Jake", tree.get(2));
		assertEquals("John", tree.get(3));
		assertEquals("Ryan", tree.get(5));
		assertEquals("Jonny", tree.get(7));
		assertEquals("Ronny", tree.get(4));
	}
	
	@Test
	public void testRemove() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.insert(3, "John");
		tree.insert(5, "Ryan");
		tree.insert(2, "Jake");
		assertEquals("John", tree.get(3));
		assertEquals("Ryan", tree.get(5));
		assertEquals("Jake", tree.get(2));
		tree.remove(2);
		assertEquals(null, tree.get(2));
		assertEquals("John", tree.get(3));
		assertEquals("Ryan", tree.get(5));
	}
	
	@Test
	public void testInorderTraversal() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(1, 1);
		tree.insert(9, 9);
		tree.insert(4, 4);
		tree.insert(15, 15);
		tree.insert(2, 2);
		assertArrayEquals(new Integer[] {1, 2, 4, 9, 15}, tree.getInorderTraversal().toArray());
		
		BinarySearchTree<String> tre = new BinarySearchTree<>();
		tre.insert(3, "Jim");
		tre.insert(5, "Kim");
		tre.insert(7, "Jonny");
		tre.insert(1, "Joe");
		assertArrayEquals(new String[] {"Joe", "Jim", "Kim", "Jonny"}, tre.getInorderTraversal().toArray());
	}
	
}
