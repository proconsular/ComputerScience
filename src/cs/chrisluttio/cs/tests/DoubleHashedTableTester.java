package cs.chrisluttio.cs.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chrisluttio.cs.hashtables.DoubleHashedTable;

public class DoubleHashedTableTester {
	
	@Test
	public void testInit() {
		DoubleHashedTable<String> table = new DoubleHashedTable<>(10);
		assertNotEquals(null, table);
	}
	
	@Test
	public void testInsertAndGet() {
		DoubleHashedTable<String> table = new DoubleHashedTable<>(10);
		table.insert("lord", "jon");
		assertEquals("jon", table.get("lord"));
	}
	
	@Test
	public void testManyInsert() {
		DoubleHashedTable<String> table = new DoubleHashedTable<>(10);
		table.insert("lord", "jon");
		table.insert("king", "gofry");
		table.insert("baker", "ryan");
		assertEquals("jon", table.get("lord"));
		assertEquals("gofry", table.get("king"));
		assertEquals("ryan", table.get("baker"));
	}
	
	@Test
	public void testRemove() {
		DoubleHashedTable<String> table = new DoubleHashedTable<>(10);
		table.insert("lord", "jon");
		assertEquals("jon", table.get("lord"));
		table.remove("lord");
		assertEquals(null, table.get("lord"));
	}
	
}
