package com.hpp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/backend")
public class BackendController {

    @RequestMapping("/pay")
    public String test(@RequestParam(value="id") Integer id,@RequestParam(value="cId") Integer c_id,@RequestParam(value="amount") float amount, Model m) {
        m.addAttribute("id",id);
        m.addAttribute("cId",c_id);
        m.addAttribute("amount",amount);
        return "pay";
    }
}