package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Role;
import com.qf.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Reference
    IRoleService roleService;

    @RequestMapping("/list")
    public String listAllRole(Model model){

        List<Role> roles = roleService.listAllRole();

        model.addAttribute("roles",roles);
        return "listRole";
    }

    @RequestMapping("/addRole")
    public String addRole(Role role){

        roleService.addRole(role);
        return "redirect:/role/list";
    }

    @RequestMapping("/listAjax")
    @ResponseBody
    public List<Role> listAjax(Integer userid){

        return roleService.queryRoleByUid(userid);
    }

    @RequestMapping("/updateRolePower")
    @ResponseBody
    public String updateRolePower(Integer roleid, @RequestParam("pids[]") Integer[] pids ){

        //System.out.println(roleid+"---"+ Arrays.toString(pids));

        roleService.updateRolePower(roleid,pids);

        return "success";
    }
}
