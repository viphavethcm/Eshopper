package com.nhatduy.Eshopper.dao;

import com.nhatduy.Eshopper.entity.User;

import java.util.List;

public interface UserDao extends GenericDao<Integer, User> {
    User check(String name, String password);

    List<String> getRole(int userID);

}

