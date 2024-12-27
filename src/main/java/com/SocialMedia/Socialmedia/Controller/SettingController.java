package com.SocialMedia.Socialmedia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SocialMedia.Socialmedia.Repository.UserRepository;
import com.SocialMedia.Socialmedia.entity.User;

@Controller
@RequestMapping("/setting")
public class SettingController {
    // Inject repositories using @Autowired
    @Autowired
    private UserRepository userRepository;

    // Endpoint to display the add post page (optional)
    @GetMapping
    public String showNotificationPage(@RequestParam("username") String username, Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            // Add user info to the model
            model.addAttribute("username", user.getUsername());
            model.addAttribute("followersCount", user.getFollowers_count());
            model.addAttribute("followingCount", user.getFollowing_count());
        } else {
            // If the user is not found, set default values
            model.addAttribute("username", "Unknown User");
            model.addAttribute("followersCount", 0);
            model.addAttribute("followingCount", 0);
        }
        return "setting";
    }
}    