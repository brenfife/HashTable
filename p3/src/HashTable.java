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

public class HashTable<K, V> implements HashTableADT<K, V> {
    /* Instance variables and constructors
     */
	HashT<T<K, V>>[] hashTable;
	private int size = 1000;//given
	final private double loadFactor = 0.	;	//choose our load factor
	final private int hashes = 0; //number of current items
	
	public HashTable() {
		hashTable = new HashT[size];
		for (int i = 0; i < size; i++) {
			hashTable[i] = new HashT(); 
		}
	}

	public class HashT<List> {
		public ArrayList<List> num;
		//Constructor
		public HashT() {
			num = new ArrayList<>();
		}
	}
	
	public class List <K, V> {
		public final K, k;
		public final V, v;
		public List (K k, V v) {
			this.k = k;
			this.v = v;
		}
	}
	
    @Override
    public V put(K key, V value) {
        int hashValue = getHashValue(key);
        HashT<List<K, V>> //TODO: Implement put method - using efficient algorithm
        for()return null;
    }

    @Override
    public void clear() {
       table = new 
    }

    @Override
    public V get(K key) {
        //TODO: Implement the get method
        return null;
    }

    @Override
    public boolean isEmpty() {
        return numI == 0;
    }

    @Override
    public V remove(K key) {
       //TODO: Implement the remove method
        return null;
    }

    @Override
    public int size() {
        //TODO: Implement this method
        return 0;
    }
}
