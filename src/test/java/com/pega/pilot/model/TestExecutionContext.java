package com.pega.pilot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestExecutionContext {
    private String sapFilePath;
    private String dxFilePath;
    private String mappingFilePath;
    private SapContractData sapData;
    private DxContractData dxData;
    private List<MappingRule> mappingRules = new ArrayList<>();
    private List<FieldComparisonResult> results = new ArrayList<>();
    private String testId;
    private String testSetCsvPath;
    private String currentTestId;
    private Map<String, List<FieldComparisonResult>> resultsByTestSet = new LinkedHashMap<>();

    public String getSapFilePath() {
        return sapFilePath;
    }
    public String getTestId() {
    return testId;
    }
    public void setTestId(String testId) {
    this.testId = testId;
    }

    public void setSapFilePath(String sapFilePath) {
        this.sapFilePath = sapFilePath;
    }

    public String getDxFilePath() {
        return dxFilePath;
    }

    public void setDxFilePath(String dxFilePath) {
        this.dxFilePath = dxFilePath;
    }

    public String getMappingFilePath() {
        return mappingFilePath;
    }

    public void setMappingFilePath(String mappingFilePath) {
        this.mappingFilePath = mappingFilePath;
    }

    public SapContractData getSapData() {
        return sapData;
    }

    public void setSapData(SapContractData sapData) {
        this.sapData = sapData;
    }

    public DxContractData getDxData() {
        return dxData;
    }

    public void setDxData(DxContractData dxData) {
        this.dxData = dxData;
    }

    public List<MappingRule> getMappingRules() {
        return mappingRules;
    }

    public void setMappingRules(List<MappingRule> mappingRules) {
        this.mappingRules = mappingRules;
    }

    public List<FieldComparisonResult> getResults() {
        return results;
    }

    public void setResults(List<FieldComparisonResult> results) {
        this.results = results;
    }
    public String getTestSetCsvPath() {
    return testSetCsvPath;
    }

    public void setTestSetCsvPath(String testSetCsvPath) {
        this.testSetCsvPath = testSetCsvPath;
    }

    public String getCurrentTestId() {
        return currentTestId;
    }

    public void setCurrentTestId(String currentTestId) {
        this.currentTestId = currentTestId;
    }

    public Map<String, List<FieldComparisonResult>> getResultsByTestSet() {
        return resultsByTestSet;
    }

    public void setResultsByTestSet(Map<String, List<FieldComparisonResult>> resultsByTestSet) {
        this.resultsByTestSet = resultsByTestSet;
    }
}
