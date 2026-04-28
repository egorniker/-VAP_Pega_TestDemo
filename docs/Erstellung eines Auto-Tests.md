```md
┌──────────────────────────────────────────────────────────────┐
│                    Erstellung eines Auto-Tests              │
│              (Beispiel: Tarifblock Vertrag prüfen)          │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ 1. Fachliche Analyse                                         │
│                                                              │
│                                                              │
│ Beispiel Tarifblock:                                         │
│ Beitrag / Zahlweise / Tarifname / Beginn                     │  
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ 2. Testdesign / Gherkin                                     │
│ Feature: Tarifblock prüfen                                  │
│ Scenario: Alle Tariffelder korrekt anzeigen                 │
│ Given XML + JSON vorhanden                                  │
│       (Testset CSV Datei)                                   │
│ When Vergleich startet                                      │
│       (ich alle registrierten Vertrags-Testsets vergleiche) │
│ Then Felder sind korrekt                                    │
│       (alle registrierten Vertrags-Testsets sind fachlich   │
│        korrekt)                                             │
└──────────────────────────────────────────────────────────────┘
                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ 3. Technische Umsetzung                                     │
│ - Mapping der Felder                                        │
│ - Java Vergleichslogik                                      │
│   (Rules, Formatprüfung, Bedingungen, Hinweise)             │
│ - Reportintegration                                         │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ 4. Testausführung                                           │
│ Maven                                                        │
│ XML Soll ↔ DX JSON Ist                                      │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ 5. Ergebnis / Reporting                                     │
│ Tarifname ........ PASS                                     │
│ Beitrag ......... FAIL                                      │
│ Zahlweise ....... PASS                                      │
│                                                            │
│ HTML Report + Einzelreport                                  │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ 6. Jira Rückmeldung                                         │
│ - Report anhängen                                           │
│ - Fehlerticket bei Abweichung                               │
│ - Regression später wiederverwendbar                        │
└──────────────────────────────────────────────────────────────┘



══════════════════════════════════════════════════════════════════
                 Erweiterung / Aufwandsschätzung
══════════════════════════════════════════════════════════════════

┌──────────────────────────────────────────────────────────────┐
│ Neuer Vertrag hinzufügen                                    │
│ XML + JSON + Testset ergänzen (aktuell funktioniert manuel) │
│ Aufwand: ca. 1 Std.                                       │
└──────────────────────────────────────────────────────────────┘

┌──────────────────────────────────────────────────────────────┐
│ Neues Standardfeld                                          │
│ z. B. Status / Zahlweise                                   │
│ Aufwand: ca. 1 Std.                                         │
└──────────────────────────────────────────────────────────────┘

┌──────────────────────────────────────────────────────────────┐
│ Neues Feld mit Regeln                                       │
│ z. B. nur sichtbar wenn Wert vorhanden                     │
│ Aufwand: ca. 2–4 Std.                                       │
└──────────────────────────────────────────────────────────────┘

┌──────────────────────────────────────────────────────────────┐
│ Neuer Fachblock                                             │
│ z. B. Tarif / Dokumente / Pflegeleistungen                 │
│ Aufwand: ca. 0,5–1 Tag                                      │
└──────────────────────────────────────────────────────────────┘



══════════════════════════════════════════════════════════════════
                        Management Nutzen
══════════════════════════════════════════════════════════════════

Je mehr Blöcke bereits umgesetzt sind,
desto schneller werden neue Verträge integriert.

Einmalige Strukturierung → hohe Skalierung → stabile Regression

