package com.pega.pilot.model;

public class DxContractData {
    private String shortName;
    private String status;
    private String vertragsnehmerLabel;
    private String territoryId;
    private String unternehmen;
    private String bezeichnung;
    private String beitrag;
    private String zahlweise;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVertragsnehmerLabel() {
        return vertragsnehmerLabel;
    }

    public void setVertragsnehmerLabel(String vertragsnehmerLabel) {
        this.vertragsnehmerLabel = vertragsnehmerLabel;
    }

    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    public String getUnternehmen() {
        return unternehmen;
    }

    public void setUnternehmen(String unternehmen) {
        this.unternehmen = unternehmen;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBeitrag() {
        return beitrag;
    }

    public void setBeitrag(String beitrag) {
        this.beitrag = beitrag;
    }

    public String getZahlweise() {
        return zahlweise;
    }

    public void setZahlweise(String zahlweise) {
        this.zahlweise = zahlweise;
    }
}
