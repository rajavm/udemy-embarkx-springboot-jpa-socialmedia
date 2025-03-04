package com.social.media.repositories;

import com.social.media.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRespository  extends JpaRepository<Post,Long> {
}
