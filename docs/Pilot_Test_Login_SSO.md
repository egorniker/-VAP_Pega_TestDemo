
┌──────────────────────────────────────────────────────────────┐
│                     Pilot-Test 1: SSO Login                 │
└──────────────────────────────────────────────────────────────┘

Fachliches Ziel:
Prüfung des zentralen Einstiegspfads eines Benutzers.

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Testfall: Benutzer meldet sich via SSO an                  │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ TestNG-Test startet                                         │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Browser öffnet Login-Seite                                  │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Selenium steuert UI                                         │
│ Klick auf „Login with SSO“                                  │
│ Benutzername eingeben                                       │
│ Passwort eingeben                                           │
│ Login bestätigen                                            │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Prüfung erfolgreicher Einstieg                              │
│ z. B. Startseite sichtbar / Benutzer angemeldet             │
└──────────────────────────────────────────────────────────────┘

                           │
                           ▼

┌──────────────────────────────────────────────────────────────┐
│ Report                                                      │
│ PASS / FAIL / Laufzeit / Screenshots                        │
└──────────────────────────────────────────────────────────────┘


Technischer Charakter:

- UI-basierter End-to-End-Test
- reale Benutzeraktion simuliert
- prüft kritischen Login-Pfad
- höher abhängig von Browser / Oberfläche



