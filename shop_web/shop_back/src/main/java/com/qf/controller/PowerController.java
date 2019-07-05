package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Power;
import com.qf.service.IPowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/power")
public class PowerController {

    @Reference
    IPowerService powerService;

    @RequestMapping("/list")
    public String listAllPower(Model model){
        List<Power> powers = powerService.listAllPower();

        model.addAttribute("powers",powers);

        return "listPower";

    }

    @RequestMapping("/listAjax")
    @ResponseBody
    public List<Power> listAjax(Integer roleid){

        return powerService.queryAllByRid(roleid);
    }

    @RequestMapping("/addPower")
    public String addPower(Power power){

        powerService.addPower(power);

        return "redirect:/power/list";
    }
}
