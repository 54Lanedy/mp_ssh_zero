package com.lanedy.pojo;

import java.util.Set;

/**
 * Created by liyue
 * Time 2019-03-26 10:08
 */
public class TbRoleEntity {

    private int roleId;
    private String roleName;
    private Set<TbPermissionEntity> permissions; // 角色对应的权限集合

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<TbPermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<TbPermissionEntity> permissions) {
        this.permissions = permissions;
    }
}
