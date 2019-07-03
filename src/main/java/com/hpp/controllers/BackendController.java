package com.hpp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;

@Controller
@RequestMapping("/backend")
public class BackendController {

    @RequestMapping("/test")
    public String test(ModelMap map) {
        map.put("thText", "设置文本内容");
        map.put("thUText", "设置文本内容");
        map.put("thValue", "设置当前元素的value值");
        map.put("thEach", Arrays.asList("列表", "遍历列表"));
        map.put("thIf", "msg is not null");
        //ap.put("thObject", new UserEntity("sadfa","asfasfd","asfsaf","asdfasf","saf","asfd","sadf",1));

        return "list";
    }
}