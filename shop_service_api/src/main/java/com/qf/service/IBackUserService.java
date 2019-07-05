package com.qf.service;

import com.qf.entity.BackUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IBackUserService extends UserDetailsService {

    public List<BackUser> listAllBackUser();

    public int addBackUser(BackUser user);

    public int updateRole(Integer userid,Integer[] roleids);

}
