package com.pega.pilot.report;

import com.pega.pilot.model.FieldComparisonResult;

import java.util.List;

public class TestReportCollector {

    public void printGermanReport(List<FieldComparisonResult> results) {
        System.out.println("\n=== TESTBERICHT: Vertragsvergleich ===\n");

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
}
