package com.qf.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.PowerMapper;
import com.qf.entity.Power;
import com.qf.service.IPowerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PowerServiceImpl implements IPowerService {

    @Autowired
    PowerMapper powerMapper;

    @Override
    public List<Power> listAllPower() {
        return powerMapper.queryAllPower();
    }

    @Override
    public int addPower(Power power) {
        return powerMapper.insert(power);
    }

    @Override
    public List<Power> queryAllByRid(Integer roleid) {
        return powerMapper.queryAllByRid(roleid);
    }
}
