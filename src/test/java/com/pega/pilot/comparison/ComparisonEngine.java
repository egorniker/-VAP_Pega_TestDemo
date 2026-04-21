package com.pega.pilot.comparison;

import com.pega.pilot.model.DxContractData;
import com.pega.pilot.model.FieldComparisonResult;
import com.pega.pilot.model.MappingRule;
import com.pega.pilot.model.SapContractData;
import com.pega.pilot.model.TestSignal;
import com.pega.pilot.parser.UiLabelResolver;
import com.pega.pilot.report.ScreenshotService;

public class ComparisonEngine {

    private final ExpectedValueBuilder expectedValueBuilder = new ExpectedValueBuilder();
    private final RuleEngine ruleEngine = new RuleEngine();
    private final UiLabelResolver uiLabelResolver = new UiLabelResolver();
    private final ScreenshotService screenshotService = new ScreenshotService();

    public FieldComparisonResult compareField(MappingRule rule, SapContractData sapData, DxContractData dxData) {
        boolean fieldPresent = uiLabelResolver.isFieldPresent(rule.getFieldLabel());

        if (!fieldPresent) {
            return new FieldComparisonResult(
                    rule.getFieldLabel(),
                    TestSignal.FAIL,
                    false,
                    false,
                    "",
                    "",
                    "Feld wurde nicht gefunden",
                    screenshotService.capturePlaceholder("Pilotvergleich", rule.getFieldLabel())
            );
        }

        String expected = expectedValueBuilder.buildExpected(rule, sapData);
        String actualRaw = extractActual(rule.getFieldLabel(), dxData);
        String actualNormalized = ruleEngine.normalizeActualValue(rule.getRule(), actualRaw);

        boolean valueCorrect = expected.equals(actualNormalized);

        TestSignal signal;
        if (valueCorrect && rule.isTemporaryMapping()) {
            signal = TestSignal.WARN;
        } else if (valueCorrect) {
            signal = TestSignal.PASS;
        } else {
            signal = TestSignal.FAIL;
        }

        return new FieldComparisonResult(
                rule.getFieldLabel(),
                signal,
                true,
                valueCorrect,
                expected,
                actualNormalized,
                buildHint(rule, valueCorrect),
                valueCorrect ? "-" : screenshotService.capturePlaceholder("Pilotvergleich", rule.getFieldLabel())
        );
    }

    private String extractActual(String fieldLabel, DxContractData dxData) {
        switch (fieldLabel) {
            case "Vertragsnummer":
                return dxData.getShortName();
            case "Status":
                return dxData.getStatus();
            case "Vertragsnehmer":
                return dxData.getVertragsnehmerLabel();
            case "Vermittlernummer":
                return dxData.getTerritoryId();
            case "Unternehmen":
                return dxData.getUnternehmen();
            case "Bezeichnung":
                return dxData.getBezeichnung();
            case "Beitrag":
                return dxData.getBeitrag();
            case "Zahlweise":
                return dxData.getZahlweise();
            default:
                return "";
        }
    }

    private String buildHint(MappingRule rule, boolean valueCorrect) {
        if (!valueCorrect) {
            return "Wert stimmt nicht überein";
        }

        if (rule.isTemporaryMapping()) {
            return "Temporäres Mapping für Pilot";
        }

        switch (rule.getRule()) {
            case "contractNumberFromShortName":
                return "Vertragsnummer aus ShortName extrahiert";
            case "concatFullName":
                return "Vorname und Nachname wurden zusammengesetzt";
            case "companyDisplayName":
                return "Unternehmensname wurde in Display-Form verglichen";
            case "composeBezeichnung":
                return "Bezeichnung wurde fachlich zusammengesetzt";
            case "pegaCurrencyDe":
                return "Pega-Währungsformat angewendet";
            case "zahlweiseTranslation":
                return "Zahlweise wurde fachlich übersetzt";
            default:
                return "Direktvergleich";
        }
    }
}
