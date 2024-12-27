package com.SocialMedia.Socialmedia.Repository;

import org.springframework.data.repository.CrudRepository;

import com.SocialMedia.Socialmedia.entity.User;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
