package com.pega.pilot.model;

public class ContractTestSet {

    private final String testId;
    private final String sapXmlPath;
    private final String dxJsonPath;
    private final String mappingPath;

    public ContractTestSet(String testId, String sapXmlPath, String dxJsonPath, String mappingPath) {
        this.testId = testId;
        this.sapXmlPath = sapXmlPath;
        this.dxJsonPath = dxJsonPath;
        this.mappingPath = mappingPath;
    }

    public String getTestId() {
        return testId;
    }

    public String getSapXmlPath() {
        return sapXmlPath;
    }

    public String getDxJsonPath() {
        return dxJsonPath;
    }

    public String getMappingPath() {
        return mappingPath;
    }
}