package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public class Launcher {

	public static void main(String[] args) {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter();

		Map<String, Integer> resultMap;
		try {
			resultMap = analyticsCounter.analyseAndCount(
					"C:\\Users\\juanc\\Desktop\\Alternance\\Projets\\Projet2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
			// print into the console the result of the count
			resultMap.forEach((k, v) -> System.out.println((k + "= " + v)));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Les fichiers n'ont pas pu être ouverts, lus ou crées");
		}
	}
}
