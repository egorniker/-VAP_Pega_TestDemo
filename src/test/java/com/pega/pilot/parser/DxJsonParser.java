package com.pega.pilot.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pega.pilot.model.DxContractData;

import java.io.File;

public class DxJsonParser {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DxContractData parse(String path) throws Exception {
        JsonNode root = objectMapper.readTree(new File(path));

        DxContractData data = new DxContractData();
        JsonNode content = root.path("data").path("caseInfo").path("content");

        data.setShortName(content.path("ShortName").asText(""));
        data.setStatus(content.path("VertragsstatusUI").asText(""));
        data.setVertragsnehmerLabel(content.path("Vertragsnehmer").path("pyLabel").asText(""));
        data.setTerritoryId(content.path("TerritoryID").asText(""));
        data.setUnternehmen(content.path("Unternehmen").asText(""));
        data.setBezeichnung(content.path("Vertragsbezeichnung").asText(""));
        data.setBeitrag(content.path("Bruttobeitrag").asText(""));
        data.setZahlweise(content.path("Zahlweise").asText(""));

        return data;
    }
}
