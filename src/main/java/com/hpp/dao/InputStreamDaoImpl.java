package com.hpp.dao;

import com.hpp.entities.InputStreams;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class InputStreamDaoImpl implements InputStreamDao{


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveStream(InputStreams stream){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(stream);
    }

}