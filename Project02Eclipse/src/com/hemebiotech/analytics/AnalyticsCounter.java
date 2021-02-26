package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class has all the methods to count, sort and print the results of a
 * symptom text file.
 * 
 * @author juanc
 *
 */
public class AnalyticsCounter {

	private ISymptomReader iSymptomReader;

	private ISymptomWriter iSymptomWriter;

	/**
	 * Will execute all the methods to analyze data
	 * 
	 * @param pathToFile
	 * @return an alphabetical sorted map
	 * @throws IOException
	 */
	public void analyseAndCount() throws IOException {
		// The list from the input text file
		List<String> lisFromFile = this.iSymptomReader.getSymptoms();
		// The HashMap that will contain the result data
		Map<String, Integer> resultMap = new HashMap<>();
		Map<String, Integer> sortedMap = symptomDuplicateCounter(lisFromFile, resultMap);
		this.iSymptomWriter.writeOutputFile(sortedMap);
	}

	/**
	 * Its the count function
	 * 
	 * @param inputList list of String from the text input file
	 * @param resultMap is the map to fill with each symptom and its count
	 * @return
	 */

	private Map<String, Integer> symptomDuplicateCounter(List<String> inputList, Map<String, Integer> resultMap) {

		for (String symptomString : inputList) {
			if (resultMap.containsKey(symptomString)) {
				resultMap.put(symptomString, resultMap.get(symptomString) + 1);
			} else {
				resultMap.put(symptomString, 1);
			}
		}
		Map<String, Integer> sortedResultMap = sortByKey(resultMap);
		return sortedResultMap;
	}

	/**
	 * Function to sort in alphabetical order
	 * 
	 * @param map
	 * @return
	 */
	private TreeMap<String, Integer> sortByKey(Map<String, Integer> map) {
		// TreeMap to store values of HashMap
		TreeMap<String, Integer> sortedMap = new TreeMap<>();
		// Copy all data from hashMap into TreeMap
		sortedMap.putAll(map);
		return sortedMap;
	}

	public void setISymptomReader(ISymptomReader iSymptomReader) {
		this.iSymptomReader = iSymptomReader;
	}

	public void setISymptomWriter(ISymptomWriter iSymptomWriter) {
		this.iSymptomWriter = iSymptomWriter;
	}

}
