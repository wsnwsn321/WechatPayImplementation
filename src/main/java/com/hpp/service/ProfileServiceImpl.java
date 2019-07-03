package com.hpp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hpp.dao.ProfileDao;
import com.hpp.entities.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDao ProfileDao;

    @Override
    @Transactional
    public List <Profile> getProfiles() {
        return ProfileDao.getProfiles();
    }

    @Override
    @Transactional
    public void saveProfile(Profile theProfile) {
        ProfileDao.saveProfile(theProfile);
    }

    @Override
    @Transactional
    public Profile getProfile(int theId) {
        return ProfileDao.getProfile(theId);
    }

    @Override
    @Transactional
    public void deleteProfile(int theId) {
        ProfileDao.deleteProfile(theId);
    }
}