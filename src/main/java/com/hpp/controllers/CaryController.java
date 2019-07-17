package com.hpp.controllers;

import java.util.List;


import com.hpp.entities.Profile;
import com.hpp.service.ProfileService;
import com.hpp.service.Wechat_usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/cary")
public class CaryController {

    @Autowired
    private ProfileService ProfileService;
    @Autowired
    private Wechat_usersService w;


    @GetMapping("/list")
    public String test(@RequestParam(value="id") Integer id,Model theModel) {
        List <Profile> theProfiles = ProfileService.getProfiles();
        theModel.addAttribute("profiles", theProfiles);
        String openId = w.getOpenid(id);
        theModel.addAttribute("openid",openId);
        return "cary-list";
    }
}