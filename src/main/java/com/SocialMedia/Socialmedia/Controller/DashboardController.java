package com.SocialMedia.Socialmedia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SocialMedia.Socialmedia.Repository.UserRepository;
import com.SocialMedia.Socialmedia.Repository.postRepository;
import com.SocialMedia.Socialmedia.entity.Post;
import com.SocialMedia.Socialmedia.entity.User;

@Controller
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private postRepository postRepository;

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam("username") String username, Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("followersCount", user.getFollowers_count());
            model.addAttribute("followingCount", user.getFollowing_count());
    
            List<Post> posts = postRepository.findAll();
            model.addAttribute("posts", posts);
        } else {
            model.addAttribute("username", "Unknown User");
            model.addAttribute("followersCount", 0);
            model.addAttribute("followingCount", 0);
        }
        return "dashboard";
    }
    

    @PostMapping("/createPost")
    public String createPost(@RequestParam("username") String username,
                             @RequestParam("content") String content,
                             @RequestParam("mediaurl") String mediaurl, Model model) {
        
        // Fetch the user by username
        User user = userRepository.findByUsername(username);
        
        if (user != null) {
            // Create a new post for the user
            Post newPost = new Post();
            newPost.setUser(user);
            newPost.setCaption(content);
            newPost.setImage(content);
            newPost.setLikesCount(0);
            newPost.setCommentsCount(0);
            
            postRepository.save(newPost);
            model.addAttribute("message", "Post created successfully!");

        } else {
            model.addAttribute("message", "User not found!");
        }
        
        return "redirect:/dashboard?username=" + username;
    }
}
