package com.nhatduy.Eshopper.serviceImpl;

import com.nhatduy.Eshopper.dao.ProductDao;
import com.nhatduy.Eshopper.daoImpl.utils.SingletonDao;
import com.nhatduy.Eshopper.dto.*;
import com.nhatduy.Eshopper.entity.*;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;
import com.nhatduy.Eshopper.service.ProductService;
import com.nhatduy.Eshopper.utils.ProductImageUtils;
import com.nhatduy.Eshopper.utils.ProductUtils;

import java.util.*;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = SingletonDao.getInstanceProductDao();

//    @Inject
//    private ProductDao productDao;


    @Override
    public int getTotalItems() {
        return productDao.getTotalItems();
    }

    @Override
    public int deleteProduct(List<Integer> ids) {
        return productDao.delete(ids);
    }


    @Override
    public List<ProductDTO> getListProductActive() {
        List<Product> listEntity = productDao.getListProductActive();
        List<ProductDTO> listProductDTO = new ArrayList<>();
        for (Product product : listEntity) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setID(product.getProductID());
            productDTO.setProductName(product.getProductName());
            productDTO.setBaseImage(product.getProductImage().getImageName());
            listProductDTO.add(productDTO);
        }
        return listProductDTO;
    }

    @Override
    public List<ProductDTO> getListSimpleProduct(int productID) {
        List<Product> listEntity = productDao.getListSimpleProduct(productID);
        List<ProductDTO> listProductDTO = new ArrayList<>();
        for (Product product : listEntity) {
            listProductDTO.add(ProductUtils.entity2DTO(product));
        }
        return listProductDTO;
    }

    @Override
    public ProductAttributesDTO getAttributeValues(List<ProductDTO> products) {
        Set<String> sizes = new HashSet<>();
        Set<String> colors = new HashSet<>();
        Set<String> images = new HashSet<>();
        for (ProductDTO productDTO : products) {
            if (!sizes.contains(productDTO.getSize())) {
                sizes.add(productDTO.getSize());
            }
            if (!colors.contains(productDTO.getColor())) {
                colors.add(productDTO.getColor());
            }
            if (!images.contains(productDTO.getBaseImage())) {
                images.add(productDTO.getBaseImage());
            }
        }
        ProductAttributesDTO productAttributesDTO = new ProductAttributesDTO();
        productAttributesDTO.setSizes(sizes);
        productAttributesDTO.setColors(colors);
        productAttributesDTO.setImages(images);
        return productAttributesDTO;
    }


    public void updateImage(ProductImageDTO productImageDTO) {
        ProductImage productImage = ProductImageUtils.DTO2entity(productImageDTO);
        productDao.updateImage(productImage);
    }

    public void addProduct(ProductDTO productDTO) {
        List<Product> products = ProductUtils.DTO2entity(productDTO);
        productDao.addProduct(products);
    }

    public List<ProductDTO> getListProductPagination(Pageble pageble) {
        List<Product> listEntity = productDao.findAllPagination(pageble);
        List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
        for (Product item : listEntity) {
            listProductDTO.add(ProductUtils.entity2DTO(item));
        }
        return listProductDTO;
    }

    public Object[] findProperty(Map<String, Object> properties, String sortExpression, String sortDirection) {
        List<ProductDTO> userDTOList = new ArrayList<ProductDTO>();
        Object[] objects = productDao.findProperty(properties, sortExpression, sortDirection);
        for (Product product : (List<Product>) objects[0]) {
            ProductDTO userDTO = ProductUtils.entity2DTO(product);
            userDTOList.add(userDTO);
        }
        return new Object[]{objects[0], userDTOList};
    }


}
