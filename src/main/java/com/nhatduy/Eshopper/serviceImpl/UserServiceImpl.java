package com.nhatduy.Eshopper.serviceImpl;

import com.nhatduy.Eshopper.dao.UserDao;
import com.nhatduy.Eshopper.daoImpl.utils.SingletonDao;
import com.nhatduy.Eshopper.dto.RoleDTO;
import com.nhatduy.Eshopper.dto.UserDTO;
import com.nhatduy.Eshopper.entity.Role;
import com.nhatduy.Eshopper.entity.User;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;
import com.nhatduy.Eshopper.service.UserService;
import com.nhatduy.Eshopper.utils.RoleUtils;
import com.nhatduy.Eshopper.utils.UserUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

//    UserDao userDao = SingletonDao.getInstanceUserDao();

    @Override
    public int getTotalItems() {
        return userDao.getTotalItems();
    }


    public UserDTO checkExistUser(String name, String password) {
        User user = userDao.check(name, password);
        return UserUtils.entity2DTO(user);
    }

    public void addUser(UserDTO userDTO) {
        User user = UserUtils.DTO2entity(userDTO);
        userDao.save(user);
    }

    public List<UserDTO> getListUser(Pageble pageble) {
        List<User> listEntity = userDao.findAllPagination(pageble);
        List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
        for (User user : listEntity) {
            listUserDTO.add(UserUtils.entity2DTO(user));
        }
        return listUserDTO;
    }

    public UserDTO getUserbyID(int id) {
        User user = userDao.findById(id);
        return UserUtils.entity2DTO(user);
    }


}
