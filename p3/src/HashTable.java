/////////////////////////////////////////////////////////////////////////////
// 
// Project:          HashTable with Performance Analysis
// Files:            HashTable.java
//		     HashTableADT.java
// 		     PerformanceAnalysis.java
//		     PerformanceAnalysisHash.java
//		     AnalysisTest.java
// Semester:         CS400 Spring 2018
// Author(s):	     Brennan Fife, Dustin Li
// Instructor:       Deb Deppeler 
// Due Date:         3/19/2018
// Bugs:             No known bugs
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * HashTable Implementation.
 * @param K Key of hashed value
 * @param V Value of associated key
 */
public class HashTable<K, V> implements HashTableADT<K, V> {
    /* Initial instance variables and constructors for setup
     */
	protected class HashNode<K, V> { 
		private K k;
		private V v;
		private HashNode<K, V> next;
		
		public HashNode(K k, V v) { 
			this.k = k;
			this.v = v;
		}
	}
	private HashNode<K, V>[] table;
	private int tableSize = 7;		//capacity of HashTable. Want a prime number here
	private double loadFactor = 0.8;	//maximum load factor of HashTable.
	private int num; 			//number of current items inside HashTable
	
    /**
     * Constructor to that will set hashtable's array to size of initialCapacity. 
     * @param initialCapacity Initial capacity of table
     * @param loadFactor Initial load factor
     */
	public HashTable(int initialCapacity, double loadFactor) {
		this.loadFactor = loadFactor;
		this.tableSize = initialCapacity;
		table = new HashNode[tableSize];
		for (int i = 0; i < tableSize; i++) {
			table[i] = null;
		}	
	}
	
	public HashTable()
	{
		this(7,0.8);		
	}
   /**
    * @key key of desired hashCode.
    * @hashNum Returned hashcode of key
    */
    private int getHashNum(K key) {
    		int hashCode = key.hashCode();
    		int hashNum = hashCode % tableSize;
    		return hashNum;
    }
	
   /**
    * Resizes hashtable when needed.
    */
	private void resize() {
    	double loadFactor = (num/tableSize);
    		if (loadFactor > this.loadFactor) {
    		int newSize = tableSize * 2;
    		tableSize = newSize;
    		HashNode<K, V>[] newTable = new HashNode[newSize];
    		for (int i = 0; i < tableSize; i++) {
    			newTable[i] = table[i];
    			table = newTable;
    		}
    	}
    }
    
    /**
     * Checks if value is valid to be inserted. 
     * Properly insert into table. Resize when needed. 
     * @param key The key being inserted into the hashtable
     * @param value The value from the key
     * @throws  IllegalArgumentException with invalid key
     * @return value
     */
    @Override
    public V put(K key, V value) { 
    		if (key == null || get(key) != null) {
    			throw new IllegalArgumentException("Invalid Key");
    		}
    		else {
    			int hashValue = getHashNum(key);
			if (table[hashValue] == null) {
				table[hashValue] = new HashNode<>(key, value);
				num++;
				resize();
			}
			else {
				HashNode<K, V> temp = table[hashValue];
				temp.next = new HashNode<K, V>(key, value);
				table[hashValue] = temp;
				num++;
				resize();
    			}
    		}
		return value;
    }
   /**
    * Clears hashtable
    */
    @Override
    public void clear() {
    		table = new HashNode[tableSize];
    		num = 0;
    }
    /**
     * Gets value associated with the key from the Hash Table
     * @param key Value is to be returned.
     * @return returns the value associated with the key. Otherwise will return null if key DNE.
     * @throws IllegalArgumentException When invalid input is given
     */
    @Override
    public V get(K key) { 
	    if (key == null) {
        	throw new IllegalArgumentException();
            }
    	    for (int i = 0; i < tableSize; i++) {
        	if (table[i].k.equals(key)) {
        		return table[i].v;
        	}
        	else {
        		HashNode<K, V> temp = table[i].next;
        		while(temp != null) {
        			if (temp.k.equals(key)) {
        				return temp.v;
        			}
        			else {
        				temp = temp.next;
        			}
        		}
        	}
        	}
        return null;
    }
	
   /**
    * Checks if empty
    * @return True if empty
    */
    @Override
    public boolean isEmpty() {
    	return num == 0; 
    }
	
   /**
    * @param key The entry looking to be removed
    * @return returns the value looking to be removed.
    * @throws IllegalArgumentException if the key looking to be removed DNE.
    */
    @Override
	public V remove(K key) {
        	if (key == null || get(key) == null) {
        		throw new IllegalArgumentException();
        	}
        	int hashValue = getHashNum(key);
        	if (table[hashValue].k.equals(key)) {
        		V ret = table[hashValue].v;
        		table[hashValue] = table[hashValue].next;
        		return ret;
        	}
        	else {
        		HashNode<K, V> prev = null;
        		HashNode<K, V> curr = table[hashValue];
        		prev.next = curr;
        		while (curr.next != null) {
        			if (curr.k.equals(key)) {
        				prev.next = curr.next;
        				return curr.v;
        			}
        			else {
        				prev = curr;
        				curr = curr.next;
        			}
        		}
		}
	return null; 
    }
	
   /**
    * @return Returns the tableSize, which is the total number of entries in the hashtable
    */
    @Override
    public int size() {
        return tableSize;
    }
}
