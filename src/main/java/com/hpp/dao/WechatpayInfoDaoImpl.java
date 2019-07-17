package com.hpp.dao;

import com.hpp.entities.WechatpayInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class WechatpayInfoDaoImpl implements WechatpayInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String getTime(int id) {
        Session session = sessionFactory.getCurrentSession();
        WechatpayInfo transaction = session.get(WechatpayInfo.class, id);
        return transaction.getTime();
    }



    @Override
    public void savePay(WechatpayInfo thePay){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(thePay);
    }

    @Override
    public WechatpayInfo getOrderInfo(String trade_no){
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<WechatpayInfo> cq = cb.createQuery(WechatpayInfo.class);
        Root<WechatpayInfo> root = cq.from(WechatpayInfo.class);
        cq.select(root).where(root.get("out_trade_no").in(trade_no));
        WechatpayInfo theOrder = currentSession.createQuery(cq).getSingleResult();

        return theOrder;
    }

}