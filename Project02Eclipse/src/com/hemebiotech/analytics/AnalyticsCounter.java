package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static ReadSymptomDataFromFile dataFromFile = new ReadSymptomDataFromFile(
			"C:\\Users\\juanc\\Desktop\\Alternance\\Projets\\Projet2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
	public static List<String> listFromFile = dataFromFile.GetSymptoms();// call the interface method to get all the
																			// list of
	// symptoms
	public static ArrayList<Symptom> finalSymptomList = new ArrayList<Symptom>(Arrays.asList(new Symptom("")));
	static Map<String, Integer> resultMap = new HashMap<>();

	public static void main(String args[]) throws Exception {

		resultMap = addSymptomToList(listFromFile);

		resultMap.forEach((k, v) -> System.out.println((k + ":" + v)));

		/*
		 * first get input BufferedReader reader = new BufferedReader(new
		 * FileReader(symptoms.txt")); String line = reader.readLine();
		 * 
		 * int i = 0; // set i to 0 int headCount = 0; // counts headaches// while (line
		 * != null) { i++; // increment i System.out.println("symptom from file: " +
		 * line); if (line.equals("headache")) { headCount++;
		 * System.out.println("number of headaches: " + headCount); } else if
		 * (line.equals("rush")) { rashCount++; } else if (line.contains("pupils")) {
		 * pupilCount++; }
		 * 
		 * line = reader.readLine(); // get another symptom }
		 */

		/*
		 * // next generate output FileWriter writer = new FileWriter("result.out");
		 * writer.write("headache: " + headacheCount + "\n"); writer.write("rash: " +
		 * rashCount + "\n"); writer.write("dialated pupils: " + pupilCount + "\n");
		 * writer.close();
		 */
	}

	public static Map<String, Integer> addSymptomToList(List<String> inputList) {

		for (String symptomString : inputList) {
			if (resultMap.containsKey(symptomString)) {
				resultMap.put(symptomString, resultMap.get(symptomString) + 1);
			} else {
				resultMap.put(symptomString, 1);
			}
		}
		return resultMap;

		/*
		 * for (String symptomString : list) { for (int i = 0; i < arrayList.size();
		 * i++) { if (symptomString.equals(arrayList.get(i).getSymptomName())) { Symptom
		 * symptom = new Symptom(symptomString); arrayList.add(symptom); i++; }
		 * 
		 * } }
		 */
	}
}
