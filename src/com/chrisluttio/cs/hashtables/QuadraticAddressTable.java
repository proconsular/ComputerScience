package com.chrisluttio.cs.hashtables;

public class QuadraticAddressTable<V> {
	private OpenAddressNode<V>[] nodes;
	private int size;
	
	@SuppressWarnings("unchecked")
	public QuadraticAddressTable(int size) {
		this.size = size;
		this.nodes = new OpenAddressNode[size];
	}
	
	public void insert(String key, V value) {
		OpenAddressNode<V> node = new OpenAddressNode<>(key, value);
		int probe = 0;
		int hash = 0;
		do {
			hash = _hash(key, probe);
			if (nodes[hash] == null) {
				nodes[hash] = node;
				return;
			} else if (nodes[hash].key == null) {
				nodes[hash] = node;
				return;
			}
			probe++;
		} while (probe < size);
	}
	
	public V get(String key) {
		int index = getIndex(key);
		return index != -1 ? nodes[index].value : null;
	}
	
	public void remove(String key) {
		int index = getIndex(key);
		if (index != -1)
			nodes[index] = OpenAddressNode.Nil();
	}
	
	private int getIndex(String key) {
		int probe = 0;
		int hash = 0;
		do {
			hash = _hash(key, probe);
			if (nodes[hash] != null)
				if (nodes[hash].key == key)
					return hash;
			probe++;
		} while (probe < size);
		return -1;
	}
	
	private int _hash(String key, int probe) {
		final double A = 0.5;
		final double B = 2;
		return (int)((_aux_hash(key) + A * probe + B * probe * probe) % size);
	}
	
	private int _aux_hash(String key) {
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
	
}
