package com.nhatduy.core.core.persistence.data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "Email")
    private String  email;

    @Column(name = "Address")
    private String address;

    @Column(name = "passWord")
    private String password;

    @Column (name = "createDay")
    private Timestamp createday;

    @Column(name = "modifyDay")
    private Timestamp modifyday;

    @OneToOne
    @JoinColumn(name = "roleId")
    private  RoleEntity roleEntity;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateday() {
        return createday;
    }

    public void setCreateday(Timestamp createday) {
        this.createday = createday;
    }

    public Timestamp getModifyday() {
        return modifyday;
    }

    public void setModifyday(Timestamp modifyday) {
        this.modifyday = modifyday;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}