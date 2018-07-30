package cs.chrisluttio.cs.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chrisluttio.cs.hashtables.LinearAddressTable;

public class LinearAddressTableTester {
	
	@Test
	public void testInit() {
		LinearAddressTable<String> table = new LinearAddressTable<>(10);
		assertNotEquals(null, table);
	}
	
	@Test
	public void testInsertAndGet() {
		LinearAddressTable<String> table = new LinearAddressTable<>(10);
		table.insert("king", "Alexander");
		assertEquals("Alexander", table.get("king"));
	}
	
	@Test
	public void testManyInsert() {
		LinearAddressTable<String> table = new LinearAddressTable<>(10);
		table.insert("Country", "Rome");
		table.insert("Senator", "Cicero");
		table.insert("consul", "Pompey");
		table.insert("imperium", "propraetorian");
		assertEquals("Rome", table.get("Country"));
		assertEquals("Cicero", table.get("Senator"));
		assertEquals("Pompey", table.get("consul"));
		assertEquals("propraetorian", table.get("imperium"));
	}
	
	@Test
	public void testRemove() {
		LinearAddressTable<String> table = new LinearAddressTable<>(10);
		table.insert("house", "Stark");
		assertEquals("Stark", table.get("house"));
		table.remove("house");
		assertEquals(null, table.get("house"));
	}
	
	@Test
	public void testClear() {
		LinearAddressTable<String> table = new LinearAddressTable<>(5);
		table.insert("house", "Stark");
		table.insert("Country", "Rome");
		table.insert("Senator", "Cicero");
		table.insert("consul", "Pompey");
		table.insert("imperium", "propraetorian");
		table.clear();
		assertEquals(null, table.get("house"));
		assertEquals(null, table.get("Country"));
		assertEquals(null, table.get("Senator"));
		assertEquals(null, table.get("consul"));
		assertEquals(null, table.get("imperium"));
	}
	
}
