package com.hpp.controllers;


import com.hpp.entities.InputStreams;
import com.hpp.entities.WechatpayInfo;
import com.hpp.service.InputStreamService;
import com.hpp.service.Wechat_usersService;
import com.hpp.service.WechatpayInfoService;
import com.hpp.wxpay_api.HttpRequest;
import com.hpp.wxpay_api.WXPayUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/wechatpay")
public class WxpayController {
    final String appid ="wx34d2a4a35cecab5d";
    final String secret = "211a1a8c1decba1b054ef4a33eb3c43b";
    final String mch_id = "1543296011";
    final String paternerKey = "FeyW7Vw52I0I4HJsP7imtsq04dS7zYlR";
    final String body = "hpp_pay";
    private Map<String, String> paraMap = new HashMap<String, String>();
    @Autowired
    private Wechat_usersService w;
    @Autowired
    private WechatpayInfoService wp;
    @Autowired
    private InputStreamService iss;


    @RequestMapping(value="orders", method = RequestMethod.GET)
    @ResponseBody
    public Map orders(HttpServletRequest request, ModelMap retMap) {
        try {
            String opId = w.getOpenid(Integer.parseInt(request.getParameter("id")));
            String trade_no = UUID.randomUUID().toString().replaceAll("-", "");
            String ip = getLocalIp(request);
            paraMap.put("appid", appid);
            paraMap.put("body",body);
            paraMap.put("mch_id", mch_id);
            String nonce_str = WXPayUtil.generateNonceStr();
            paraMap.put("nonce_str", nonce_str);
            paraMap.put("openid", opId);
            paraMap.put("out_trade_no", trade_no);//订单号
            paraMap.put("spbill_create_ip", ip);
            paraMap.put("total_fee", "1");
            paraMap.put("trade_type", "JSAPI");
            paraMap.put("notify_url", "http://wp.happypingpang.com:8080/yap/after-pay");// 此路径是微信服务器调用支付结果通知路径随意写
            String sign = WXPayUtil.generateSignature(paraMap, paternerKey);
            paraMap.put("sign", sign);
            String xml = WXPayUtil.mapToXml(paraMap);
            String unifiedorder_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
            String xmlStr = HttpRequest.sendPost(unifiedorder_url, xml);
            System.out.println(xmlStr);
            //以下内容是返回前端页面的json数据
            String prepay_id = "";//预支付id
            if (xmlStr.indexOf("SUCCESS") != -1) {
                Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
                prepay_id = (String) map.get("prepay_id");
            }
            Map<String, String> payMap = new HashMap<String, String>();
            payMap.put("appId", appid);
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeStamp = df.format(date);
            //String timeStamp = WXPayUtil.getCurrentTimestamp()+"";
            payMap.put("timeStamp",timeStamp);
            String return_nonce_str = WXPayUtil.generateNonceStr();
            payMap.put("nonceStr",return_nonce_str );
            payMap.put("signType", "MD5");
            payMap.put("package", "prepay_id=" + prepay_id);
            String paySign = WXPayUtil.generateSignature(payMap, paternerKey);
            payMap.put("paySign", paySign);
            WechatpayInfo wi = new WechatpayInfo();
            wi.setApp_id(appid);
            wi.setMch_id(mch_id);
            wi.setNonce_str(nonce_str);
            wi.setSign(sign);
            wi.setBody(body);
            wi.setOut_trade_no(trade_no);
            wi.setIp(ip);
            wi.setNotify_url("http://wp.happypingpang.com:8080/yap/after-pay");
            wi.setTrade_type("JSAPI");
            wi.setOpen_id(opId);
            wi.setTime(timeStamp);
            wi.setReturn_nonce_str(return_nonce_str);
            wi.setPkg(prepay_id);
            wi.setSignType("MD5");
            wi.setPay_sign(paySign);
            wi.setUser_id(Integer.parseInt(request.getParameter("id")));
            wi.setContest_id(Integer.parseInt(request.getParameter("cId")));
            wi.setFee(Float.parseFloat(request.getParameter("amount"))*100.0f);
            wp.savePay(wi);
            return payMap;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static String getLocalIp(HttpServletRequest request) {
        if (request == null)
            return null;
        String s = request.getHeader("X-Forwarded-For");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = request.getHeader("Proxy-Client-IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = request.getHeader("WL-Proxy-Client-IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = request.getHeader("HTTP_CLIENT_IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = request.getRemoteAddr();
        if ("127.0.0.1".equals(s) || "0:0:0:0:0:0:0:1".equals(s))
            try {
                s = InetAddress.getLocalHost().getHostAddress();
            }
            catch (UnknownHostException unknownhostexception) {
            }
        return s;
    }
    private static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }
    public Map getParam(){
        return paraMap;
    }
}
