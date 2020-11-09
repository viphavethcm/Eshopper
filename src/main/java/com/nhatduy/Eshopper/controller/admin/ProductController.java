package com.nhatduy.Eshopper.controller.admin;

import com.google.gson.Gson;
import com.nhatduy.Eshopper.common.constants.SystemContants;
import com.nhatduy.Eshopper.dto.ListAttributeProduct;
import com.nhatduy.Eshopper.dto.ProductDTO;
import com.nhatduy.Eshopper.service.AttributeService;
import com.nhatduy.Eshopper.service.BrandService;
import com.nhatduy.Eshopper.service.CategoryService;
import com.nhatduy.Eshopper.service.ProductService;
import com.nhatduy.Eshopper.serviceImpl.AttributeServiceImpl;
import com.nhatduy.Eshopper.serviceImpl.BrandServiceImpl;
import com.nhatduy.Eshopper.serviceImpl.CategoryServiceImpl;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-deleteProduct", "/product-detail", "/ajax-product-detail", "/admin-showForm-add-product",
        "/admin-addProduct", "/admin-showList-attribute.html", "/ajax-list-Brand", "/ajax-show-TypeCategory",
        "/admin-showFrom-add-image"})
public class ProductController extends HttpServlet {

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/admin-deleteProduct":
                deleteProduct(request, response);
                break;
            case "/ajax-product-detail":
                getListSimpleProduct(request, response);
                break;
            case "/product-detail":
                getProductDetails(request, response);
                break;
            case "/admin-showForm-add-product":
                showAddProductPage(request, response);
                break;
            case "/admin-addProduct":
                doPost(request, response);
            case "/":

                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
        Gson gson = new Gson();
        String jsonObject = br.readLine();
        ProductDTO productDTO = gson.fromJson(jsonObject, ProductDTO.class);
        productService.addProduct(productDTO);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/product/modalPopup/addProductConfirmModal.jsp");
        requestDispatcher.forward(request, response);
    }


    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException {


    }


    private void getProductDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("i"));
        List<ProductDTO> listProduct = productService.getListSimpleProduct(id);
        request.setAttribute("list", listProduct);
        request.setAttribute("attributes", productService.getAttributeValues(listProduct));
        request.setAttribute(SystemContants.MODEL, listProduct.get(0));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/user/product/productDetail.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showAddProductPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AttributeService attributeService = new AttributeServiceImpl();
        BrandService brandService = new BrandServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        ListAttributeProduct listAttributeProduct = new ListAttributeProduct(attributeService.getListAttribute(), brandService.getListBrand(), categoryService.getAllCategories());
        request.setAttribute(SystemContants.MODEL, listAttributeProduct);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/product/addProduct.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getListSimpleProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        List<ProductDTO> listProduct = productService.getListSimpleProduct(productID);
        request.setAttribute(SystemContants.MODEL, listProduct);
        request.setAttribute("attributes", productService.getAttributeValues(listProduct));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/product/listSimpleProduct.jsp");
        requestDispatcher.forward(request, response);
    }


}
