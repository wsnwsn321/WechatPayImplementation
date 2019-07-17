package com.hpp.service;

import com.hpp.dao.Wechat_usersDao;
import com.hpp.dao.WechatpayInfoDao;
import com.hpp.entities.WechatpayInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WechatpayInfoServiceImpl implements WechatpayInfoService {

    @Autowired
    private WechatpayInfoDao WechatpayInfoDao;

//    @Override
//    @Transactional
//    public String getTrade_no(int id) {
//        return WechatpayInfoDao.getTime(id);
//    }

    @Override
    @Transactional
    public String getTime(int id) {
        return WechatpayInfoDao.getTime(id);
    }

    @Override
    @Transactional
    public WechatpayInfo getOrderInfo(String trade_no) {
        return WechatpayInfoDao.getOrderInfo(trade_no);
    }

    @Override
    @Transactional
    public void savePay(WechatpayInfo thePay){
        WechatpayInfoDao.savePay(thePay);
    }

}