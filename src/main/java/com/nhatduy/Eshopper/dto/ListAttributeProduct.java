package com.nhatduy.Eshopper.dto;

import java.util.List;

public class ListAttributeProduct {
    List<AttributeDTO> attributes;
    List<BrandDTO> brands;
    List<CategoriesDTO> categories;

    public ListAttributeProduct(List<AttributeDTO> attributes, List<BrandDTO> brands, List<CategoriesDTO> categories) {
        this.attributes = attributes;
        this.brands = brands;
        this.categories = categories;
    }

    public List<AttributeDTO> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeDTO> attributes) {
        this.attributes = attributes;
    }

    public List<BrandDTO> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandDTO> brands) {
        this.brands = brands;
    }

    public List<CategoriesDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesDTO> categories) {
        this.categories = categories;
    }
}
