package com.mahzizo.tammam.controller.register;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mahzizo.tammam.model.user.User;
import com.mahzizo.tammam.model.user.UserBuilder;
import com.mahzizo.tammam.model.user.UserBuilderImpl;
import com.mahzizo.tammam.service.user.UserService;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RegisterController {

	private boolean isLogin;

	private User user;

	UserBuilder userBuilder;

	@Autowired
	private UserService UserService;

	@PostConstruct
	public void init() {
		userBuilder = new UserBuilderImpl();
		isLogin = false;
		user = new User();
	}

	@GetMapping("/register")
	public String getRegisterPage(Model model, HttpServletRequest request, HttpServletResponse response) {
		isLogin = (boolean) request.getSession().getAttribute("isLogin");
		if (isLogin == false) {
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			model.addAttribute("userBuilder", userBuilder);
			return "register-page";
		} else {
			return "redirect:/home";
		}

	}

	@PostMapping("/addUser")
	public String addUser(@Valid @ModelAttribute("userBuilder") UserBuilderImpl userBuilder,
			BindingResult bindingResult, HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			System.out.println("\nInside RegisterContoller ==> bindingResult.hasErrors()\n");
			return "redirect:/register";
		} else {
			System.out.println("\nFirst Name: " + userBuilder.getFirstName() + "\n" + "last Name: "
					+ userBuilder.getLastName() + "\n" + "Email: " + userBuilder.getEmail() + "\n" + "password: "
					+ userBuilder.getPassword() + "\n\n");

			// save object in db
			user = userBuilder.buildFirstName().buildLastName().bulidEmail().buildPassword().getUser();
			user.setUserDetail(null);
			System.out.println("\n\n" + "ID: " + user.getId() + "\n" + "First Name: " + user.getFirstName() + "\n"
					+ "last Name: " + user.getLastName() + "\n" + "Email: " + user.getEmail() + "\n" + "password: "
					+ user.getPassword() + "\n" + "UserDetail: " + user.getUserDetail() + "\n\n");
			UserService.saveOrUpdateUser(user);
			request.getSession().setAttribute("user", user);

			// set isLogin equal true;
			request.getSession().setAttribute("isLogin", true);

			return "redirect:/home";
		}
	}

}
