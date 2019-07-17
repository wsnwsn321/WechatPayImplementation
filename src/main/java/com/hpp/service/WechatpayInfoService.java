package com.hpp.service;

import com.hpp.entities.WechatpayInfo;

public interface WechatpayInfoService {

    public String getTime(int id);

    //public String getTrade_no(int id);

    public WechatpayInfo getOrderInfo(String trade_no);


    public void savePay(WechatpayInfo thePay);
}