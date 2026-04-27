package com.pega.pilot.comparison;

import com.pega.pilot.model.FieldComparisonResult;
import com.pega.pilot.model.MappingRule;
import com.pega.pilot.model.TestExecutionContext;
import com.pega.pilot.parser.DxJsonParser;
import com.pega.pilot.parser.SapXmlParser;
import com.pega.pilot.report.TestReportCollector;
import com.pega.pilot.util.FileLoader;
import com.pega.pilot.report.HtmlComparisonReportWriter;

import java.util.ArrayList;
import java.util.List;

public class ComparisonService {

    private final SapXmlParser sapXmlParser = new SapXmlParser();
    private final DxJsonParser dxJsonParser = new DxJsonParser();
    private final ComparisonEngine comparisonEngine = new ComparisonEngine();
    private final TestReportCollector reportCollector = new TestReportCollector();
    private final HtmlComparisonReportWriter htmlReportWriter = new HtmlComparisonReportWriter();

    public void executeComparison(TestExecutionContext context) throws Exception {
        context.setSapData(sapXmlParser.parse(context.getSapFilePath()));
        context.setDxData(dxJsonParser.parse(context.getDxFilePath()));
        context.setMappingRules(FileLoader.loadMappingRules(context.getMappingFilePath()));

        List<FieldComparisonResult> results = new ArrayList<>();

        for (MappingRule rule : context.getMappingRules()) {
            FieldComparisonResult result = comparisonEngine.compareField(rule, context.getSapData(), context.getDxData());
            results.add(result);
        }

        context.setResults(results);
        reportCollector.printGermanReport(results);
        htmlReportWriter.writeReport(results, "target/dx-sap-vergleich-report.html");
    }
}
