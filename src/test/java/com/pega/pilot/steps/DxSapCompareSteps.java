package com.pega.pilot.steps;

import com.pega.pilot.comparison.ComparisonService;
import com.pega.pilot.model.FieldComparisonResult;
import com.pega.pilot.model.TestExecutionContext;
import com.pega.pilot.model.TestSignal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class DxSapCompareSteps {

    private static final TestExecutionContext context = new TestExecutionContext();
    private final ComparisonService comparisonService = new ComparisonService();

    @Given("SAP XML Datei {string}")
    public void sapXmlDatei(String path) {
        context.setSapFilePath(path);
        System.out.println("SET SAP PATH = " + context.getSapFilePath());
    }

    @Given("DX JSON Datei {string}")
    public void dxJsonDatei(String path) {
        context.setDxFilePath(path);
        System.out.println("SET DX PATH = " + context.getDxFilePath());
    }

    @Given("Mapping Datei {string}")
    public void mappingDatei(String path) {
        context.setMappingFilePath(path);
        System.out.println("SET MAPPING PATH = " + context.getMappingFilePath());
    }

    @Given("Test-ID {string}")
    public void testId(String testId) {
        context.setTestId(testId);
        System.out.println("SET TEST ID = " + context.getTestId());
    }

    @When("ich die Vertragsfelder vergleiche")
    public void ichDieVertragsfelderVergleiche() throws Exception {
        System.out.println("BEFORE COMPARE SAP PATH = " + context.getSapFilePath());
        System.out.println("BEFORE COMPARE DX PATH = " + context.getDxFilePath());
        System.out.println("BEFORE COMPARE MAPPING PATH = " + context.getMappingFilePath());

        comparisonService.executeComparison(context);
    }

    @Then("sollen alle Felder fachlich korrekt sein")
    public void sollenAlleFelderFachlichKorrektSein() {
        List<FieldComparisonResult> failed = context.getResults()
                .stream()
                .filter(r -> r.getSignal() == TestSignal.FAIL)
                .collect(Collectors.toList());

        if (!failed.isEmpty()) {
            String message = failed.stream()
                    .map(r -> r.getFeldName()
                            + " | Erwartet: " + r.getErwarteterWert()
                            + " | Tatsächlich: " + r.getTatsaechlicherWert()
                            + " | Hinweis: " + r.getHinweis())
                    .collect(Collectors.joining("\n"));

            Assert.fail("Es gibt fachliche Abweichungen:\n" + message);
        }
    }

    @And("ein Testbericht soll erzeugt werden")
    public void einDeutscherTestberichtSollErzeugtWerden() {
        System.out.println("Testbericht wurde ausgegeben.");
    }
}