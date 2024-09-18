package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {


	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		symptomReader = reader;
		symptomWriter = writer;
	}

	public List<String> getSymptoms() {
		return symptomReader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String,Integer> newSymptomsMap = new HashMap<>();
		for(int i =0; i <symptoms.size();i++)
		{
			newSymptomsMap.putIfAbsent(symptoms.get(i),0);
			int toAdd = newSymptomsMap.get(symptoms.get(i))+1;
			newSymptomsMap.replace(symptoms.get(i),toAdd);

		}
		return newSymptomsMap;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}

}
