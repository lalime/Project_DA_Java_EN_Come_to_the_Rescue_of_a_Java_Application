package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private List<String> symptoms;
	private String outputFileName = "result.out";
	private HashMap<String, Integer> symptomsCountMap = new HashMap<String, Integer>();
	
	public AnalyticsCounter(List<String> symptoms) {
		this.symptoms = symptoms;
		
		this.transformToMap();
	}

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public void transformToMap() {
		
		for (String symptom : symptoms) {
			if(symptomsCountMap.containsKey(symptom)) {
				symptomsCountMap.put(symptom, symptomsCountMap.get(symptom) + 1);
			} else {
				symptomsCountMap.put(symptom, 1);
			}
        }
	}
	
	/**
	 * @throws IOException
	 */
	public void exportResults() {
		try {

			FileWriter writer = new FileWriter (outputFileName);
			
			Iterator<Map.Entry<String, Integer>> entrySet = symptomsCountMap.entrySet().iterator();
	        
	        while (entrySet.hasNext())
	        {
	            Map.Entry<String, Integer> entry = entrySet.next();

				writer.write(entry.getKey() + " " + entry.getValue() + "\n");
	            System.out.println("Key : "+ entry.getKey() +"   Value : "+entry.getValue());
	        }

			writer.close();
			
		} catch (Exception e) {
		      System.out.println("Exception: "+ e.getMessage());
		}
	}
}
