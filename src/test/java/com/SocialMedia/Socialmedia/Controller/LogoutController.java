package com.SocialMedia.Socialmedia.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logoutGet(HttpServletRequest request, HttpServletResponse response) {
        // Handle GET requests to /logout (optional, for direct link logout)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout"; // Redirect to login page with logout message
    }

    @PostMapping("/logout") // Recommended approach
    public String logoutPost(HttpServletRequest request, HttpServletResponse response) {
        // Handle POST requests to /logout (more secure)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout"; // Redirect to login page with logout message
    }

    // Optional: Customize logout success URL
    // You can configure the logout success URL directly in Spring Security configuration as well.
    // This method shows how to do it with a dedicated controller method.
    @GetMapping("/logoutSuccess")
    public String logoutSuccess() {
        return "redirect:/login?logoutSuccess"; // Redirect to login page with a different message
    }

}