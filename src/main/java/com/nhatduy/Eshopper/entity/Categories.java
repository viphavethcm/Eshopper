package com.nhatduy.Eshopper.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private int ID;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "Created_Date")
    private String created_Date;

    @Column(name = "Modified_Date")
    private String modified_Date;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.MERGE, CascadeType.PERSIST})
    private List<Product> products;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
