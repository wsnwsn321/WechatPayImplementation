package com.hpp.controllers;

import com.hpp.wxpay_api.HttpRequest;
import com.hpp.wxpay_api.WXPayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @RequestMapping("/enroll")
    public Map enroll(@RequestParam(value="user_id") String id,@RequestParam(value="contest_id") String c_id) {
        Map<String, String> paraMap = new HashMap<String, String>();
        try{
            paraMap.put("user_id",id);
            paraMap.put("contest_id",c_id);
            String r = "user_id="+id+"&"+"contest_id="+c_id;
            String returned = HttpRequest.sendPost("http://yii.hpp.cn/api/enrollments", r);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return paraMap;
    }
}
