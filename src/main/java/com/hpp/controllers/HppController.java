package com.hpp.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.hpp.entities.Profile;
import com.hpp.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hpp.dto.HppDto;

@RestController
@RequestMapping("/hpp")
public class HppController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final HashMap data = new HashMap<Integer, String>();

    @Autowired
    private ProfileService ProfileService;

    @RequestMapping("/test")
    public ArrayList<HppDto> test(@RequestParam(value="id", defaultValue="1") Integer id) {
        data.put(1, "Example_1");
        data.put(2, "Example_2");
        data.put(3, "Example_3");

        ArrayList r = new ArrayList<HppDto>();

//        data.forEach((k, v) -> {
//            HppDto t = new HppDto();
//            t.setId((Integer) k);
//            t.setName((String) v);
//            r.add(t);
//        });

        return r;
    }

    @RequestMapping("/profile")
    public Profile profile(
            @RequestParam(
                    value="id",
                    defaultValue="1"
            ) Integer id)
    {
        Profile p = ProfileService.getProfile(id);
        return p;
    }
}