package com.nhatduy.Eshopper.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ImageID")
    private int imageID;

    @Column(name = "ImageName")
    private String imageName;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    private List<Product> products;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
