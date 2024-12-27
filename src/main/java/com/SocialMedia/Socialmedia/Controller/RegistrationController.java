package com.SocialMedia.Socialmedia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SocialMedia.Socialmedia.Repository.UserRepository;
import com.SocialMedia.Socialmedia.entity.User;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String firstname,
                               @RequestParam String lastname,
                               @RequestParam String username,
                               @RequestParam long mobileno,
                               @RequestParam String email,
                               @RequestParam String country,
                               @RequestParam String city,
                               @RequestParam String password,
                               @RequestParam String confirmpassword) {

        // Optionally, you can add password validation or user existence checks here

        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setMobileno(mobileno);
        user.setEmail(email);
        user.setCountry(country);
        user.setCity(city);
        user.setPassword(password); // Consider hashing the password before saving
        // user.setConfirmpassword(confirmpassword);
        userRepository.save(user); // Save user to the database

        return "redirect:/"; // Redirect to the home page or a success page
    }
} 