package com.hpp.service;

import com.hpp.dao.Wechat_usersDao;
import com.hpp.entities.Wechat_users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Wechat_usersServiceImpl implements Wechat_usersService {

    @Autowired
    private Wechat_usersDao Wechat_usersDao;

    @Override
    @Transactional
    public String getOpenid(int userId) {
        return Wechat_usersDao.getOpenid(userId);
    }

}