package com.nhatduy.Eshopper.controller;

import com.nhatduy.Eshopper.common.constants.SystemContants;
import com.nhatduy.Eshopper.dto.ProductDTO;
import com.nhatduy.Eshopper.service.ProductService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeController extends HttpServlet {

    @Inject
    private ProductService productService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            default:
                showHome(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDTO> listSimpleProducts = productService.getListProductActive();
        request.setAttribute(SystemContants.MODEL, listSimpleProducts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/home/home.jsp");
        requestDispatcher.forward(request, response);
    }

}
