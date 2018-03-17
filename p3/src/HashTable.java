/////////////////////////////////////////////////////////////////////////////
// 
// Project:          HashTable with Performance Analysis
// Files:            HashTableADT.java
//					 HashTable.java
// 					 PerformanceAnalysis.java
//					 PerformanceAnalysisHash.java
//					 AnalysisTest.java
// Semester:         CS400 Spring 2018
// Author(s):		 Brennan Fife, Dustin Li
// Instructor:       Deb Deppeler 
// Bugs:             No known bugs
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTable<K, V> implements HashTableADT<K, V> {
    /* Instance variables and constructors
     */
	protected class HashNode<K, V> {
		private K k;
		private V v;
		private HashNode<K, V> link;
		
		public HashNode(K k, V v) { //CONSTRUCTOR
			this.k = k;
			this.v = v;
		}
	}
	private ArrayList<HashNode<K, V>> buckets;
	private int tableSize;//capacity of HashTable 
	private double loadFactor;	//maximum load factor of HashTable 
	private int num; //number of current items inside HashTable
	
	public HashTable(int initialCapacity, double loadFactor) {
		this.loadFactor = loadFactor;
		this.tableSize = initialCapacity;
		buckets = new ArrayList<HashNode<K, V>>();
		for (int i = 0; i < tableSize; i++) {
			buckets.add(null);
		}	
	}
	
    @Override
    public V put(K key, V value) {
    	//TODO: Implement put method - using efficient algorithm
        return null;
    }

    @Override
    public void clear() {
    }

    @Override
    public V get(K key) {
        //TODO: Implement the get method
        return null;
    }

    @Override
    public boolean isEmpty() {
    if num == 0 : return true;
    }

    @Override
    public V remove(K key) {
       //TODO: Implement the remove method
        return null;
    }

    @Override
    public int size() {
        return tableSize;
    }
}
