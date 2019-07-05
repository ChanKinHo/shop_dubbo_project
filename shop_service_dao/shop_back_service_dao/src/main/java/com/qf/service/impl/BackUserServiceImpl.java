package com.qf.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.BackUserMapper;
import com.qf.dao.BackUser_RoleMapper;
import com.qf.entity.BackUser;
import com.qf.entity.BackUser_Role;
import com.qf.service.IBackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Service
public class BackUserServiceImpl implements IBackUserService {

    @Autowired
    BackUserMapper backUserMapper;

    @Autowired
    BackUser_RoleMapper backUser_roleMapper;

    @Override
    public List<BackUser> listAllBackUser() {
        return backUserMapper.selectList(null);
    }

    @Override
    public int addBackUser(BackUser user) {
        return backUserMapper.insert(user);
    }

    @Override
    public int updateRole(Integer userid, Integer[] roleids) {

        //根据用户id先删除所有角色
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid",userid);
        backUser_roleMapper.delete(queryWrapper);

        //再进行选取角色的添加
        for (Integer roleid : roleids) {
            BackUser_Role backUser_role = new BackUser_Role(userid,roleid);
            backUser_roleMapper.insert(backUser_role);

        }
        return 1;
    }

//    @Override
//    public BackUser loginCheck(String username, String password) {
//
//        BackUser backUser = backUserMapper.loginCheck(username);
//
//        if (backUser != null && backUser.getPassword().equals(password)){
//            return backUser;
//        }
//
//        return null;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        BackUser backUser = backUserMapper.loginCheck(username);
        if (backUser == null){
            throw new UsernameNotFoundException("该用户不存在");
        }

        return backUser;
    }
}
