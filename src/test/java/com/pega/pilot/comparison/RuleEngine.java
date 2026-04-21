package com.pega.pilot.comparison;

import com.pega.pilot.util.CurrencyFormatterUtil;

public class RuleEngine {

    public String buildExpectedValue(String rule, String... values) {
        switch (rule) {
            case "contractNumberFromShortName":
                return values[0];

            case "exact":
                return values[0];

            case "concatFullName":
                return (safe(values[0]) + " " + safe(values[1])).trim();

            case "territoryToAgenturDisplay":
                return values[0];

            case "companyDisplayName":
                if ("Württembergische Krankenversicherung AG".equals(safe(values[0]))) {
                    return "Württ. Krankenversicherung AG";
                }
                return values[0];

            case "composeBezeichnung":
                if ("Krankenversicherung".equals(safe(values[0])) &&
                        "Zusatzversicherung".equals(safe(values[1]))) {
                    return "Kranken-Zusatzversicherung";
                }
                return safe(values[0]) + "-" + safe(values[1]);

            case "pegaCurrencyDe":
                return CurrencyFormatterUtil.formatGermanEuro(values[0]);

            case "zahlweiseTranslation":
                switch (safe(values[0])) {
                    case "Mon":
                        return "Monatlich";
                    case "J":
                        return "Jährlich";
                    case "Hj":
                        return "Halbjährlich";
                    case "Vj":
                        return "Vierteljährlich";
                    default:
                        return values[0];
                }

            default:
                return values.length > 0 ? values[0] : "";
        }
    }

    public String normalizeActualValue(String rule, String actualRawValue) {
        switch (rule) {
            case "contractNumberFromShortName":
                if (actualRawValue == null || actualRawValue.isBlank()) {
                    return "";
                }
                return actualRawValue.split(" ")[0];

            case "territoryToAgenturDisplay":
                if ("BT25".equals(actualRawValue)) {
                    return "9999-0021-1";
                }
                return actualRawValue;

            case "pegaCurrencyDe":
                return CurrencyFormatterUtil.formatGermanEuro(actualRawValue);

            default:
                return actualRawValue;
        }
    }

    private String safe(String value) {
        return value == null ? "" : value.trim();
    }
}
