package com.hpp.dao;

import java.util.List;
import com.hpp.entities.Profile;

public interface ProfileDao {
    public List <Profile> getProfiles();

    public void saveProfile(Profile theProfile);

    public Profile getProfile(int theId);

    public void deleteProfile(int theId);
}