package com.nhatduy.Eshopper.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO extends AbstractDTO<ProductDTO> implements Serializable {
    private String productName;
    private String productType;
    private Integer quantity;
    private float price;
    private BrandDTO brandID;
    private String baseImage;
    private String color;
    private String size;
    private boolean active;
    private ListAttributeProduct listAttributeProduct;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public BrandDTO getBrandID() {
        return brandID;
    }

    public void setBrandID(BrandDTO brandID) {
        this.brandID = brandID;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ListAttributeProduct getListAttributeProduct() {
        return listAttributeProduct;
    }

    public void setListAttributeProduct(ListAttributeProduct listAttributeProduct) {
        this.listAttributeProduct = listAttributeProduct;
    }
}
