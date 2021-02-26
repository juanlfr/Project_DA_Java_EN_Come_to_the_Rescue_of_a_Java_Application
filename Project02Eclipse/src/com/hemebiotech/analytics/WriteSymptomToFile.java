package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Class to write the output file with the count results
 * 
 * @author juanc
 *
 */
public class WriteSymptomToFile implements ISymptomWriter {

	private String fileOut;

	WriteSymptomToFile(String fileOut) {
		this.fileOut = fileOut;

	}

	/**
	 * Will write an output file with the symptoms count
	 * 
	 * @param map
	 * @throws IOException
	 */

	public void writeOutputFile(Map<String, Integer> map) {

		try (FileWriter writer = new FileWriter(this.fileOut)) {
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Un probleme est survenu lors de la creation du fichier");
		}
	}

}
