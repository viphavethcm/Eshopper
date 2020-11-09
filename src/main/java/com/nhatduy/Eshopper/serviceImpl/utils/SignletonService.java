package com.nhatduy.Eshopper.serviceImpl.utils;

import com.nhatduy.Eshopper.serviceImpl.ProductServiceImpl;
import com.nhatduy.Eshopper.serviceImpl.UserServiceImpl;

public class SignletonService {

    public static ProductServiceImpl productService = null;
    public static UserServiceImpl userService = null;

    public static UserServiceImpl getInstanceUserService() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    public static ProductServiceImpl getInstanceProductService() {
        if (productService == null) {
            productService = new ProductServiceImpl();
        }
        return productService;
    }
}
