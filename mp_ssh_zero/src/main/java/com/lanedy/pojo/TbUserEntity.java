package com.lanedy.pojo;

import java.util.Set;

/**
 * Created by liyue
 * Time 2019-03-26 10:07
 */
public class TbUserEntity {
    private int userId;
    private String userName;
    private String userPassword;
    private String userPasswordSalt;
    private Set<TbRoleEntity> roles; // 用户对应的角色集合

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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPasswordSalt() {
        return userPasswordSalt;
    }

    public void setUserPasswordSalt(String userPasswordSalt) {
        this.userPasswordSalt = userPasswordSalt;
    }

    public Set<TbRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<TbRoleEntity> roles) {
        this.roles = roles;
    }
}
