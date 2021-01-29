package com.hemebiotech.analytics;

public class Symptom {
	private String symptomName;
	private int count;

	public Symptom() {
	}

	public Symptom(String symptomName) {
		this.symptomName = symptomName;
		this.count = 0;
	}

	public String getSymptomName() {
		return symptomName;
	}

	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
