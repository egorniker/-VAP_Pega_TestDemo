package com.pega.pilot.report;

import com.pega.pilot.model.FieldComparisonResult;
import com.pega.pilot.model.TestSignal;

import java.util.List;
import java.util.Map;

public class TestReportCollector {

    public void printGermanReport(
            String testId,
            String sapFilePath,
            String dxFilePath,
            List<FieldComparisonResult> results
    ) {
        System.out.println("\n=== TESTBERICHT: Vertragsvergleich ===");
        System.out.println("Testset: " + testId);
        System.out.println("SAP XML: " + sapFilePath);
        System.out.println("DX JSON: " + dxFilePath);
        System.out.println("======================================\n");

        for (FieldComparisonResult result : results) {
            System.out.println("Feld: " + result.getFeldName());
            System.out.println("Signal: " + result.getSignal());
            System.out.println("Feld vorhanden: " + (result.isFeldVorhanden() ? "Ja" : "Nein"));
            System.out.println("Wert korrekt: " + (result.isWertKorrekt() ? "Ja" : "Nein"));
            System.out.println("Erwarteter Wert: " + result.getErwarteterWert());
            System.out.println("Tatsächlicher Wert: " + result.getTatsaechlicherWert());
            System.out.println("Hinweis: " + result.getHinweis());
            System.out.println("Screenshot: " + result.getScreenshotPfad());
            System.out.println("----------------------------------------");
        }
    }

    public void printSummaryReport(Map<String, List<FieldComparisonResult>> resultsByTestSet) {
        System.out.println("\n=== GESAMTBERICHT: DX/SAP Vertragsvergleich ===");

        int totalTestSets = resultsByTestSet.size();
        int failedTestSets = 0;

        for (Map.Entry<String, List<FieldComparisonResult>> entry : resultsByTestSet.entrySet()) {
            String testId = entry.getKey();
            List<FieldComparisonResult> results = entry.getValue();

            long failedFields = results.stream()
                    .filter(r -> r.getSignal() == TestSignal.FAIL)
                    .count();

            if (failedFields > 0) {
                failedTestSets++;
            }

            System.out.println("Testset: " + testId
                    + " | Felder geprüft: " + results.size()
                    + " | Fehler: " + failedFields);
        }

        System.out.println("----------------------------------------");
        System.out.println("Testsets gesamt: " + totalTestSets);
        System.out.println("Testsets mit Fehlern: " + failedTestSets);
        System.out.println("========================================\n");
    }
}