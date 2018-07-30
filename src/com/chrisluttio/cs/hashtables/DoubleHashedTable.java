package com.chrisluttio.cs.hashtables;

public class DoubleHashedTable<V> {
	private static final int NIL = -1;
	private OpenAddressNode<V>[] nodes;
	private int size;
	
	@SuppressWarnings("unchecked")
	public DoubleHashedTable(int size) {
		this.size = size;
		this.nodes = new OpenAddressNode[size];
	}
	
	public void insert(String key, V value) {
		OpenAddressNode<V> node = new OpenAddressNode<>(key, value);
		int probe = 0;
		int index = 0;
		do {
			index = _hash(key, probe);
			if (isEmpty(index)) {
				nodes[index] = node;
				return;
			}
			probe++;
		} while (probe < size);
	}
	
	public V get(String key) {
		int index = probe(key);
		return index != NIL ? nodes[index].value : null;
	}
	
	public void remove(String key) {
		int index = probe(key);
		if (index != NIL)
			nodes[index] = OpenAddressNode.Nil();
	}
	
	public int probe(String key) {
		int probe = 0;
		int index = 0;
		do {
			index = _hash(key, probe);
			if (!isEmpty(index))
				return index;
			probe++;
		} while (probe < size);
		return NIL;
	}
	
	private boolean isEmpty(int index) {
		if (nodes[index] == null)
			return true;
		if (nodes[index].key == null)
			return true;
		return false;
	}
	
	private int _hash(String key, int probe) {
		final int k = _convert(key);
		return (int)((_primary_hash(k) + probe * _secondary_hash(k)) % size);
	}
	
	private int _primary_hash(int key) {
		return key % size;
	}
	
	private int _secondary_hash(int key) {
		return 1 + (key % 17);
	}
	
	private int _convert(String key) {
		int sum = 0;
		for (char i: key.toCharArray()) {
			sum += (int)i;
		}
		return sum;
	}
	
}
