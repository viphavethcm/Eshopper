package com.nhatduy.Eshopper.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AttributeValues")
public class AttributeValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AttributeValueID;

    @Column(name = "ValueName")
    private String valueName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "AttributeID")
    private Attribute attribute;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "ProductAttributeValues",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Product> products;


    public int getAttributeValueID() {
        return AttributeValueID;
    }

    public void setAttributeValueID(int attributeValueID) {
        AttributeValueID = attributeValueID;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
