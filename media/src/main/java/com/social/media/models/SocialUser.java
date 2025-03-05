package com.social.media.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user",cascade = {CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE})
    private SocialProfile socialProfile;

    @OneToMany(mappedBy="socialUser",cascade = {CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE})
    List<Post> posts = new ArrayList<>();

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name="user_group",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="group_id")
    )
    Set<SocialGroup> groups = new HashSet<>();

    public void setSocialProfile(SocialProfile socialProfile){
        this.socialProfile=socialProfile;
        if(socialProfile.getUser()!=this)
            socialProfile.setUser(this);

    }
}
