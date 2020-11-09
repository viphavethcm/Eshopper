package com.nhatduy.Eshoper.testAPI;

import com.nhatduy.Eshopper.dao.ProductDao;
import com.nhatduy.Eshopper.daoImpl.BrandDaoImpl;
import com.nhatduy.Eshopper.daoImpl.utils.SingletonDao;
import com.nhatduy.Eshopper.dto.*;
import com.nhatduy.Eshopper.entity.Brand;
import com.nhatduy.Eshopper.entity.Product;
import com.nhatduy.Eshopper.paging.logic.paging.PageRequest;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;
import com.nhatduy.Eshopper.paging.logic.sort.Sorter;
import com.nhatduy.Eshopper.service.AttributeService;
import com.nhatduy.Eshopper.service.BrandService;
import com.nhatduy.Eshopper.service.CategoryService;
import com.nhatduy.Eshopper.service.ProductService;
import com.nhatduy.Eshopper.serviceImpl.AttributeServiceImpl;
import com.nhatduy.Eshopper.serviceImpl.BrandServiceImpl;
import com.nhatduy.Eshopper.serviceImpl.CategoryServiceImpl;
import com.nhatduy.Eshopper.serviceImpl.utils.SignletonService;
import com.nhatduy.Eshopper.utils.UserUtils;
import org.testng.annotations.Test;
;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductTest {

    private ProductService productService = SignletonService.getInstanceProductService();
    private ProductDao productDao = SingletonDao.getInstanceProductDao();


    @Test
    void testSaveDTO() {
        ProductDTO productDTO = new ProductDTO();
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setBrandID(1);
        brandDTO.setBrandName("Addidas");
        brandDTO.addProduct(productDTO);
        productDTO.setProductName("Áo thun Y2010");
        productDTO.setPrice(20);
        productDTO.setBrandID(brandDTO);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        productDTO.setCreate_Day(UserUtils.Datechanged(time));
        productDTO.setModify_Day(UserUtils.Datechanged(time));
        productService.addProduct(productDTO);

    }

    @Test
    void findbyProperties(){
        Map<String,Object> map = new HashMap<String,Object>();
        Object[]objects = productService.findProperty(null,null,null);
    }

    @Test
    // 1 san pham co nhieu hinh anh
    void saveImage(){
        ProductImageDTO productImageDTO = new ProductImageDTO();
        productImageDTO.setImageName("test.jpg");
        productService.updateImage(productImageDTO);
    }


    @Test
    void countProtduct(){
        int result = 0;
        result = productDao.getTotalItems();
    }

    @Test
    void getListProduct(){
        List<Product> products = productDao.getListProductActive();
    }

    @Test
    void getListSimple() {
        List<ProductDTO> productDTOS = productService.getListSimpleProduct(1);
    }

    @Test
    void getAttributes(){
        List<ProductDTO> productDTOs = productService.getListSimpleProduct(1);
        ProductAttributesDTO productAttributesDTO = productService.getAttributeValues(productDTOs);
    }


    @Test
    void getListBrands(){
        BrandDaoImpl brandDao = new BrandDaoImpl();
        Pageble pageble = new PageRequest(0,0,new Sorter("brandName","asc"));
        List<Brand> brands = brandDao.findAllPagination(pageble);
    }

    @Test
    void test(){
        Pageble pageble = new PageRequest(0,0,new Sorter("productID","asc"));
        List<Product> products = productDao.findAllPagination(pageble);

    }

    @Test
    void getAllAttribute(){
        CategoryService categoryService = new CategoryServiceImpl();
        List<CategoriesDTO> categoriesDTOS = categoryService.getAllCategories();
    }
    @Test
    void abc(){
        AttributeService attributeService = new AttributeServiceImpl();
        BrandService brandService = new BrandServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        ListAttributeProduct listAttributeProduct = new ListAttributeProduct(attributeService.getListAttribute(),brandService.getListBrand(),categoryService.getAllCategories());
    }


}

