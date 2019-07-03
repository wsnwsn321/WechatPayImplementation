package com.hpp.service;

import java.util.List;
import com.hpp.entities.Profile;

public interface ProfileService {

    public List <Profile> getProfiles();

    public void saveProfile(Profile theProfile);

    public Profile getProfile(int theId);

    public void deleteProfile(int theId);

}