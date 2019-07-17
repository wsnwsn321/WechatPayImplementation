package com.hpp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import com.hpp.entities.Wechat_users;

@Repository
public class Wechat_usersDaoImpl implements Wechat_usersDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String getOpenid(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Wechat_users theOpenid = session.get(Wechat_users.class, userId);
        return theOpenid.getOpenid();
    }

}