package cs.chrisluttio.cs.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import com.chrisluttio.cs.lists.single.LinkedList;

/**
 * 
 * Single Linked List
 * 
 * Methods
 * 
 * - Insertion
 * 	- Prepend(T)
 * 	- Append(T)
 * 	- Insert(int, T)
 * - Removal
 * 	- RemoveFirst()
 * 	- RemoveLast()
 * 	- Remove(int)
 * - Access
 * 	- Get(int)
 * 	- GetFirst()
 * 	- GetLast()
 * - Union(LinkedList)
 * - Split()
 * - Reverse()
 * - Reverse(int, int)
 * - Clear()
 * - Size()
 * 
 */

public class SingleLinkedListTester {
	
	@Test
	public void testCreate() {
		LinkedList<Integer> list = new LinkedList<>();
		assertNotEquals(list, null);
	}
	
	@Test
	public void testPrepend() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(4);
		assertEquals(list.head.value, new Integer(4));
	}
	
	@Test
	public void testTwoPrepends() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(5);
		list.prepend(9);
		assertEquals(list.head.value, new Integer(9));
	}
	
	@Test
	public void testListIntegrity() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(10);
		list.prepend(3);
		assertEquals(list.head.value, new Integer(3));
		assertEquals(list.head.next.value, new Integer(10));
	}
	
	@Test
	public void testGetFirst() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(4);
		assertEquals(list.get(0), new Integer(4));
	}
	
	@Test
	public void testGetTwo() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(9);
		list.prepend(14);
		assertEquals(list.get(0), new Integer(14));
		assertEquals(list.get(1), new Integer(9));
		assertNotEquals(list.get(0), list.get(1));
	}
	
	@Test
	public void testGetNil() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(3);
		list.prepend(17);
		assertEquals(list.get(3), null);
	}
	
	@Test
	public void testFirst() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(3);
		list.prepend(17);
		assertEquals(new Integer(17), list.getFirst());
		assertNotEquals(new Integer(3), list.getFirst());
	}
	
	@Test
	public void testEmptyFirst() {
		LinkedList<Integer> list = new LinkedList<>();
		assertEquals(null, list.getFirst());
	}
	
	@Test
	public void testLast() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(3);
		list.prepend(17);
		assertEquals(new Integer(3), list.getLast());
		assertNotEquals(new Integer(17), list.getLast());
	}
	
	@Test
	public void testEmptyLast() {
		LinkedList<Integer> list = new LinkedList<>();
		assertEquals(null, list.getLast());
	}
	
	@Test
	public void testRemoveFirst() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(21);
		list.removeFirst();
		assertEquals(list.get(0), null);
	}
	
	@Test
	public void testRemoveFirstButGet() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(21);
		list.prepend(7);
		list.removeFirst();
		assertEquals(list.get(0), new Integer(21));
	}
	
	@Test
	public void testEmptyRemoveFirst() {
		LinkedList<Integer> list = new LinkedList<>();
		list.removeFirst();
		assertEquals(list.get(0), null);
	}
	
	@Test
	public void testTwoPrependsRemoveAndPrepend() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(21);
		list.prepend(7);
		list.removeFirst();
		list.prepend(9);
		assertEquals(list.get(0), new Integer(9));
		assertEquals(list.get(1), new Integer(21));
	}
	
	@Test
	public void testRemoveAny() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(7);
		list.prepend(12);
		list.prepend(11);
		list.prepend(19);
		list.prepend(1);
		assertEquals(list.get(4), new Integer(7));
		list.remove(4);
		assertEquals(list.get(4), null);
		assertEquals(list.get(1), new Integer(19));
		list.remove(1);
		assertNotEquals(list.get(1), new Integer(19));
		assertEquals(list.get(1), new Integer(11));
	}
	
	@Test
	public void testEmptyRemoveAny() {
		LinkedList<Integer> list = new LinkedList<>();
		list.remove(4);
		assertEquals(list.get(4), null);
	}
	
	@Test
	public void testRemoveLast() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(4);
		list.prepend(10);
		list.prepend(3);
		assertEquals(new Integer(4), list.get(2));
		list.removeLast();
		assertEquals(null, list.get(2));
	}
	
	@Test
	public void testEmptyRemoveLast() {
		LinkedList<Integer> list = new LinkedList<>();
		list.removeLast();
		assertEquals(null, list.get(0));
	}
	
	@Test
	public void testTwoRemoveLast() {
		LinkedList<Integer> list = new LinkedList<>();
		list.prepend(4);
		list.prepend(3);
		list.removeLast();
		list.removeLast();
		assertEquals(null, list.get(1));
		assertEquals(null, list.get(0));
	}
	
	@Test
	public void testAppend() {
		LinkedList<Integer> list = new LinkedList<>();
		list.append(4);
		assertEquals(list.get(0), new Integer(4));
	}
	
	@Test
	public void testTwoAppend() {
		LinkedList<Integer> list = new LinkedList<>();
		list.append(9);
		list.append(10);
		assertEquals(list.get(0), new Integer(9));
		assertEquals(list.get(1), new Integer(10));
	}
	
	@Test
	public void testInsert() {
		LinkedList<Integer> list = new LinkedList<>();
		list.insert(0, 5);
		assertEquals(new Integer(5), list.get(0));
		list.insert(0, 10);
		assertEquals(new Integer(10), list.get(0));
		list.insert(1, 3);
		assertEquals(new Integer(3), list.get(1));
		assertEquals(new Integer(5), list.get(2));
	}
	
	@Test
	public void testUnion() {
		LinkedList<Integer> A = new LinkedList<>();
		A.prepend(3);
		A.prepend(9);
		LinkedList<Integer> B = new LinkedList<>();
		B.prepend(10);
		B.prepend(2);
		A.union(B);
		assertEquals(new Integer(9), A.get(0));
		assertEquals(new Integer(2), A.get(2));
		assertEquals(B.getLast(), A.getLast());
		assertNotEquals(B.getFirst(), A.getFirst());
	}
	
	@Test
	public void testClear() {
		LinkedList<Integer> A = new LinkedList<>();
		A.prepend(3);
		A.prepend(9);
		A.prepend(4);
		A.clear();
		assertEquals(null, A.get(0));
		assertEquals(null, A.get(1));
		assertEquals(null, A.get(2));
	}
	
	public void testSize() {
		LinkedList<Integer> A = new LinkedList<>();
		A.prepend(3);
		A.prepend(9);
		A.prepend(4);
		assertEquals(3, A.getSize());
		A.removeFirst();
		assertEquals(2, A.getSize());
	}
	
	@Test
	public void testSplit() {
		LinkedList<Integer> A = new LinkedList<>();
		A.prepend(3);
		A.prepend(9);
		A.prepend(4);
		LinkedList<Integer> B = A.split(1);
		assertEquals(new Integer(9), B.get(0));
		assertEquals(new Integer(3), B.get(1));
	}
	
}
