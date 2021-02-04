package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public AnalyticsCounter() {
	}

	/**
	 * call the interface method to get all the list of symptoms
	 * 
	 * @return a list with symptoms
	 */
	public List<String> getListFromFile() {
		ReadSymptomDataFromFile dataFromFile = new ReadSymptomDataFromFile(
				"C:\\Users\\juanc\\Desktop\\Alternance\\Projets\\Projet2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
		return dataFromFile.GetSymptoms();
	}

	/**
	 * Its the count function
	 * 
	 * @param inputList list of String from the text input file
	 * @param resultMap is the map to fill with each symptom and its count
	 * @return
	 */

	public Map<String, Integer> symptomDuplicateCounter(List<String> inputList, Map<String, Integer> resultMap) {

		for (String symptomString : inputList) {
			if (resultMap.containsKey(symptomString)) {
				resultMap.put(symptomString, resultMap.get(symptomString) + 1);
			} else {
				resultMap.put(symptomString, 1);
			}
		}
		Map<String, Integer> sortedResultMap = sortbykey(resultMap);

		return sortedResultMap;
	}

	public TreeMap<String, Integer> sortbykey(Map<String, Integer> map) {

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

	public void writeOutputFile(Map<String, Integer> map) throws IOException {
		FileWriter writer = new FileWriter("result.out");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			writer.write(" * " + entry.getKey() + " = " + entry.getValue() + "\n");
		}
		writer.close();
	}

}
