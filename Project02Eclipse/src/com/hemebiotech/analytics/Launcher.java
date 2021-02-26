package com.hemebiotech.analytics;

import java.io.IOException;

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

		try {
			analyticsCounter.setISymptomReader(new ReadSymptomDataFromFile("Project02Eclipse\\symptoms.txt"));
			analyticsCounter.setISymptomWriter(new WriteSymptomToFile("results.out"));
			analyticsCounter.analyseAndCount();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Les fichiers n'ont pas pu être ouverts, lus ou crées");
		}
	}
}
