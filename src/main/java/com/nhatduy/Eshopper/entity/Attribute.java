package com.nhatduy.Eshopper.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Attribute")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AttributeID")
    private int attributeID;

    @Column(name = "AttributeName")
    private String attributeName;

    @OneToMany(mappedBy = "attribute", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<AttributeValues> attributeValues;


    public int getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(int attributeID) {
        this.attributeID = attributeID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public List<AttributeValues> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValues> attributeValues) {
        this.attributeValues = attributeValues;
    }
}
