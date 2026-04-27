package com.pega.pilot.report;

import com.pega.pilot.model.FieldComparisonResult;
import com.pega.pilot.model.TestSignal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlComparisonReportWriter {

    public void writeReport(List<FieldComparisonResult> results, String outputPath) throws IOException {
        File outputFile = new File(outputPath);
        outputFile.getParentFile().mkdirs();

        int passCount = 0;
        int failCount = 0;
        int warnCount = 0;

        for (FieldComparisonResult result : results) {
            if (result.getSignal() == TestSignal.PASS) passCount++;
            if (result.getSignal() == TestSignal.FAIL) failCount++;
            if (result.getSignal() == TestSignal.WARN) warnCount++;
        }

        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>");
        html.append("<html lang='de'>");
        html.append("<head>");
        html.append("<meta charset='UTF-8'>");
        html.append("<title>DX SAP Vergleichsreport</title>");
        html.append("<style>");
        html.append("body{font-family:Arial,sans-serif;background:#f4f6f8;margin:0;padding:30px;color:#222;}");
        html.append(".container{max-width:1200px;margin:auto;background:white;padding:30px;border-radius:12px;box-shadow:0 4px 20px rgba(0,0,0,0.08);}");
        html.append("h1{margin-top:0;color:#1f2937;}");
        html.append(".summary{display:flex;gap:16px;margin:25px 0;}");
        html.append(".card{flex:1;padding:18px;border-radius:10px;color:white;font-size:18px;font-weight:bold;}");
        html.append(".pass{background:#16a34a;}");
        html.append(".fail{background:#dc2626;}");
        html.append(".warn{background:#f59e0b;}");
        html.append("table{width:100%;border-collapse:collapse;margin-top:20px;font-size:14px;}");
        html.append("th{background:#1f2937;color:white;text-align:left;padding:12px;}");
        html.append("td{padding:12px;border-bottom:1px solid #e5e7eb;vertical-align:top;}");
        html.append("tr:nth-child(even){background:#f9fafb;}");
        html.append(".badge{padding:5px 10px;border-radius:20px;color:white;font-weight:bold;font-size:12px;}");
        html.append(".badge-pass{background:#16a34a;}");
        html.append(".badge-fail{background:#dc2626;}");
        html.append(".badge-warn{background:#f59e0b;}");
        html.append(".value{font-family:Consolas,monospace;background:#f3f4f6;padding:4px 6px;border-radius:5px;display:inline-block;}");
        html.append("</style>");
        html.append("</head>");
        html.append("<body>");
        html.append("<div class='container'>");

        html.append("<h1>DX SAP Vergleichsreport</h1>");
        html.append("<p>Fachlicher Vergleich zwischen SAP XML und DX JSON.</p>");

        html.append("<div class='summary'>");
        html.append("<div class='card pass'>PASS: ").append(passCount).append("</div>");
        html.append("<div class='card fail'>FAIL: ").append(failCount).append("</div>");
        html.append("<div class='card warn'>WARN: ").append(warnCount).append("</div>");
        html.append("</div>");

        html.append("<table>");
        html.append("<tr>");
        html.append("<th>Feld</th>");
        html.append("<th>Signal</th>");
        html.append("<th>Feld vorhanden</th>");
        html.append("<th>Wert korrekt</th>");
        html.append("<th>Erwarteter Wert</th>");
        html.append("<th>Tatsächlicher Wert</th>");
        html.append("<th>Hinweis</th>");
        html.append("<th>Screenshot</th>");
        html.append("</tr>");

        for (FieldComparisonResult result : results) {
            String badgeClass = getBadgeClass(result.getSignal());

            html.append("<tr>");
            html.append("<td>").append(escape(result.getFeldName())).append("</td>");
            html.append("<td><span class='badge ").append(badgeClass).append("'>")
                    .append(result.getSignal()).append("</span></td>");
            html.append("<td>").append(result.isFeldVorhanden() ? "Ja" : "Nein").append("</td>");
            html.append("<td>").append(result.isWertKorrekt() ? "Ja" : "Nein").append("</td>");
            html.append("<td><span class='value'>").append(escape(result.getErwarteterWert())).append("</span></td>");
            html.append("<td><span class='value'>").append(escape(result.getTatsaechlicherWert())).append("</span></td>");
            html.append("<td>").append(escape(result.getHinweis())).append("</td>");
            html.append("<td>").append(escape(result.getScreenshotPfad())).append("</td>");
            html.append("</tr>");
        }

        html.append("</table>");
        html.append("</div>");
        html.append("</body>");
        html.append("</html>");

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(html.toString());
        }

        System.out.println("HTML Vergleichsreport erzeugt: " + outputFile.getAbsolutePath());
    }

    private String getBadgeClass(TestSignal signal) {
        switch (signal) {
            case PASS:
                return "badge-pass";
            case FAIL:
                return "badge-fail";
            case WARN:
                return "badge-warn";
            default:
                return "";
        }
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }

        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
