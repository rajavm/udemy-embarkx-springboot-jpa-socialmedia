package com.social.media.service;

import com.social.media.models.SocialUser;
import com.social.media.repositories.SocialUserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    @Autowired
    private SocialUserRespository socialUserRespository;

    public List<SocialUser> getAllUsers(){
        return socialUserRespository.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRespository.save(socialUser);
    }
}
