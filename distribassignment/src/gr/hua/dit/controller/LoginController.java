package gr.hua.dit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping("/login")
	   public String showLogin() {
	           return "login";
	   }
	
	@GetMapping("/homePage")
	public String showHomePage(){
		return "homePage";
	}
	
	@GetMapping("/logout")
	public String showLogout() {
		return "logout";
	}
	
	@GetMapping("/studentMenu")
	public String showStudent(){
		return "studentMenu";
	}
	
	@GetMapping("/adminMenu")
	public String showAdmin() {
		return "adminMenu";
	}
	
}
