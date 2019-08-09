package com.newer.petmall;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model m) {
		
		//访问首页 欢迎页面
		return "home";
	}
	
	@GetMapping("/login")
	public String login(Model m,HttpServletRequest req,String info) {
		m.addAttribute("info", info );
		m.addAttribute("loginfo", "loginfo...");
		return "login";
		
	}
}
