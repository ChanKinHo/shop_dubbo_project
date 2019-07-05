package com.qf.service;

import com.qf.entity.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> listAllRole();

    public int addRole(Role role);

    public List<Role> queryRoleByUid(Integer uid);

    public int updateRolePower(Integer roleid,Integer[] pids);
}
