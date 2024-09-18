package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private Map<String,Integer> symptomsToWrite= new HashMap<>();


    public WriteSymptomDataToFile (Map<String,Integer> symptomsToWrite) {
        this.symptomsToWrite = symptomsToWrite;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("All symptoms and occurences\n");
        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            builder.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.out.txt"));
            writer.write(builder.toString());
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Impossible d'écrire dans le fichier");
        }

    }
}
