package com.nhatduy.Eshopper.utils;


import com.nhatduy.Eshopper.dto.ProductImageDTO;
import com.nhatduy.Eshopper.entity.ProductImage;

public class ProductImageUtils {
    public static ProductImageDTO entity2DTO(ProductImage productImage) {
        ProductImageDTO productImageDTO = new ProductImageDTO();
        productImageDTO.setImageID(productImage.getImageID());
        productImageDTO.setImageName(productImage.getImageName());
        return productImageDTO;
    }

    public static ProductImage DTO2entity(ProductImageDTO productImageDTO) {
        ProductImage productImage = new ProductImage();
        productImage.setImageName(productImageDTO.getImageName());
        return productImage;
    }
}
