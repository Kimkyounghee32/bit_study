package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

public class HomeController {
	  	@GetMapping("/login")
	    public String home(Model model){
	        log.info("home controller");
	        return "login";
	    }
	 
	    @GetMapping("/user")
	    public String dispUser(Model model){
	        log.info("home controller");
	        return "/user/user";
	    }
	    @GetMapping("/emp")
	    public String dispManager(Model model){
	        log.info("home controller");
	        return "/user/emp";
	    }

}
