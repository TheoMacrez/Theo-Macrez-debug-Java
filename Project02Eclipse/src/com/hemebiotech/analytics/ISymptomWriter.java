package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * Write symptoms on file
     * @param symptoms MapList of symptoms
     */
    public void writeSymptoms(Map<String, Integer> symptoms);
}
