package com.pega.pilot.report;

import com.pega.pilot.model.FieldComparisonResult;
import com.pega.pilot.model.TestSignal;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HtmlDxSapReportGenerator {

    private static final String REPORT_DIR = "target/dx-sap-reports";
    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    public void generateAllReports(
            Map<String, List<FieldComparisonResult>> resultsByTestSet,
            Map<String, String> dxFileByTestSet
    ) throws Exception {

        String timestamp = LocalDateTime.now().format(TS);
        createReportDir();

        Map<String, String> singleReportLinks = new LinkedHashMap<>();

        for (Map.Entry<String, List<FieldComparisonResult>> entry : resultsByTestSet.entrySet()) {
            String testId = entry.getKey();
            String dxFilePath = dxFileByTestSet.get(testId);

            String singleReportFileName =
                    generateSingleReport(testId, dxFilePath, entry.getValue(), timestamp);

            singleReportLinks.put(testId, singleReportFileName);
        }

        generateOverviewReport(
                resultsByTestSet,
                dxFileByTestSet,
                singleReportLinks,
                timestamp
        );
    }

    private void generateOverviewReport(
            Map<String, List<FieldComparisonResult>> resultsByTestSet,
            Map<String, String> dxFileByTestSet,
            Map<String, String> singleReportLinks,
            String timestamp
    ) throws Exception {

        String filePath = REPORT_DIR + "/Gesamtbericht_DX_SAP_" + timestamp + ".html";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(htmlHeader("Gesamtbericht DX/SAP Vertragsvergleich"));

            writer.write("<h1>Gesamtbericht DX/SAP Vertragsvergleich</h1>");
            writer.write("<p><b>Erstellt:</b> " + esc(timestamp) + "</p>");

            writer.write("<table>");
            writer.write("<tr>");
            writer.write("<th>Testausführung</th>");
            writer.write("<th>DX JSON</th>");
            writer.write("<th>Geprüfte Felder</th>");
            writer.write("<th>Fehler</th>");
            writer.write("<th>Status</th>");
            writer.write("</tr>");

            for (Map.Entry<String, List<FieldComparisonResult>> entry : resultsByTestSet.entrySet()) {
                String testId = entry.getKey();
                List<FieldComparisonResult> results = entry.getValue();

                String dxFilePath = dxFileByTestSet.get(testId);
                String executionId = buildExecutionId(dxFilePath, timestamp);
                String singleReportFileName = singleReportLinks.get(testId);

                long failed = results.stream()
                        .filter(r -> r.getSignal() == TestSignal.FAIL)
                        .count();

                String status = failed == 0 ? "PASS" : "FAIL";
                String css = failed == 0 ? "pass" : "fail";

                writer.write("<tr>");

                writer.write("<td><a href='" + esc(singleReportFileName)
                        + "' target='_blank'>"
                        + esc(executionId)
                        + "</a></td>");

                writer.write("<td>" + esc(dxFilePath) + "</td>");
                writer.write("<td>" + results.size() + "</td>");
                writer.write("<td>" + failed + "</td>");
                writer.write("<td class='" + css + "'>" + status + "</td>");

                writer.write("</tr>");
            }

            writer.write("</table>");
            writer.write(htmlFooter());
        }

        System.out.println("HTML Gesamtbericht erzeugt: " + filePath);
    }

    private String generateSingleReport(
            String testId,
            String dxFilePath,
            List<FieldComparisonResult> results,
            String timestamp
    ) throws Exception {

        String executionId = buildExecutionId(dxFilePath, timestamp);

        String safeExecutionId =
                executionId.replaceAll("[^a-zA-Z0-9_-]", "_");

        String fileName = safeExecutionId + ".html";
        String filePath = REPORT_DIR + "/" + fileName;

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(htmlHeader("Einzelbericht " + executionId));

            writer.write("<h1>Einzelbericht DX/SAP Vertragsvergleich</h1>");
            writer.write("<p><b>Testausführung:</b> " + esc(executionId) + "</p>");
            writer.write("<p><b>Testset:</b> " + esc(testId) + "</p>");
            writer.write("<p><b>DX JSON:</b> " + esc(dxFilePath) + "</p>");
            writer.write("<p><b>Erstellt:</b> " + esc(timestamp) + "</p>");

            writer.write("<table>");
            writer.write("<tr>");
            writer.write("<th>Feld</th>");
            writer.write("<th>Status</th>");
            writer.write("<th>Erwarteter Wert</th>");
            writer.write("<th>Tatsächlicher Wert</th>");
            writer.write("<th>Hinweis</th>");
            writer.write("</tr>");

            for (FieldComparisonResult result : results) {
                boolean passed = result.getSignal() == TestSignal.PASS;
                String css = passed ? "pass" : "fail";

                writer.write("<tr>");
                writer.write("<td>" + esc(result.getFeldName()) + "</td>");
                writer.write("<td class='" + css + "'>" + esc(String.valueOf(result.getSignal())) + "</td>");
                writer.write("<td>" + esc(result.getErwarteterWert()) + "</td>");
                writer.write("<td>" + esc(result.getTatsaechlicherWert()) + "</td>");
                writer.write("<td>" + esc(result.getHinweis()) + "</td>");
                writer.write("</tr>");
            }

            writer.write("</table>");
            writer.write(htmlFooter());
        }

        System.out.println("HTML Einzelbericht erzeugt: " + filePath);

        return fileName;
    }

    private String buildExecutionId(String dxFilePath, String timestamp) {
        String dxName = extractFileNameWithoutExtension(dxFilePath);

        if (dxName.startsWith("DX_")) {
            dxName = dxName.substring(3);
        }

        return dxName + "_" + timestamp;
    }

    private void createReportDir() {
        new File(REPORT_DIR).mkdirs();
    }

    private String extractFileNameWithoutExtension(String path) {
        if (path == null || path.trim().isEmpty()) {
            return "unknown_dx";
        }

        String normalized = path.replace("\\", "/");
        String fileName = normalized.substring(normalized.lastIndexOf("/") + 1);

        int dot = fileName.lastIndexOf(".");
        return dot > 0 ? fileName.substring(0, dot) : fileName;
    }

    private String htmlHeader(String title) {
        return "<!DOCTYPE html><html><head><meta charset='UTF-8'>"
                + "<title>" + esc(title) + "</title>"
                + "<style>"
                + "body{font-family:Arial,sans-serif;margin:32px;background:#f6f8fb;color:#1f2937;}"
                + "h1{color:#0f172a;}"
                + "table{border-collapse:collapse;width:100%;background:white;box-shadow:0 2px 8px rgba(0,0,0,.08);}"
                + "th{background:#1e3a8a;color:white;text-align:left;padding:10px;}"
                + "td{border:1px solid #e5e7eb;padding:9px;vertical-align:top;}"
                + "tr:nth-child(even){background:#f9fafb;}"
                + "a{color:#1d4ed8;font-weight:bold;text-decoration:none;}"
                + "a:hover{text-decoration:underline;}"
                + ".pass{color:#166534;font-weight:bold;background:#dcfce7;}"
                + ".fail{color:#991b1b;font-weight:bold;background:#fee2e2;}"
                + "</style></head><body>";
    }

    private String htmlFooter() {
        return "</body></html>";
    }

    private String esc(String value) {
        if (value == null) {
            return "";
        }

        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}