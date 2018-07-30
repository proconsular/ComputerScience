package com.chrisluttio.cs.hashtables;

public class OpenAddressTable<V> {
	private int load, size;
	public OpenAddressNode<V>[] nodes;
	
	@SuppressWarnings("unchecked")
	public OpenAddressTable(int size) {
		this.size = size;
		this.load = 0;
		nodes = new OpenAddressNode[size];
	}
	
	private int computeHash(String key, int i) {
		double k = computeAsciiSummation(key) + i;
		final double A = 0.6180339887;
		return (int)(size * ((k * A) % 1));
	}
	
	private int computeAsciiSummation(String key) {
		int sum = 0;
		for (char i: key.toCharArray()) {
			sum += (int)i;
		}
		return sum;
	}
	
	public void insert(String key, V value) {
		int i = 0;
		do {
			int j = computeHash(key, i);
			if (nodes[j] == null) {
				nodes[j] = new OpenAddressNode<V>(key, value);
				break;
			} else if (nodes[j].key == null) { 
				nodes[j] = new OpenAddressNode<V>(key, value);
				break;
			} else {
				i++;
			}
		} while (i == size);
	}
	
	public V get(String key) {
		int slot = getSlot(key);
		return slot == -1 ? null : nodes[slot].value;
	}
	
	private int getSlot(String key) {
		int i = 0;
		int j = 0;
		do {
			j = computeHash(key, i);
			if (nodes[j] != null) {
				if (nodes[j].key == key)
					return j;
			} else
				i++;
		} while (nodes[j] == null || i == size);
		return -1;
	}
	
	public void remove(String key) {
		int slot = getSlot(key);
		if (slot != -1)
			nodes[slot] = OpenAddressNode.Nil();
	}
	
	public void clear() {
		for (int i = 0; i < size; i++)
			if (nodes[i] != null)
				nodes[i] = OpenAddressNode.Nil();
	}
	
}
