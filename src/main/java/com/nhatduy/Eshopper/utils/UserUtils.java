package com.nhatduy.Eshopper.utils;

import com.nhatduy.Eshopper.dao.UserDao;
import com.nhatduy.Eshopper.daoImpl.utils.SingletonDao;
import com.nhatduy.Eshopper.dto.RoleDTO;
import com.nhatduy.Eshopper.dto.UserDTO;
import com.nhatduy.Eshopper.entity.Role;
import com.nhatduy.Eshopper.entity.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserUtils {


    public static UserDTO entity2DTO(User user) {
        UserDao userDao = SingletonDao.getInstanceUserDao();
        UserDTO userDTO = new UserDTO();
        List<String> roles = new ArrayList<>();
        if (user == null) {
            userDTO = null;
        } else {
            userDTO.setID(user.getUserID());
            userDTO.setUserName(user.getUserName());
            userDTO.setPassWord(getMD5(user.getPassWord()));
            userDTO.setFullName(user.getFullName());
            userDTO.setEmail(user.getEmail());
            userDTO.setAddress(user.getAddress());
            userDTO.setCreate_Day(user.getCreate_Day());
            userDTO.setModify_Day(user.getModify_Day());
            userDTO.setStatus(user.isStatus());
            for (String roleName : userDao.getRole(userDTO.getID())) {
                roles.add(roleName.substring(5));

            }
            userDTO.setRoleName(roles);
        }
        return userDTO;
    }

    public static User DTO2entity(UserDTO userDTO) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (userDTO.getCreate_Day() == null) {
            userDTO.setCreate_Day(Datechanged(timestamp));
        }
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setFullName(userDTO.getFullName());
        user.setPassWord(getMD5(userDTO.getPassWord()));
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setCreate_Day(userDTO.getCreate_Day());
        user.setModify_Day(userDTO.getModify_Day());
        user.setStatus(userDTO.isStatus());
        try {
            List<Role> roles = new ArrayList<>();
            List<User> users = new ArrayList<>();
            RoleDTO roleDTO = new RoleDTO();
            Role role = new Role();
            roleDTO.setRoleID(2);
            roleDTO.setRoleName("ROLE_USER");
            roles.add(RoleUtils.DTO2entity(roleDTO));
            users.add(user);
            user.setRoles(roles);
            role.setUsers(users);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public static String Datechanged(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date(timestamp.getTime());
        String dateTransfer = dateFormat.format(date);
        return dateTransfer;
    }

    public static String getMD5(String password) {
        String key = new String("!!@##^$%Ngoc!@#$^#&Duy");
        password = key.concat(password).concat(key);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hasttext = no.toString(16);
            while (hasttext.length() < 32) {
                hasttext = "0" + hasttext;
            }
            return hasttext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

