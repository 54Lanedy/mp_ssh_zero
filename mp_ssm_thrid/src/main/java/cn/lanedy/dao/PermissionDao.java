package cn.lanedy.dao;

import cn.lanedy.entity.Permission;
import cn.lanedy.entity.Role;

import java.util.List;

/**
 * @auther TyCoding
 * @date 2018/7/18
 */
public interface PermissionDao {

    void create(Permission permission);

    void delete(Long id);

    List<Permission> findAll();

    void update(Permission permission);

    Permission findById(Long id);

    List<Role> findRoleByPermissionId(Long id);

    void deleteAllPermissionsRoles(Long id);

    void correlationRoles(Long permissionId, Long roleId);
}
