package com.nhatduy.Eshoper.testAPI;

import com.nhatduy.Eshopper.dao.UserDao;
import com.nhatduy.Eshopper.daoImpl.UserDaoImpl;
import com.nhatduy.Eshopper.daoImpl.utils.SingletonDao;
import com.nhatduy.Eshopper.dto.RoleDTO;
import com.nhatduy.Eshopper.dto.UserDTO;
import com.nhatduy.Eshopper.entity.Role;
import com.nhatduy.Eshopper.entity.User;
import com.nhatduy.Eshopper.paging.logic.paging.PageRequest;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;
import com.nhatduy.Eshopper.paging.logic.sort.Sorter;
import com.nhatduy.Eshopper.service.UserService;
import com.nhatduy.Eshopper.serviceImpl.UserServiceImpl;
import com.nhatduy.Eshopper.serviceImpl.utils.SignletonService;
import com.nhatduy.Eshopper.utils.UserUtils;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserTest {

    UserService userService = SignletonService.getInstanceUserService();
    UserDao userDao = SingletonDao.getInstanceUserDao();
    @Test
    void testSaveDTO(){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("ngoc");
        userDTO.setPassWord("06111999");
        userDTO.setFullName("Hồng Ngọc");
        userDTO.setEmail("user@gmail.com");
        userDTO.setAddress("TB");
        userDTO.setStatus(true);
        userDTO.setCreate_Day(UserUtils.Datechanged(time));
        userDTO.setModify_Day(UserUtils.Datechanged(time));
        userService.addUser(userDTO);

    }


    @Test
    void checkExist(){
        UserDTO userDTO = userService.checkExistUser("duy","14091996");
    }

    @Test
    void checkSort(){
        Pageble pageble = new PageRequest(1,2,new Sorter("userID","DESC"));
        UserDao userDao = new UserDaoImpl();
        List<User> list =  userDao.findAllPagination(pageble);
    }

    @Test
    void testDelete(){
        Integer count = 0;
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(2);
        count = userDao.delete(ids);

    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setUserID(2);
        user.setPassWord("140911");
        userDao.update(user);


    }

    @Test
    void testFindbyID(){
        Integer id = 5 ;
        User user = userDao.findById(id);
        UserDTO userDTO = UserUtils.entity2DTO(user);
    }

    @Test
    void testFindAll(){
        List<User> list = new ArrayList<User>();
//        list = userDao.findAll();
    }

    @Test
    void findProperties(){

    }

}
