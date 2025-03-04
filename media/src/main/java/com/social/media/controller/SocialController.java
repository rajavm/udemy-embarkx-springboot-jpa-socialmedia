package com.social.media.controller;

import com.social.media.models.SocialUser;
import com.social.media.service.SocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialController {
    private final SocialService socialService;

    public SocialController(SocialService socialService) {
        this.socialService = socialService;
    }
    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getAllUsers());
    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(socialService.saveUser(socialUser));
    }
}
