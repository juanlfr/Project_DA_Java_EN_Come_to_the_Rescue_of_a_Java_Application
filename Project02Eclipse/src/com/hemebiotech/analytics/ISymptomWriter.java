package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write the symptoms data to an output file
 * 
 * @author juanc
 *
 */

public interface ISymptomWriter {

	/**
	 * 
	 * @param map Its an alphabetical ordered map with the count results
	 */

	void writeOutputFile(Map<String, Integer> map);

}
