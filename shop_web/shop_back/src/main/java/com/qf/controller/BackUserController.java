package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.BackUser;
import com.qf.service.IBackUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/backUser")
public class BackUserController {

    @Reference
    IBackUserService backUserService;

    @RequestMapping("/list")
    public String listAllBackUser(Model model){

        List<BackUser> backUsers = backUserService.listAllBackUser();

        model.addAttribute("backUsers",backUsers);

        return "back_user";
    }

    @RequestMapping("/addBack")
    public String addBackUser(BackUser backUser){

        backUserService.addBackUser(backUser);

        return "redirect:/backUser/list";
    }

    @RequestMapping("/updateRole")
    public String updateRole(Integer userid, Integer[] roleids){

        //System.out.println(userid+"---"+ Arrays.toString(roleids));
            backUserService.updateRole(userid,roleids);
        return "redirect:/backUser/list";
    }
}
