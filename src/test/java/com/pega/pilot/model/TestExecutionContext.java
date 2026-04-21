package com.pega.pilot.model;

import java.util.ArrayList;
import java.util.List;

public class TestExecutionContext {
    private String sapFilePath;
    private String dxFilePath;
    private String mappingFilePath;
    private SapContractData sapData;
    private DxContractData dxData;
    private List<MappingRule> mappingRules = new ArrayList<>();
    private List<FieldComparisonResult> results = new ArrayList<>();

    public String getSapFilePath() {
        return sapFilePath;
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
}
