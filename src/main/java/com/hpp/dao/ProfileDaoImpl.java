package com.hpp.dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hpp.entities.Profile;

@Repository
public class ProfileDaoImpl implements ProfileDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <Profile> getProfiles() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery <Profile> cq = cb.createQuery(Profile.class);
        Root <Profile> root = cq.from(Profile.class);
        cq.orderBy(cb.desc(root.get("id")));
        cq.select(root);
        Query query = session.createQuery(cq);
        query.setFirstResult(0);
        query.setMaxResults(10);
        return query.getResultList();
    }

    @Override
    public void deleteProfile(int id) {
        Session session = sessionFactory.getCurrentSession();
        Profile book = session.byId(Profile.class).load(id);
        session.delete(book);
    }

    @Override
    public void saveProfile(Profile theProfile) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theProfile);
    }

    @Override
    public Profile getProfile(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Profile theCustomer = currentSession.get(Profile.class, theId);
        return theCustomer;
    }
}