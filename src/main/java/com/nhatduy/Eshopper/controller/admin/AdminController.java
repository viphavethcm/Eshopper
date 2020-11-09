package com.nhatduy.Eshopper.controller.admin;

import com.nhatduy.Eshopper.common.constants.SystemContants;
import com.nhatduy.Eshopper.dto.ProductDTO;
import com.nhatduy.Eshopper.dto.UserDTO;
import com.nhatduy.Eshopper.paging.logic.paging.PageRequest;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;
import com.nhatduy.Eshopper.paging.logic.sort.Sorter;
import com.nhatduy.Eshopper.service.ProductService;
import com.nhatduy.Eshopper.service.UserService;
import com.nhatduy.Eshopper.utils.FormUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/admin-home", "/admin-listProduct", "/admin-listUser"})
public class AdminController extends HttpServlet {

    @Inject
    private UserService userService;

    @Inject
    private ProductService productService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/admin-listProduct":
                listProduct(request, response);
                break;
            case "/admin-listUser":
                listUser(request, response);
                break;
            default:
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/admin.jsp");
                requestDispatcher.forward(request, response);
                break;
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDTO productDTO = FormUtils.populate(ProductDTO.class, request);
        Pageble pageble = new PageRequest(productDTO.getPage(), productDTO.getMaxPageItem(),
                new Sorter(productDTO.getSortName(), productDTO.getSortBy()));
        productDTO.setListResult(productService.getListProductPagination(pageble));
        productDTO.setTotalItems(productService.getTotalItems());
        productDTO.setTotalPages((int) Math.ceil((double) productDTO.getTotalItems() / productDTO.getMaxPageItem()));
        request.setAttribute(SystemContants.MODEL, productDTO);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/product/productManament.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO userDTO = FormUtils.populate(UserDTO.class, request);
        Pageble pageble = new PageRequest(userDTO.getPage(), userDTO.getMaxPageItem(),
                new Sorter(userDTO.getSortName(), userDTO.getSortBy()));
        userDTO.setListResult(userService.getListUser(pageble));
        userDTO.setTotalItems(userService.getTotalItems());
        userDTO.setTotalPages((int) Math.ceil((double) userDTO.getTotalItems() / userDTO.getMaxPageItem()));
        request.setAttribute(SystemContants.MODEL, userDTO);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/user/userManagement.jsp");
        requestDispatcher.forward(request, response);
    }

}
