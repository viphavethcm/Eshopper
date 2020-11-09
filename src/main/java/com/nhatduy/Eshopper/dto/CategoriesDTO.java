package com.nhatduy.Eshopper.dto;

import com.nhatduy.Eshopper.entity.AttributeValues;

import java.util.List;

public class CategoriesDTO {
    private Integer ID;
    private String categoryName;
    private String created_Date;
    private String modified_Date;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreated_Date() {
        return created_Date;
    }

    public void setCreated_Date(String created_Date) {
        this.created_Date = created_Date;
    }

    public String getModified_Date() {
        return modified_Date;
    }

    public void setModified_Date(String modified_Date) {
        this.modified_Date = modified_Date;
    }

}
