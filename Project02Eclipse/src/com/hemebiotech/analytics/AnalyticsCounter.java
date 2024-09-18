package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {

	private final ISymptomReader symptomReader;
	private final ISymptomWriter symptomWriter;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		symptomReader = reader;
		symptomWriter = writer;
	}

	/**
	 *
	 * Use interface ISymptomReader method to get symptoms
	 * @return List<String>
	 */
	public List<String> getSymptoms() {
		return symptomReader.GetSymptoms();
	}

	/**
	 *
	 * Go through the symptoms list : add it to the map, and/or increase counter
	 * @param symptoms List of symptoms
	 * @return Map<String, Integer>
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String,Integer> newSymptomsMap = new HashMap<>();

        for (String symptom : symptoms) {
            newSymptomsMap.putIfAbsent(symptom, 0);
            int toAdd = newSymptomsMap.get(symptom) + 1;
            newSymptomsMap.replace(symptom, toAdd);
        }
		return newSymptomsMap;
	}

	/**
	 *
	 * Just sort the symptoms list thanks to TreeMap
	 * @param symptoms MapList of symptoms
	 * @return Map<String, Integer>
	 */

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 *
	 * Use interface ISymptomWriter method to write symptoms count file
	 * @param symptoms MapList of symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}

}
