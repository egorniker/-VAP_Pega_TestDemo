package com.pega.pilot.model;

public class MappingRule {
    private String fieldLabel;
    private String expectedSource;
    private String actualSource;
    private String rule;
    private boolean temporaryMapping;

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String getExpectedSource() {
        return expectedSource;
    }

    public void setExpectedSource(String expectedSource) {
        this.expectedSource = expectedSource;
    }

    public String getActualSource() {
        return actualSource;
    }

    public void setActualSource(String actualSource) {
        this.actualSource = actualSource;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public boolean isTemporaryMapping() {
        return temporaryMapping;
    }

    public void setTemporaryMapping(boolean temporaryMapping) {
        this.temporaryMapping = temporaryMapping;
    }
}
