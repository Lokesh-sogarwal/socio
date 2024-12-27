package com.SocialMedia.Socialmedia.service;
import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SocialMedia.Socialmedia.Repository.postRepository;
import com.SocialMedia.Socialmedia.entity.Post;

@Service
public class PostService {

    @Autowired
    private postRepository postRepository;

    public void createPost(MultipartFile photo, String caption) throws IOException {
        Post post = new Post();
        post.setCaption(caption);
        post.setImage(encodeImageToBase64(photo));
        postRepository.save(post);
    }

    private String encodeImageToBase64(MultipartFile photo) throws IOException {
        byte[] imageBytes = photo.getBytes();
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
