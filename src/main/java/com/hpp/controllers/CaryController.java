package com.hpp.controllers;

import java.util.List;

import com.hpp.entities.Profile;
import com.hpp.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/cary")
public class CaryController {

    @Autowired
    private ProfileService ProfileService;

    @GetMapping("/list")
    public String test(Model theModel) {
        List <Profile> theProfiles = ProfileService.getProfiles();
        theModel.addAttribute("profiles", theProfiles);
        return "cary-list";
    }
}