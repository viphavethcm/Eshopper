package com.nhatduy.Eshopper.dto;

import java.io.Serializable;

public class ProductImageDTO implements Serializable {
    private Integer imageID;
    private String imageName;

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

}
