package com.qf.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.RoleMapper;
import com.qf.dao.RolePowerMapper;
import com.qf.entity.Role;
import com.qf.entity.Role_Power;
import com.qf.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RoleServiceImple implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolePowerMapper rolePowerMapper;

    @Override
    public List<Role> listAllRole() {
        return roleMapper.selectList(null);
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public List<Role> queryRoleByUid(Integer uid) {
        return roleMapper.queryRoleByUid(uid);
    }

    @Override
    public int updateRolePower(Integer roleid, Integer[] pids) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("roleid",roleid);
        rolePowerMapper.delete(queryWrapper);

        for (Integer pid : pids) {
            Role_Power role_power = new Role_Power(roleid,pid);
            rolePowerMapper.insert(role_power);
        }
        return 1;
    }


}
