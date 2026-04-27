Feature: Vergleich von SAP XML und DX JSON fuer Vertragsdaten

  Scenario: Vertragsdaten fuer alle registrierten Testsets vergleichen
    Given Testset CSV Datei "src/test/resources/com/pega/pilot/testdata/dx_sap_pilot/testsets/contract_testsets.csv"
    When ich alle registrierten Vertrags-Testsets vergleiche
    Then sollen alle registrierten Vertrags-Testsets fachlich korrekt sein
    And ein Gesamttestbericht soll erzeugt werden