package com.chrisluttio.cs.hashtables;

public class OpenAddressNode<T> {
	public String key;
	public T value;
	
	public OpenAddressNode(String key, T value) {
		this.key = key;
		this.value = value;
	}
	
	public static <V> OpenAddressNode<V> Nil() {
		return new OpenAddressNode<V>(null, null);
	}
}
