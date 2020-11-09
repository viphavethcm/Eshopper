package com.nhatduy.Eshopper.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {

    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<Product>();
        }
        products.add(product);
        product.setBrand(this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BrandID")
    private int brandID;

    @Column(name = "BrandName")
    private String brandName;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    private List<Product> products;

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
