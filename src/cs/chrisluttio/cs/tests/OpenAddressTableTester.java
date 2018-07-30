package cs.chrisluttio.cs.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import com.chrisluttio.cs.hashtables.OpenAddressTable;

public class OpenAddressTableTester {

	@Test
	public void testCreation() {
		OpenAddressTable<String> table = new OpenAddressTable<>(10);
		assertNotEquals(null, table);
	}
	
	@Test
	public void testInsertionAndGet() {
		OpenAddressTable<String> table = new OpenAddressTable<>(10);
		table.insert("Data", "Test");
		assertEquals("Test", table.get("Data"));
	}
	
	@Test
	public void testMultiInsert() {
		OpenAddressTable<String> table = new OpenAddressTable<>(5);
		table.insert("SomeInfo", "Data");
		table.insert("Hello", "Info");
		table.insert("Where", "Who");
		table.insert("Judge", "Colten");
		assertEquals("Data", table.get("SomeInfo"));
		assertEquals("Info", table.get("Hello"));
		assertEquals("Who", table.get("Where"));
		assertEquals("Colten", table.get("Judge"));
	}
	
	@Test
	public void testRemove() {
		OpenAddressTable<String> table = new OpenAddressTable<>(10);
		table.insert("proconsul", "Caesar");
		assertEquals("Caesar", table.get("proconsul"));
		table.remove("proconsul");
		assertEquals(null, table.get("proconsul"));
	}
	
	@Test
	public void testReplace() {
		OpenAddressTable<String> table = new OpenAddressTable<>(10);
		table.insert("proconsul", "Caesar");
		assertEquals("Caesar", table.get("proconsul"));
		table.remove("proconsul");
		assertEquals(null, table.get("proconsul"));
		table.insert("proconsul", "Claudius");
		assertEquals("Claudius", table.get("proconsul"));
	}
	
	@Test
	public void testClear() {
		OpenAddressTable<String> table = new OpenAddressTable<>(5);
		table.insert("SomeInfo", "Data");
		table.insert("Hello", "Info");
		table.insert("Where", "Who");
		table.insert("Judge", "Colten");
		table.clear();
		assertEquals(null, table.get("SomeInfo"));
		assertEquals(null, table.get("Hello"));
		assertEquals(null, table.get("Where"));
		assertEquals(null, table.get("Judge"));
	}
	
}
