package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * This class will call only the main method with an instance of the
 * AnalyticsCounter class.
 * 
 * @author juanc
 *
 */
public class Launcher {

	public static void main(String[] args) {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		Map<String, Integer> resultMap;
		try {
			resultMap = analyticsCounter.analyseAndCount("Project02Eclipse\\symptoms.txt");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Les fichiers n'ont pas pu être ouverts, lus ou crées");
		}
	}
}
