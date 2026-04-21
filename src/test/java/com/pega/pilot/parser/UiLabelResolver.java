package com.pega.pilot.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UiLabelResolver {

    private static final Set<String> AVAILABLE_LABELS = new HashSet<>(Arrays.asList(
            "Vertragsnummer",
            "Status",
            "Vertragsnehmer",
            "Vermittlernummer",
            "Unternehmen",
            "Bezeichnung",
            "Beitrag",
            "Zahlweise"
    ));

    public boolean isFieldPresent(String fieldLabel) {
        return AVAILABLE_LABELS.contains(fieldLabel);
    }
}
