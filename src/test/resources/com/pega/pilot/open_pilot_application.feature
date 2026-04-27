Feature: Pega Pilot-Anwendung öffnen

  @pilot
  Scenario: Erfolgreicher Login in die Pega-Anwendung via SSO
    Given die Pega-Anwendung ist geöffnet
    When der Benutzer meldet sich via SSO an
    Then der Benutzer ist erfolgreich in Pega angemeldet