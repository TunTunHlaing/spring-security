package com.demo.security.first_demo.api;

import com.demo.security.first_demo.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashboardController {

    @Autowired
    private JwtUtils jwtUtils;


    @GetMapping("/dashboard")
    public String dashboard(Model model, @AuthenticationPrincipal OAuth2User user) {
        model.addAttribute("name", user.getAttribute("name"));
        model.addAttribute("email", user.getAttribute("email"));
        return "dashboard";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String test() {
        return "Hello From Demo Security App.";
    }

    @ResponseBody
    @GetMapping("/hi")
    public String test1() {
        return "Hi From Demo Security App.";
    }


}
