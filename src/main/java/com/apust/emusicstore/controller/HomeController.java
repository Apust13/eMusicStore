package com.apust.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by GUN
 * on 31.05.2016.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam (value="logout",
    required = false) String loqout, Model model){

        if(error !=null){
            model.addAttribute("error", "Invalid username and password");
        }

        if(loqout!=null){
            model.addAttribute("msg", "You have been logged out successfully.");
        }

        return "login";
    }

}
