package com.nhatduy.Eshopper.dto;

import java.util.List;

public class AttributeDTO {
    private Integer ID;
    private String attributeName;
    private List<AttributeValuesDTO> attributeValues;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public List<AttributeValuesDTO> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValuesDTO> attributeValues) {
        this.attributeValues = attributeValues;
    }
}

