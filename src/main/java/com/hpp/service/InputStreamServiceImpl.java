package com.hpp.service;

import com.hpp.dao.InputStreamDao;
import com.hpp.entities.InputStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InputStreamServiceImpl implements InputStreamService {

    @Autowired
    private InputStreamDao InputStreamDao;

    @Override
    @Transactional
    public void saveStream (InputStreams stream){
        InputStreamDao.saveStream(stream);
    }

}