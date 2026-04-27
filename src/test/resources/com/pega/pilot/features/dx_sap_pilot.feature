Feature: Vergleich von SAP XML und DX JSON fuer Vertragsdaten

  Scenario: Pilotvergleich der Vertragssektion
    Given Test-ID "Pilotvergleich_Vertragssektion" 
    And SAP XML Datei "src/test/resources/com/pega/pilot/testdata/dx_sap_pilot/sap/SAP_ER.xml"
    And DX JSON Datei "src/test/resources/com/pega/pilot/testdata/dx_sap_pilot/dx/DX_TE.json"
    And Mapping Datei "src/test/resources/com/pega/pilot/testdata/dx_sap_pilot/mapping/contract_mapping_pilot.json"
    When ich die Vertragsfelder vergleiche
    Then sollen alle Felder fachlich korrekt sein
    And ein Testbericht soll erzeugt werden
