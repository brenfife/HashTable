/////////////////////////////////////////////////////////////////////////////
// 
// Project:          HashTable with Performance Analysis
// Files:            PerformanceAnalysisHash.java
//		     HashTableADT.java
//		     HashTable.java
// 		     PerformanceAnalysis.java
//		     PerformanceAnalysisHash.java
//		     AnalysisTest.java
// Semester:         CS400 Spring 2018
// Author(s):	     Brennan Fife, Dustin Li
// Instructor:       Deb Deppeler 
// Due Date:         3/19/2018
// Bugs:             Code throws a Null Pointer Exception when calling inputData.size(), 
//		     Eclipse throws a null pointer at line 63, which was a blank space.
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

/**
* Class that compares the performance in memory and speed of a hash table to a Java tree map
*/
public class PerformanceAnalysisHash implements PerformanceAnalysis {

    // The input data from each file is stored in this/ per file
    private ArrayList<String> inputData;
    private String fileName;
    private TreeMap testTree;
    private HashTable testTable;
    private String test; //test string taht represents the value
    private String insertReport; //results of the compare insertion method
    private String deleteReport; //results of the compare deletion method
    private String searchReport; //results of the compare search method
    private String printReport; //final report
    
    /**
    * Default constructor for the PerformanceAnalysisHash class initializes the testTree and testTable
    */
    public PerformanceAnalysisHash()
    {
    		test = "hello";
    		testTree = new TreeMap<>();
    		testTable = new HashTable<>();
    }
    
    /**
    * Constructor for the PerformanceAnalysisHash class that tries to read the input file and
    * throws catches the IOException that is thrown when the filename is invalid
    */
    public PerformanceAnalysisHash(String details_filename){
    		this();
    		fileName = details_filename;
    		try 
    		{
    			loadData(details_filename);
    		} 
    		catch (IOException e)
    		{
    			e.printStackTrace();
    			System.out.println("Invalid File");
    		}
    }
    
    /**
    * Method that calls all the compare methods and combines the reports of each method into a single string
    */
    @Override
    public void compareDataStructures() {
        //TODO: Complete this function which compares the ds and generates the details
    		compareInsertion();
    		compareSearch();
    		compareDeletion();
    		printReport = insertReport + "\n" + searchReport + "\n" + deleteReport + "\n";
    }
    
    /**
    * Prints out the all the data from each compare method in one final report
    */
    @Override
    public void printReport() {
        //TODO: Complete this method
    		System.out.println("Performance Analysis Report");
    		System.out.println("------------------------------------------------------------------------");
    		System.out.println(String.format("|%22s|%15s|%15s|%25s|%15s", "FileName", "Operation",
    				 "Data Structure", "Time Taken (Micro Sec)", "Bytes Used"));
    		System.out.println("------------------------------------------------------------------------");
    		System.out.println(printReport);
    		System.out.println("------------------------------------------------------------------------");
    }
   
    /**
    * Method that compares the speed and memory used by the hash table and tree map 
    * when running the insertion methods of each class
    */
    @Override
    public void compareInsertion() {
        //TODO: Complete this method
    		long treeMapStart = System.nanoTime();
    		long treeMapStartMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    		for (int i = 0; i < inputData.size(); i++)
    		{
    			String input = inputData.get(i);
    			testTree.put(input, test);
    		}
    		long treeMapEndMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    		long treeMapUsedMemory = treeMapStartMemory - treeMapEndMemory;
    		long treeMapTime = System.nanoTime() - treeMapStart;
    		//
    		long hashStart = System.nanoTime();
    		long hashStartMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    		for (int i = 0; i < inputData.size(); i++)
    		{
    			String input = inputData.get(i);
    			testTable.put(input, test);
    		}
    		long hashEndMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    		long hashUsedMemory = hashStartMemory - hashEndMemory;
    		long hashTime = System.nanoTime() - hashStart;
    		
    		insertReport = String.format("|%22s|%15s|%15s|%25s|%15s", fileName, "PUT", "HASHTABLE", hashTime, 
    				hashUsedMemory) + "\n" + String.format("|%22s|%15s|%15s|%25s|%15s", fileName, "PUT", 
    				"TREE MAP", treeMapTime, treeMapUsedMemory);
    }

    @Override
    public void compareDeletion() {
        //TODO: Complete this method
    		long treeMapStart = System.nanoTime();
		long treeMapStartMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		for (int i = 0; i < inputData.size(); i++)
		{
			String input = inputData.get(i);
			testTree.remove(input);
		}
		long treeMapEndMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long treeMapUsedMemory = treeMapStartMemory - treeMapEndMemory;
		long treeMapTime = System.nanoTime() - treeMapStart;
		//
		long hashStart = System.nanoTime();
		long hashStartMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		for (int i = 0; i < inputData.size(); i++)
		{
			String input = inputData.get(i);
			testTable.remove(input);
		}
		long hashEndMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long hashUsedMemory = hashStartMemory - hashEndMemory;
		long hashTime = System.nanoTime() - hashStart;
		
		deleteReport = String.format("|%22s|%15s|%15s|%25s|%15s", fileName, "DELETE", "HASHTABLE", hashTime, 
				hashUsedMemory) + "\n" + String.format("|%22s|%15s|%15s|%25s|%15s", fileName, "DELETE", 
				"TREE MAP", treeMapTime, treeMapUsedMemory);
    }

    @Override
    public void compareSearch() {
        //TODO: Complete this method
    	long treeMapStart = System.nanoTime();
		long treeMapStartMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		for (int i = 0; i < inputData.size(); i++)
		{
			String input = inputData.get(i);
			testTree.get(input);
		}
		long treeMapEndMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long treeMapUsedMemory = treeMapStartMemory - treeMapEndMemory;
		long treeMapTime = System.nanoTime() - treeMapStart;
		//
		long hashStart = System.nanoTime();
		long hashStartMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		for (int i = 0; i < inputData.size(); i++)
		{
			String input = inputData.get(i);
			testTable.get(input);
		}
		long hashEndMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long hashUsedMemory = hashStartMemory - hashEndMemory;
		long hashTime = System.nanoTime() - hashStart;
		
		searchReport = String.format("|%22s|%15s|%15s|%25s|%15s", fileName, "GET", "HASHTABLE", hashTime, 
				hashUsedMemory) + "\n" + String.format("|%22s|%15s|%15s|%25s|%15s", fileName, "GET", 
				"TREE MAP", treeMapTime, treeMapUsedMemory);
    }

    /*
    An implementation of loading files into local data structure is provided to you
    Please feel free to make any changes if required as per your implementation.
    However, this function can be used as is.
     */
    @Override
    public void loadData(String filename) throws IOException {

        // Opens the given test file and stores the objects each line as a string
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        inputData = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            inputData.add(line);
            line = br.readLine();
        }
        br.close();
    }
}
