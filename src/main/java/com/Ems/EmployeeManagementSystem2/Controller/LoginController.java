package com.Ems.EmployeeManagementSystem2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin() {
        // Your login logic goes here

        // Redirect to the dashboard after successful login
        return "redirect:/dashboard";
    }

}
