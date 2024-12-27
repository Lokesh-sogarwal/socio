package com.SocialMedia.Socialmedia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SocialMedia.Socialmedia.Repository.UserRepository;
import com.SocialMedia.Socialmedia.Repository.postRepository;
import com.SocialMedia.Socialmedia.entity.Post;
import com.SocialMedia.Socialmedia.entity.User;

@Controller
@RequestMapping("/addpost")
public class AddpostController {

    // Inject repositories using @Autowired
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private postRepository postRepository;

    // Endpoint to display the add post page (optional)
    @GetMapping
    public String showAddPostPage(@RequestParam("username") String username, Model model) {
        User user = userRepository.findByUsername(username); // Fetch user details
        if (user != null) {
            // Add user info to the model
            model.addAttribute("username", user.getUsername());
            model.addAttribute("followersCount", user.getFollowers_count());
            model.addAttribute("followingCount", user.getFollowing_count());
    
            // Fetch all posts (you can optimize this by filtering posts by user if needed)
            List<Post> posts = postRepository.findAll();
            model.addAttribute("posts", posts);
        } else {
            // If the user is not found, set default values
            model.addAttribute("username", "Unknown User");
            model.addAttribute("followersCount", 0);
            model.addAttribute("followingCount", 0);
        }
        return "addpost";  // Return the 'addpost' view (i.e., the form to create a post)
    }

    // Endpoint to handle the form submission and redirect to dashboard
    @GetMapping("/submit")
    public String submitPost(@RequestParam("username") String username, Model model) {
        // Here you can add logic to handle the submission of the post.
        
        // Redirect to the dashboard with the username (this is the redirect you were aiming for)
        return "redirect:/dashboard?username=" + username;
    }
}
