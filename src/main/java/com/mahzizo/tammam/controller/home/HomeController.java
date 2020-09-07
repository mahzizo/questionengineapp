package com.mahzizo.tammam.controller.home;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.ResourceAccessException;

import com.mahzizo.tammam.model.post.Post;
import com.mahzizo.tammam.model.user.User;
import com.mahzizo.tammam.service.json.JSONParsingService;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HomeController {
	
//	@Autowired
//	private UserService userService;

	@Autowired
	private JSONParsingService jsonParsingService;

	private static final String JSON_POST_URL = "https://jsonplaceholder.typicode.com/posts";
	
	private boolean isLogin;

	private User user;
	
	@PostConstruct
	public void init() {
		isLogin = false;
		user = new User();
	}
	
	@GetMapping("/home")
	public String getHomePage(Model tempModel, HttpServletRequest request) {
		isLogin = (boolean) request.getSession().getAttribute("isLogin");
		user = (User) request.getSession().getAttribute("user");
		System.out.println("\nuser.getEmail() : " + user.getEmail() + "\n");
//		System.out.println("\nuser.getUserDetail().getMobileNumber() : " + user.getUserDetail().getMobileNumber() + "\n");
		if (user.getEmail() == null || isLogin == false) {
			return "redirect:/login";
		} else {
			try {
				@SuppressWarnings("unchecked")
				List<Post> posts = (List<Post>) jsonParsingService.parse(JSON_POST_URL);
				tempModel.addAttribute("posts", posts);
			} catch (ResourceAccessException e) {
				tempModel.addAttribute("posts", null);
			}
			return "home-page";
		}
	}	
	
	
}
