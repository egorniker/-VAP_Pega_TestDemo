package com.pega.pilot.comparison;

import com.pega.pilot.model.MappingRule;
import com.pega.pilot.model.SapContractData;

public class ExpectedValueBuilder {

    private final RuleEngine ruleEngine = new RuleEngine();

    public String buildExpected(MappingRule rule, SapContractData sapData) {
        switch (rule.getFieldLabel()) {
            case "Vertragsnummer":
                return ruleEngine.buildExpectedValue(rule.getRule(), sapData.getVertragsnummer());

            case "Status":
                return ruleEngine.buildExpectedValue(rule.getRule(), sapData.getStatus());

            case "Vertragsnehmer":
                return ruleEngine.buildExpectedValue(rule.getRule(), sapData.getVorname(), sapData.getNachname());

            case "Vermittlernummer":
                return ruleEngine.buildExpectedValue(rule.getRule(), sapData.getVermittlernummer());

            case "Unternehmen":
                return ruleEngine.buildExpectedValue(rule.getRule(), sapData.getUnternehmen());

            case "Bezeichnung":
                return ruleEngine.buildExpectedValue(rule.getRule(),
                        sapData.getProduktbezeichnung(),
                        sapData.getVertragsbezeichnung());

            case "Beitrag":
                return ruleEngine.buildExpectedValue(rule.getRule(), sapData.getBeitrag());

            case "Zahlweise":
                return ruleEngine.buildExpectedValue(rule.getRule(), sapData.getZahlweise());

            default:
                return "";
        }
    }
}
