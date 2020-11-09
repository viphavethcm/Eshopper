package com.nhatduy.Eshopper.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BrandDTO implements Serializable {
    private Integer brandID;
    private String brandName;
    private List<ProductDTO> products;

    public void addProduct(ProductDTO productDTO) {
        if (products == null) {
            products = new ArrayList<ProductDTO>();
        }
        products.add(productDTO);
        productDTO.setBrandID(this);
    }

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
