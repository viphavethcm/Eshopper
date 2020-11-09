package com.nhatduy.Eshopper.utils;


import com.nhatduy.Eshopper.dto.RoleDTO;
import com.nhatduy.Eshopper.dto.UserDTO;
import com.nhatduy.Eshopper.entity.Role;
import com.nhatduy.Eshopper.entity.User;

import java.util.List;

public class RoleUtils {
    public static RoleDTO entity2DTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleID(role.getRoleID());
        roleDTO.setRoleName(role.getRoleName());
        return roleDTO;
    }

    public static Role DTO2entity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setRoleID(roleDTO.getRoleID());
        role.setRoleName(roleDTO.getRoleName());
        return role;
    }

}
