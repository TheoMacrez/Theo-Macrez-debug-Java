package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[])
    {

        ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");

        ISymptomWriter symptomWriter = new WriteSymptomDataToFile();

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader,symptomWriter);

        List<String> allSymptoms = analyticsCounter.getSymptoms();

        Map<String,Integer> countedSymptoms =  analyticsCounter.countSymptoms(allSymptoms);

        Map<String,Integer> sortedCounterSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);

        analyticsCounter.writeSymptoms(sortedCounterSymptoms);


    }

}
