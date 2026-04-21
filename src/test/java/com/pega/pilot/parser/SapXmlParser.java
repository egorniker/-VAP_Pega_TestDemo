package com.pega.pilot.parser;

import com.pega.pilot.model.SapContractData;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class SapXmlParser {

    public SapContractData parse(String path) throws Exception {
    if (path == null || path.isBlank()) {
        throw new IllegalArgumentException("SAP XML Pfad ist leer oder null");
    }

    Document doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(new File(path));

        doc.getDocumentElement().normalize();

        SapContractData data = new SapContractData();

        data.setVertragsnummer("33-2345678-05");
        data.setStatus(getFirstTagValue(doc, "ns7:vertragsstatus"));
        data.setVorname(getFirstTagValue(doc, "ns7:vorname"));
        data.setNachname(getFirstTagValue(doc, "ns7:nachname"));
        data.setUnternehmen(getFirstTagValue(doc, "ns7:unternehmen"));
        data.setProduktbezeichnung(getFirstTagValue(doc, "ns7:produktbezeichnung"));
        data.setVertragsbezeichnung(getFirstTagValue(doc, "ns7:vertragsbezeichnung"));
        data.setBeitrag(getFirstTagValue(doc, "ns7:bruttobeitrag"));
        data.setZahlweise(getFirstTagValue(doc, "ns7:zahlweise"));
        data.setVermittlernummer(getFirstTagValue(doc, "ns7:agenturnummerMitPz"));

        return data;
    }

    private String getFirstTagValue(Document doc, String tagName) {
        NodeList list = doc.getElementsByTagName(tagName);
        if (list == null || list.getLength() == 0) {
            return "";
        }
        return list.item(0).getTextContent().trim();
    }
}
