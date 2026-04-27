package com.pega.pilot.steps;

import com.pega.pilot.comparison.ComparisonService;
import com.pega.pilot.model.ContractTestSet;
import com.pega.pilot.model.FieldComparisonResult;
import com.pega.pilot.model.TestExecutionContext;
import com.pega.pilot.model.TestSignal;
import com.pega.pilot.report.TestReportCollector;
import com.pega.pilot.util.ContractTestSetCsvLoader;
import com.pega.pilot.report.HtmlDxSapReportGenerator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ScenarioScoped
public class DxSapCompareSteps {

    private final TestExecutionContext context = new TestExecutionContext();
    private final ComparisonService comparisonService = new ComparisonService();
    private final ContractTestSetCsvLoader csvLoader = new ContractTestSetCsvLoader();
    private final TestReportCollector reportCollector = new TestReportCollector();
    private final HtmlDxSapReportGenerator htmlReportGenerator = new HtmlDxSapReportGenerator();

    @Given("Testset CSV Datei {string}")
    public void testsetCsvDatei(String path) {
        context.setTestSetCsvPath(path);
        System.out.println("SET TESTSET CSV PATH = " + context.getTestSetCsvPath());
    }

    @When("ich alle registrierten Vertrags-Testsets vergleiche")
    public void ichAlleRegistriertenVertragsTestsetsVergleiche() throws Exception {
        System.out.println("BEFORE LOAD CSV PATH = " + context.getTestSetCsvPath());

        if (context.getTestSetCsvPath() == null || context.getTestSetCsvPath().isBlank()) {
            throw new IllegalStateException("TestSet CSV Pfad wurde nicht gesetzt. Given-Schritt wurde wahrscheinlich nicht ausgeführt.");
        }

        List<ContractTestSet> testSets = csvLoader.load(context.getTestSetCsvPath());

        Map<String, List<FieldComparisonResult>> resultsByTestSet = new LinkedHashMap<>();
        Map<String, String> dxFileByTestSet = new LinkedHashMap<>();

        for (ContractTestSet testSet : testSets) {
            System.out.println("\nSTARTE TESTSET: " + testSet.getTestId());

            List<FieldComparisonResult> results =
                    comparisonService.executeComparisonForTestSet(context, testSet);

            resultsByTestSet.put(testSet.getTestId(), results);
            dxFileByTestSet.put(testSet.getTestId(), testSet.getDxJsonPath());
        }

    context.setResultsByTestSet(resultsByTestSet);
    context.setDxFileByTestSet(dxFileByTestSet);
}

    @Then("sollen alle registrierten Vertrags-Testsets fachlich korrekt sein")
    public void sollenAlleRegistriertenVertragsTestsetsFachlichKorrektSein() throws Exception {

        reportCollector.printSummaryReport(context.getResultsByTestSet());

        htmlReportGenerator.generateAllReports(
                context.getResultsByTestSet(),
                context.getDxFileByTestSet()
        );

        List<String> failedMessages = context.getResultsByTestSet()
                .entrySet()
                .stream()
                .flatMap(entry -> entry.getValue()
                        .stream()
                        .filter(r -> r.getSignal() == TestSignal.FAIL)
                        .map(r -> entry.getKey()
                                + " | Feld: " + r.getFeldName()
                                + " | Erwartet: " + r.getErwarteterWert()
                                + " | Tatsächlich: " + r.getTatsaechlicherWert()
                                + " | Hinweis: " + r.getHinweis()))
                .collect(Collectors.toList());

        if (!failedMessages.isEmpty()) {
            Assert.fail("Es gibt fachliche Abweichungen:\n"
                    + String.join("\n", failedMessages));
        }
    }

}