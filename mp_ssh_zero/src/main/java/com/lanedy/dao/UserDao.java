package com.lanedy.dao;

import com.lanedy.pojo.TbPermissionEntity;
import com.lanedy.pojo.TbRoleEntity;
import com.lanedy.pojo.TbUserEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liyue
 * Time 2019-03-26 15:01
 */
@Repository
public class UserDao implements IUserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public TbUserEntity findUserForLogin(TbUserEntity user) {
        TbUserEntity  loginUser = sessionFactory.getCurrentSession()
                .createQuery("from TbUserEntity u" +
                        " where u.userName=:userName" +
                        " and u.userPassword=:userPassword ",TbUserEntity.class)
                .setParameter("userName",user.getUserName())
                .setParameter("userPassword",user.getUserPassword())
                .getResultList().get(0);

        return loginUser;
    }

    @Override
    @Transactional
    public Set<String> findRoleNameByUsername(String username) {
        List<TbUserEntity> list = sessionFactory.getCurrentSession()
                .createQuery("from TbUserEntity u" +
                        " where u.userName=:userName", TbUserEntity.class)
                .setParameter("userName", username)
                .getResultList();
        if (list.size()==0) {
            return null;
        }
        TbUserEntity user = list.get(0);
        Set<String> roleNameSet = new HashSet<>();
        for (TbRoleEntity role : user.getRoles()) {
            roleNameSet.add(role.getRoleName());
        }
        return roleNameSet;
    }

    @Override
    @Transactional
    public Set<String> findPermissionNameByUserName(String username) {
        List<TbUserEntity> list = sessionFactory.getCurrentSession()
                .createQuery("from TbUserEntity u" +
                        " where u.userName=:userName", TbUserEntity.class)
                .setParameter("userName", username)
                .getResultList();
        if (list.size()==0) {
            return null;
        }
        TbUserEntity user = list.get(0);
        Set<String> permissionNameSet = new HashSet<>();
        for (TbRoleEntity role : user.getRoles()) {
            Set<TbPermissionEntity> permissionSet = new HashSet<>(role.getPermissions());
            for (TbPermissionEntity permission : permissionSet) {
                permissionNameSet.add(permission.getPermissionName());
            }

        }
        return permissionNameSet;
    }
}
