package com.nhatduy.Eshopper.service;

import com.nhatduy.Eshopper.dto.UserDTO;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;

import java.util.List;

public interface UserService {

    int getTotalItems();

    UserDTO checkExistUser(String name, String password);

    void addUser(UserDTO userDTO);

    List<UserDTO> getListUser(Pageble pageble);

    UserDTO getUserbyID(int id);


}
