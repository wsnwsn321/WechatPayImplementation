package com.hpp.controllers;


import com.hpp.entities.InputStreams;
import com.hpp.entities.WechatpayInfo;
import com.hpp.service.InputStreamService;
import com.hpp.service.WechatpayInfoService;
import com.hpp.wxpay_api.HttpRequest;
import com.hpp.wxpay_api.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/yap")
public class AfterpayController {
    final String paternerKey = "FeyW7Vw52I0I4HJsP7imtsq04dS7zYlR";
    @Autowired
    private InputStreamService iss;

    @Autowired
    private WechatpayInfoService wp;
    @RequestMapping("/after-pay")
    public String afterPay(HttpServletRequest request, HttpServletResponse response) {
        InputStream is = null;
        try {
            is = request.getInputStream();
            String xml = Inputstr2Str_Reader(is);

            Map<String, String> notifyMap = WXPayUtil.xmlToMap(xml);//将微信发的xml转map
            InputStreams i = new InputStreams();
            i.setString(xml);
            iss.saveStream(i);
            if (notifyMap.get("return_code").equals("SUCCESS")&&notifyMap.get("result_code").equals("SUCCESS")) {
                if(WXPayUtil.isSignatureValid(xml,paternerKey)){
                    response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>");
                    String trade_no = notifyMap.get("out_trade_no");
                    String time_end = notifyMap.get("time_end");
//                    time_end= time_end.substring(0,4)+"-"+
//                            time_end.substring(4,6)+"-"+time_end.substring(6,8)+" "
//                            +time_end.substring(8,10)+":"+time_end.substring(10,12)
//                            +":"+time_end.substring(12,14);
                    WechatpayInfo w = wp.getOrderInfo(trade_no);
                    w.setConfirm_pay(1);
                    w.setInputStreamId(i.getId());
                    wp.savePay(w);
                    String r = "user_id="+w.getUser_id()+"&"+"contest_id="+w.getContest_id();
                    String returned = HttpRequest.sendPost("http://yii.hpp.cn/api/enrollments", r);
                }

                is.close();
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String Inputstr2Str_Reader(InputStream in)
    {
        String str = "";
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuffer sb = new StringBuffer();

            while ((str = reader.readLine()) != null)
            {
                sb.append(str).append("\n");
            }
            return sb.toString();
        }
        catch (UnsupportedEncodingException e1)
        {
            e1.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }

}
