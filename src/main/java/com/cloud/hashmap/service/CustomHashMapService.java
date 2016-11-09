package com.cloud.hashmap.service;

public interface CustomHashMapService<K,V> {
	
	public void put(K newKey, V data);
	public V get(K key);
	public boolean remove(K deleteKey);
	
}
