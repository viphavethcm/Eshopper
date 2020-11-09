package com.nhatduy.Eshopper.entity;

import javax.persistence.*;

@Entity
@Table(name = "LinkedProducts")
public class LinkedProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "ProductID")
    private int productID;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "Linked_ProductID")
    private Product LinkedProduct;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Product getLinkedProduct() {
        return LinkedProduct;
    }

    public void setLinkedProduct(Product linkedProduct) {
        LinkedProduct = linkedProduct;
    }
}
