package com.hpp.dao;

import com.hpp.entities.WechatpayInfo;

public interface WechatpayInfoDao {
    public String getTime(int id);


    public WechatpayInfo getOrderInfo(String trade_no);

    public void savePay(WechatpayInfo thePay);

}