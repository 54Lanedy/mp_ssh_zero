package com.lanedy.realm;

import com.lanedy.dao.IUserDao;
import com.lanedy.pojo.TbUserEntity;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by liyue
 * Time 2019-03-26 15:26
 */
public class HibernateRealm extends AuthorizingRealm {
    @Resource
    private IUserDao userDao;
    /**
     * 权限验证的方法
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = principals.getPrimaryPrincipal().toString();
        Set<String> roleNameSet = userDao.findRoleNameByUsername(username);
        Set<String> permissionNameSet = userDao.findPermissionNameByUserName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roleNameSet); // 将角色名集合加入验证信息
        simpleAuthorizationInfo.setStringPermissions(permissionNameSet); // 权限名加入验证信息
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证的方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        // 转型
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername(); // 获取 用户名
        // 获取 密码，字符数组需要转型为 String
        String password = new String(upToken.getPassword());
        TbUserEntity user = new TbUserEntity();
        user.setUserName(username);
        user.setUserPassword(password);
        // 以下是登录认证的逻辑
        TbUserEntity userForLogin = userDao.findUserForLogin(user);
        if (userForLogin != null){
            // 身份认证成功，返回 SimpleAuthenticationInfo 对象
            return new SimpleAuthenticationInfo(
                    userForLogin.getUserName(), // 参数1：用户名
                    userForLogin.getUserPassword(), // 参数2：密码
                    getName() // 参数3：当前 Realm 的名称
            );
        } else {
            // 身份认证失败
            throw new AuthenticationException("用户名或密码错误！");
        }
    }
}
