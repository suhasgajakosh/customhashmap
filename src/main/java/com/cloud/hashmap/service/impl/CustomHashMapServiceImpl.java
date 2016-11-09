package com.cloud.hashmap.service.impl;

import org.springframework.stereotype.Service;

import com.cloud.hashmap.service.CustomHashMapService;

@Service
public class CustomHashMapServiceImpl<K, V> implements CustomHashMapService<K, V> {

	private Entry<K, V>[] hashTable;
	private int size = 16;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public CustomHashMapServiceImpl() {
		hashTable = new Entry[size];
	}

	@Override
	public void put(K key, V value) {

		if (null == key) {
			return;
		}

		int hash = hashKey(key);

		// create new entry.
		Entry<K, V> newEntry = new Entry<K, V>(key, value, null);

		// if hashTable location does not contain any entry, store entry there.
		if (hashTable[hash] == null) {
			hashTable[hash] = newEntry;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = hashTable[hash];

			while (current != null) { // we have reached last entry of bucket.
				if (current.key.equals(key)) {
					if (previous == null) { // node has to be insert on first of
											// bucket.
						newEntry.next = current.next;
						hashTable[hash] = newEntry;
						return;
					} else {
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}

	@Override
	public V get(K key) {
		int hash = hashKey(key);
		if (hashTable[hash] == null) {
			return null;
		} else {
			Entry<K, V> temp = hashTable[hash];
			while (temp != null) {
				if (temp.key.equals(key))
					return temp.value;
				temp = temp.next; // return value corresponding to key.
			}
			return null; // returns null if key is not found.
		}
	}

	@Override
	public boolean remove(K key) {
		int hash = hashKey(key);

		if (hashTable[hash] == null) {
			return false;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = hashTable[hash];

			while (current != null) { // we have reached last entry node of
										// bucket.
				if (current.key.equals(key)) {
					if (previous == null) { // delete first entry node.
						hashTable[hash] = hashTable[hash].next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}
	}

	private int hashKey(K key) {
		return Math.abs(key.hashCode()) % size;
	}

}
