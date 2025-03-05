package com.social.media.service;

import com.social.media.models.SocialUser;
import com.social.media.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    @Autowired
    private SocialUserRepository socialUserRespository;

    public List<SocialUser> getAllUsers(){
        return socialUserRespository.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRespository.save(socialUser);
    }

    public SocialUser deleteUser(Long id) {
        SocialUser socialUser=socialUserRespository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));

        socialUserRespository.delete(socialUser);
        return socialUser;
    }
}
