package cs.chrisluttio.cs.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chrisluttio.cs.hashtables.QuadraticAddressTable;

public class QuadraticAddressTableTester {

	@Test
	public void testInit() {
		QuadraticAddressTable<String> table = new QuadraticAddressTable<>(10);
		assertNotEquals(null, table);
	}
	
	@Test
	public void testInsertAndGet() {
		QuadraticAddressTable<String> table = new QuadraticAddressTable<>(10);
		table.insert("president", "washington");
		assertEquals("washington", table.get("president"));
	}
	
	@Test
	public void testManyInsert() {
		QuadraticAddressTable<String> table = new QuadraticAddressTable<>(10);
		table.insert("president", "washington");
		table.insert("consul", "Pompey");
		table.insert("praetor", "Claudian");
		table.insert("emperor", "Napoleon");
		assertEquals("washington", table.get("president"));
		assertEquals("Pompey", table.get("consul"));
		assertEquals("Claudian", table.get("praetor"));
		assertEquals("Napoleon", table.get("emperor"));
	}
	
	@Test
	public void testRemove() {
		QuadraticAddressTable<String> table = new QuadraticAddressTable<>(10);
		table.insert("president", "washington");
		assertEquals("washington", table.get("president"));
		table.remove("president");
		assertEquals(null, table.get("president"));
	}
	
}
