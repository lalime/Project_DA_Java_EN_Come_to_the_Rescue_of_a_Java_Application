package com.hemebiotech.analytics;

import java.util.List;

public class Analytics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = readSymptomDataFromFile.GetSymptoms();
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptoms);
		analyticsCounter.exportResults();
	}

}
