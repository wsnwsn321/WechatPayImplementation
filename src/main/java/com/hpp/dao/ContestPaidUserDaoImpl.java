package com.hpp.dao;

import com.hpp.entities.ContestPaidUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ContestPaidUserDaoImpl implements ContestPaidUserDao{


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void savePaidUser(ContestPaidUser user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

}