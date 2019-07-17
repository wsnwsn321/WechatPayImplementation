package com.hpp.service;

import com.hpp.dao.ContestPaidUserDao;
import com.hpp.entities.ContestPaidUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContestPaidUserServiceImpl implements ContestPaidUserService {

    @Autowired
    private ContestPaidUserDao ContestPaidUserDao;

    @Override
    @Transactional
    public void savePaidUser(ContestPaidUser user){
        ContestPaidUserDao.savePaidUser(user);
    }

}