┌──────────────────────────────────────────────────────────────┐
│                   Fachlicher Testfall                        │
│        (z. B. SSO Login / Vertragsdaten prüfen)              │ 
└──────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────────┐
│              Gherkin / strukturierter Testablauf             │
│   Given / When / Then bzw. fachlich definierte Prüfschritte  │
└──────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────────┐
│                 Step Definitions / Mapping Layer             │
│      Übersetzung von fachlichen Schritten in Java-Logik      │
└──────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────────┐
│                Test Framework Core (Maven + Java + TestNG)   │
│  Teststeuerung, Setup, TearDown, Assertions, Konfiguration   │
└──────────────────────────────────────────────────────────────┘
                     │                           │
                     │                           │
                     ▼                           ▼
┌───────────────────────────────┐   ┌───────────────────────────────┐
│         UI Layer              │   │         Data/API Layer        │
│ Selenium / Pega UI Aktionen   │   │ DX JSON / strukturierte Daten │
│ Klicks, Eingaben, Navigation  │   │ Lesen, Mappen, Vergleichen    │
└───────────────────────────────┘   └───────────────────────────────┘
                     │                           │
                     └───────────────┬───────────┘
                                     │
                                     ▼
┌──────────────────────────────────────────────────────────────┐
│                     Validation Layer                         │
│         Soll-Ist-Vergleich / Feldprüfung / Statuscheck       │
└──────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────────┐
│                     Reporting Layer                          │
│           TestNG Report / HTML Report / PASS-FAIL            │
└──────────────────────────────────────────────────────────────┘