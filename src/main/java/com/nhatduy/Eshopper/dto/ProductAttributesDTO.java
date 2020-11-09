package com.nhatduy.Eshopper.dto;

import java.util.Set;


public class ProductAttributesDTO {
    private Set<String> sizes;
    private Set<String> colors;
    private Set<String> images;

    public Set<String> getSizes() {
        return sizes;
    }

    public void setSizes(Set<String> sizes) {
        this.sizes = sizes;
    }

    public Set<String> getColors() {
        return colors;
    }

    public void setColors(Set<String> colors) {
        this.colors = colors;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }
}
