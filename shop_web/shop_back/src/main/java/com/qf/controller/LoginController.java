package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.BackUser;
import com.qf.service.IBackUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
//@SessionAttributes("backUser")
public class LoginController {

    @Reference
    IBackUserService backUserService;

    @RequestMapping("/toLogin")
    public String loginPage(){

        return "login";
    }

//    @RequestMapping("/loginCheck")
//    public String loginCheck(String username, String password, HttpSession session){
//
//        BackUser backUser = backUserService.loginCheck(username, password);
//
//        if (backUser != null){
//
//            session.setAttribute("User",backUser);
//
//            System.out.println(backUser);
//
//            return "index";
//        }
//
//        return "redirect:/toLogin?error=1";
//    }
}
