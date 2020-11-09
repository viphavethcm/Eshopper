package com.nhatduy.Eshopper.daoImpl.utils;

import com.nhatduy.Eshopper.daoImpl.ProductDaoimpl;
import com.nhatduy.Eshopper.daoImpl.UserDaoImpl;

public class SingletonDao {
    private static UserDaoImpl userDao = null;
    private static ProductDaoimpl productDao = null;

    public static UserDaoImpl getInstanceUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    public static ProductDaoimpl getInstanceProductDao() {
        if (productDao == null) {
            productDao = new ProductDaoimpl();
        }
        return productDao;
    }
}
