package com.nhatduy.Eshopper.dao;

import com.nhatduy.Eshopper.entity.Product;
import com.nhatduy.Eshopper.entity.ProductImage;

import java.util.List;

public interface ProductDao extends GenericDao<Integer, Product> {

    // get List Product Active
    List<Product> getListProductActive();

    void addProduct(List<Product> products);

    // get List SimpleProduct by Name
    List<Product> getListSimpleProduct(int productID);

    // get Product by Name
    Product getProductDetails(String productName);

    void updateImage(ProductImage productImage);
}
