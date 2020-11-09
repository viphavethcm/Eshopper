package com.nhatduy.Eshopper.service;

import com.nhatduy.Eshopper.dto.*;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;

import java.util.List;
import java.util.Map;

public interface ProductService {
    int getTotalItems();

    int deleteProduct(List<Integer> ids);

    // get Product Homepage
    List<ProductDTO> getListProductActive();

    // get List Simple Product of one product Admin
    List<ProductDTO> getListSimpleProduct(int productID);

    // get All Attribute values of Product
    ProductAttributesDTO getAttributeValues(List<ProductDTO> products);

    void updateImage(ProductImageDTO productImageDTO);

    void addProduct(ProductDTO productDTO);

    List<ProductDTO> getListProductPagination(Pageble pageble);


    Object[] findProperty(Map<String, Object> properties, String sortExpression, String sortDirection);
}
