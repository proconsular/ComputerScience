package com.chrisluttio.cs.hashtables;

public class LinearAddressTable<V> {
	private OpenAddressNode<V>[] nodes;
	private int size;
	
	@SuppressWarnings("unchecked")
	public LinearAddressTable(int size) {
		this.size = size;
		nodes = new OpenAddressNode[size];
	}
	
	private int computeHash(String key, int probe) {
		return (computeAuxiliaryHash(key) + probe) % size;
	}
	
	private int computeAuxiliaryHash(String key) {
		double k = computeAsciiSummation(key);
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
		int j = 0;
		do {
			j = computeHash(key, i);
			if (nodes[j] == null) {
				nodes[j] = new OpenAddressNode<V>(key, value);
				break;
			} else if (nodes[j].key == null) { 
				nodes[j] = new OpenAddressNode<V>(key, value);
				break;
			}
			i++;
		} while (i < size);
	}
	
	public V get(String key) {
		int index = search(key);
		return index != -1 ? nodes[index].value : null;
	}
	
	public void remove(String key) {
		int index = search(key);
		if (index != -1)
			nodes[index] = OpenAddressNode.Nil();
	}
	
	private int search(String key) {
		int i = 0;
		int j = 0;
		do {
			j = computeHash(key, i);
			if (nodes[j] != null)
				if (nodes[j].key == key)
					return j;
			i++;
		} while (i < size);
		return -1;
	}
	
	public void clear() {
		for (int i = 0; i < size; i++)
			if (nodes[i] != null)
				nodes[i] = OpenAddressNode.Nil();
	}
	
}
