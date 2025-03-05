package com.social.media.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="socialuser")
    @JsonIgnore
    private SocialUser user;

    private String description;

    public void setUser(SocialUser user){
        this.user=user;
        if(user.getSocialProfile()!=this)
            user.setSocialProfile(this);
    }
}
