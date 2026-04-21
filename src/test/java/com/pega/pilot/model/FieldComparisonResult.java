package com.pega.pilot.model;

public class FieldComparisonResult {
    private final String feldName;
    private final TestSignal signal;
    private final boolean feldVorhanden;
    private final boolean wertKorrekt;
    private final String erwarteterWert;
    private final String tatsaechlicherWert;
    private final String hinweis;
    private final String screenshotPfad;

    public FieldComparisonResult(String feldName,
                                 TestSignal signal,
                                 boolean feldVorhanden,
                                 boolean wertKorrekt,
                                 String erwarteterWert,
                                 String tatsaechlicherWert,
                                 String hinweis,
                                 String screenshotPfad) {
        this.feldName = feldName;
        this.signal = signal;
        this.feldVorhanden = feldVorhanden;
        this.wertKorrekt = wertKorrekt;
        this.erwarteterWert = erwarteterWert;
        this.tatsaechlicherWert = tatsaechlicherWert;
        this.hinweis = hinweis;
        this.screenshotPfad = screenshotPfad;
    }

    public String getFeldName() {
        return feldName;
    }

    public TestSignal getSignal() {
        return signal;
    }

    public boolean isFeldVorhanden() {
        return feldVorhanden;
    }

    public boolean isWertKorrekt() {
        return wertKorrekt;
    }

    public String getErwarteterWert() {
        return erwarteterWert;
    }

    public String getTatsaechlicherWert() {
        return tatsaechlicherWert;
    }

    public String getHinweis() {
        return hinweis;
    }

    public String getScreenshotPfad() {
        return screenshotPfad;
    }
}
