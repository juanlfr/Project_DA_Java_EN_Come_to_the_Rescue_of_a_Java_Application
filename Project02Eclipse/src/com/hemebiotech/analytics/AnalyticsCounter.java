package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

public class AnalyticsCounter {

	public ReadSymptomDataFromFile dataFromFile = new ReadSymptomDataFromFile(
			"C:\\Users\\juanc\\Desktop\\Alternance\\Projets\\Projet2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
	public List<String> listFromFile = dataFromFile.GetSymptoms();// call the interface method to get all the list of
																	// symptoms
	public ArrayList<String> finalSymptomList = new ArrayList<String>();

	public static void main(String args[]) throws Exception {

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

}
