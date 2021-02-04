package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Launcher {

	public static void main(String[] args) throws Exception {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter();

		// The HashMap that will contain the result data
		Map<String, Integer> resultMap = new HashMap<>();
		// The list from the input text file
		List<String> inputList = analyticsCounter.getListFromFile();

		resultMap = analyticsCounter.symptomDuplicateCounter(inputList, resultMap);

		// print into the console the result of the count
		resultMap.forEach((k, v) -> System.out.println((k + "= " + v)));

		analyticsCounter.writeOutputFile(resultMap);

	}

}
