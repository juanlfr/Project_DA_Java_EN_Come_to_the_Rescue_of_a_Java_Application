package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
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

	/**
	 * Will execute all the methods to analyze data
	 * 
	 * @param pathToFile
	 * @return an alphabetical sorted map
	 * @throws IOException
	 */
	public Map<String, Integer> analyseAndCount(String pathToFile) throws IOException {
		// The list from the input text file
		List<String> lisFromFile = getListFromFile(pathToFile);
		// The HashMap that will contain the result data
		Map<String, Integer> resultMap = new HashMap<>();
		Map<String, Integer> sortedMap = symptomDuplicateCounter(lisFromFile, resultMap);
		writeOutputFile(sortedMap);
		return sortedMap;
	}

	/**
	 * Call the interface method to get all the list of symptoms
	 * 
	 * @return a list with symptoms
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private List<String> getListFromFile(String path) throws FileNotFoundException, IOException {
		ISymptomReader symptomeReader = new ReadSymptomDataFromFile(path);
		return symptomeReader.getSymptoms();
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

	/**
	 * Will write an output file with the symptoms count
	 * 
	 * @param map
	 * @throws IOException
	 */

	private void writeOutputFile(Map<String, Integer> map) {

		try (FileWriter writer = new FileWriter("result.out")) {
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Un probleme est survenu lors de la creation du fichier");
		}
	}

}
