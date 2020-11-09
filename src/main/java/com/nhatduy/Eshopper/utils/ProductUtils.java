package com.nhatduy.Eshopper.utils;

import com.nhatduy.Eshopper.dto.*;
import com.nhatduy.Eshopper.entity.AttributeValues;
import com.nhatduy.Eshopper.entity.Brand;
import com.nhatduy.Eshopper.entity.Categories;
import com.nhatduy.Eshopper.entity.Product;
import org.w3c.dom.Attr;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductUtils {

    public static ProductDTO entity2DTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setID(product.getProductID());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductType(product.getProductType());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setPrice(product.getPrice());
        productDTO.setCreate_Day(product.getCreated_Date());
        productDTO.setModify_Day(product.getModified_Date());
        productDTO.setBaseImage(product.getProductImage().getImageName());
        productDTO.setActive(product.isActive());
        for (AttributeValues attributeValues : product.getProductAttributeValues()
        ) {
            if (attributeValues.getAttribute().getAttributeName().equalsIgnoreCase("size"))
                productDTO.setSize(attributeValues.getValueName());
            else
                productDTO.setColor(attributeValues.getValueName());
        }
        productDTO.setBrandID(BrandUtils.entity2DTO(product.getBrand()));
        return productDTO;
    }

    public static List<Product> DTO2entity(ProductDTO productDTO) {
        List<Product> listProduct = new ArrayList<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        productDTO.setCreate_Day(Datechanged(timestamp));
        Product mainProduct = new Product();
        mainProduct.setCreated_Date(productDTO.getCreate_Day());
        mainProduct.setProductName(productDTO.getProductName());
        mainProduct.setPrice(productDTO.getPrice());
        mainProduct.setProductType("configurable");
        mainProduct.setActive(true);
        mainProduct.setBrand(BrandUtils.DTO2entity(productDTO.getListAttributeProduct().getBrands().get(0)));
        for (AttributeValuesDTO attributeValuesDTO_1 : productDTO.getListAttributeProduct().getAttributes().get(0).getAttributeValues()) {
            for (int i = 0; i < productDTO.getListAttributeProduct().getAttributes().get(1).getAttributeValues().size(); i++) {
                List<AttributeValues> listAttributeValues = new ArrayList<>();
                Product product = new Product();
                product.setProductName(productDTO.getProductName());
                product.setPrice(productDTO.getPrice());
                product.setProductType("simple");
                product.setCreated_Date(productDTO.getCreate_Day());
                product.setBrand(BrandUtils.DTO2entity(productDTO.getListAttributeProduct().getBrands().get(0)));
                listAttributeValues.add(DTO2entity_AttributeVales(attributeValuesDTO_1));
                listAttributeValues.add(DTO2entity_AttributeVales(productDTO.getListAttributeProduct().getAttributes().get(1).getAttributeValues().get(i)));
                product.setProductAttributeValues(listAttributeValues);
                List<Categories> listCategories = new ArrayList<>();
                for (CategoriesDTO categoriesDTO : productDTO.getListAttributeProduct().getCategories()) {
                    Categories categories = new Categories();
                    categories.setID(categoriesDTO.getID());
                    categories.setCategoryName(categoriesDTO.getCategoryName());
                    listCategories.add(categories);
                }
                product.setCategories(listCategories);
                listProduct.add(product);
            }
            listProduct.add(mainProduct);
        }
        return listProduct;
    }

    public static String Datechanged(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date(timestamp.getTime());
        String dateTransfer = dateFormat.format(date);
        return dateTransfer;
    }

    public static AttributeValues DTO2entity_AttributeVales(AttributeValuesDTO attributeValuesDTO) {
        AttributeValues attributeValues = new AttributeValues();
        attributeValues.setAttributeValueID(attributeValuesDTO.getAttributeValueID());
        attributeValues.setValueName(attributeValuesDTO.getValueName());
        return attributeValues;
    }

}
