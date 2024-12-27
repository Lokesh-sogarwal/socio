package com.SocialMedia.Socialmedia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SocialMedia.Socialmedia.entity.Post;

@Repository
public interface postRepository extends JpaRepository<Post, Long> {
    Post findByPostId(String postId);
}
