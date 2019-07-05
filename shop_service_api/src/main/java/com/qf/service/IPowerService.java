package com.qf.service;

import com.qf.entity.Power;

import java.util.List;

public interface IPowerService {

    public List<Power> listAllPower();

    public int addPower(Power power);

    List<Power> queryAllByRid(Integer roleid);
}
