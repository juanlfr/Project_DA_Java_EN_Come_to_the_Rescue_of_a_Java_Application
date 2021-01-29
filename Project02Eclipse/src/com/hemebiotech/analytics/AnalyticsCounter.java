package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static ReadSymptomDataFromFile dataFromFile = new ReadSymptomDataFromFile(
			"C:\\Users\\juanc\\Desktop\\Alternance\\Projets\\Projet2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");

	// call the interface method to get all the list of symptoms
	public static List<String> listFromFile = dataFromFile.GetSymptoms();
	// Initialisation of a list of Symptoms objects
	public static ArrayList<Symptom> finalSymptomList = new ArrayList<Symptom>();
	// The HashMap that will contain the result data
	static Map<String, Integer> resultMap = new HashMap<>();

	public static void main(String args[]) throws Exception {

		resultMap = symptomDuplicateCounter(listFromFile);

		resultMap.forEach((k, v) -> System.out.println((k + ":" + v)));

		addToSymptomsList();

		writeOutputFile();

	}

	private static void addToSymptomsList() {
		resultMap.forEach((k, v) -> {
			Symptom symptom = new Symptom(k);
			symptom.setCount(v);
			finalSymptomList.add(symptom);
		});
	}

	private static void writeOutputFile() throws IOException {
		FileWriter writer = new FileWriter("result.out");
		for (Symptom symptom : finalSymptomList) {
			writer.write(
					"-The " + symptom.getSymptomName() + " symptom has " + symptom.getCount() + " occurencies" + "\n");
		}
		writer.close();
	}

	public static Map<String, Integer> symptomDuplicateCounter(List<String> inputList) {

		for (String symptomString : inputList) {
			if (resultMap.containsKey(symptomString)) {
				resultMap.put(symptomString, resultMap.get(symptomString) + 1);
			} else {
				resultMap.put(symptomString, 1);
			}
		}
		return resultMap;

	}
}
