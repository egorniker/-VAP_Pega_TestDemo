

┌──────────────────────────────────────────────────────────────┐
│         Pilot-Test 2: DX API / Vertragseinzelansicht        │
└──────────────────────────────────────────────────────────────┘

Fachliches Ziel:
Prüfung fachlicher Vertragsdaten ohne vollständige UI-Klickstrecke.

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Testfall: Vertragsdaten prüfen                              │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ TestNG-Test startet                                         │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Testdaten laden                                             │
│ - SAP XML                                                   │
│ - DX JSON                                                   │
│ - Mapping-Datei                                             │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Datenquellen lesen                                          │
│ SAP XML lesen                                               │
│ DX JSON lesen                                               │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Vergleichslogik anwenden                                    │
│ Mapping-Regeln / Erwartungswerte / Bedingungen              │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Feldvergleich je Vertrag                                    │
│ - Vertragsnummer                                            │
│ - Status                                                    │
│ - Beitrag / Werte                                           │
│ - Inhalte / Anzeigen                                        │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Ergebnis                                                    │
│ PASS / FAIL je Feld                                         │
│ Gesamtstatus des Vertrags                                   │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ HTML Report                                                 │
│ Gesamtbericht + Einzelreport je Vertrag                     │
└──────────────────────────────────────────────────────────────┘


Technischer Charakter:

- datengetriebener Test
- geringe UI-Abhängigkeit
- schnelle Validierung
- hohe Stabilität
- sehr effizient für Regression

