package com.SocialMedia.Socialmedia.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SocialMedia.Socialmedia.Repository.UserRepository;
import com.SocialMedia.Socialmedia.entity.User;

@Controller
public class LoginController {

    private final UserRepository userRepository; // Inject the UserRepository

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository; // Initialize the repository
    }

    @GetMapping("/")
    public String loginPage() {
        return "index";  // Renders the login.html page
    }

    @PostMapping("/login") // Use POST for login submissions
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        
        // Check if the user exists in the database (pseudo code, adjust according to your UserRepository methods)
        User user = userRepository.findByUsername(username); // Adjust the method as per your repository
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/dashboard?username=" + username;
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "index";
        }
    }
}
