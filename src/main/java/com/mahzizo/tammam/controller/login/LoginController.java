package com.mahzizo.tammam.controller.login;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mahzizo.tammam.model.user.User;
import com.mahzizo.tammam.service.user.UserService;;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginController {

	private boolean isLogin;
	
	private User user;
	
	@Autowired
	private UserService userService;

	@PostConstruct
	public void init() {
		isLogin = false;
		user = new User();
	}

	@GetMapping("/login")
	public String getLoginPage(Model tempModel, HttpServletResponse response, HttpServletRequest request) {
		isLogin = (boolean) request.getSession().getAttribute("isLogin");
		user = (User) request.getSession().getAttribute("user");
		if(isLogin == false) {
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			tempModel.addAttribute("tempUser", user);
			return "login-page";
		} else {
			return "redirect:/home";
		}
	}
	
	@PostMapping("/home")
	public String toHomePage(@ModelAttribute("tempUser") User tempUser, Model tempModel, HttpServletRequest request) {
		user = userService.getUser(tempUser.getEmail(), tempUser.getPassword());
		if (user == null) {
			user = new User();
			request.getSession().setAttribute("user", user);
			return "redirect:/login";
		} else {
			isLogin = true;
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("isLogin", isLogin);
			return "redirect:/home";
		}
	}
	
}
