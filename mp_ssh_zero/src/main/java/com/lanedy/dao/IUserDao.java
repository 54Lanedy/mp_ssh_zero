package com.lanedy.dao;

import com.lanedy.pojo.TbUserEntity;

import java.util.Set;

/**
 * Created by liyue
 * Time 2019-03-26 15:00
 */
public interface IUserDao {
    TbUserEntity findUserForLogin(TbUserEntity user);
    Set<String> findRoleNameByUsername(String username);
    Set<String> findPermissionNameByUserName(String username);
}
