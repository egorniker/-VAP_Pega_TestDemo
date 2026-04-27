package com.pega.pilot.util;

import com.pega.pilot.model.ContractTestSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ContractTestSetCsvLoader {

    public List<ContractTestSet> load(String csvPath) throws Exception {
        List<ContractTestSet> testSets = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvPath))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] columns = line.split(";", -1);

                if (columns.length < 4) {
                    throw new IllegalArgumentException("Ungültige CSV-Zeile: " + line);
                }

                String testId = columns[0].trim();
                String sapXml = columns[1].trim();
                String dxJson = columns[2].trim();
                String mapping = columns[3].trim();

                testSets.add(new ContractTestSet(testId, sapXml, dxJson, mapping));
            }
        }

        return testSets;
    }
}