**Pilot-Test 1: SSO Login**
Fachliches Ziel: Prüfung des zentralen Einstiegspfads eines Benutzers.

Architektur
Testfall: Benutzer meldet sich via SSO an
        ↓
TestNG Test startet
        ↓
Browser öffnet Login-Seite
        ↓
Selenium steuert UI
        ↓
Klick auf "Login with SSO"
        ↓
Benutzername eingeben
        ↓
Passwort eingeben
        ↓
Login bestätigen
        ↓
Prüfung erfolgreicher Einstieg
        ↓
Report

Technischer Charakter
UI-basierter End-to-End-Test
reale Benutzeraktion simuliert


**Pilot-Test 2: DX API / Vertragseinzelansicht**

Fachliches Ziel: Prüfung fachlicher Vertragsdaten ohne vollständige manuelle UI-Klickstrecke.

Architektur

Testfall: Vertragsdaten prüfen
        ↓
TestNG-Test startet
        ↓
Testdaten laden:
- SAP XML
- DX JSON
- Mapping-Datei
        ↓
SAP XML lesen
        ↓
DX JSON lesen
        ↓
Mapping-Regeln / Erwartungslogik anwenden
        ↓
Soll-/Ist-Werte je Feld ermitteln
        ↓
Fachlicher Feldvergleich:
- Vertragsnummer
- Status
- Werte
- Inhalte
        ↓
PASS / FAIL je Feld
        ↓
Gesamtergebnis des Tests
        ↓
HTML-Report erzeugen

Technischer Charakter
datengetriebener Test weniger UI-Abhängigkeit
schnelle Validierung
hohe Stabilität
effizient für Regression

