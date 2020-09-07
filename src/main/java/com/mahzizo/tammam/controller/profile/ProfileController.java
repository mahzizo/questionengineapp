package com.mahzizo.tammam.controller.profile;

import java.io.IOException;
import java.sql.Blob;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mahzizo.tammam.helper.HelperMethods;
import com.mahzizo.tammam.model.user.User;
import com.mahzizo.tammam.model.userdetail.UserDetail;
import com.mahzizo.tammam.service.user.UserService;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@MultipartConfig(maxFileSize = 16177215)
public class ProfileController {

	@Autowired
	private UserService userService;

	@Autowired
	private EntityManagerFactory emf;

	private boolean isLogin;

	private User user;

	@PostConstruct
	public void init() {
		isLogin = false;
		user = new User();
	}

	@GetMapping("/profile")
	public String getProfilePage(Model theModel, HttpServletRequest request, HttpServletResponse response) {
		isLogin = (boolean) request.getSession().getAttribute("isLogin");
		user = (User) request.getSession().getAttribute("user");
		if (user.getEmail() == null || isLogin == false) {
			return "redirect:/login";
		} else {
			if (user.getUserDetail() == null) {
				user.setUserDetail(new UserDetail());
			}
			if (user.getUserDetail().getStrImg() == null) {
				user.getUserDetail().setStrImg(HelperMethods.getStringImage(user.getUserDetail().getProfilePicture()));
			}
			theModel.addAttribute("user", user);
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//			String imgStr = HelperMethods.getStringImage(user.getUserDetail().getProfilePicture());
//			request.setAttribute("photo", imgStr);
			request.setAttribute("photo", user.getUserDetail().getStrImg());
			return "profile-page";
		}
	}

	@GetMapping("/edit-profile")
	public String getEditProfilePage(Model theModel, HttpServletRequest request) {
		isLogin = (boolean) request.getSession().getAttribute("isLogin");
		user = (User) request.getSession().getAttribute("user");
		if (user.getEmail() == null || isLogin == false) {
			return "redirect:/login";
		} else {
			if (user.getUserDetail() == null) {
				user.setUserDetail(new UserDetail());
			}
			if (user.getUserDetail().getStrImg() == null) {
				user.getUserDetail().setStrImg(HelperMethods.getStringImage(user.getUserDetail().getProfilePicture()));
			}
			theModel.addAttribute("user", user);
//			String imgStr = HelperMethods.getStringImage(user.getUserDetail().getProfilePicture());
//			request.setAttribute("photo", imgStr);
			request.setAttribute("photo", user.getUserDetail().getStrImg());
			return "edit-profile-page";
		}
	}

	@PostMapping("/update")
	public String updateProfile(@RequestParam("profile-photo-file") MultipartFile imageFile, HttpServletRequest request) {
		try {
			if (imageFile != null) {
				EntityManager em = emf.createEntityManager();
				Session session = (Session) em.getDelegate();
				Blob blob = Hibernate.getLobCreator(session).createBlob(imageFile.getInputStream(), imageFile.getSize());
				user.getUserDetail().setProfilePicture(blob);
				// momkn hna n3ml column fl database table we n7ot feh al String Image
				user.getUserDetail().setStrImg(HelperMethods.getBase64Encoded(imageFile));
//	            System.out.println("\n" + imageFile.getName() + "\n");
//	            System.out.println("\n" + imageFile.getOriginalFilename() + "\n");
//	            System.out.println("\n" + imageFile.getSize() + "\n");
//	            System.out.println("\n" + imageFile.getContentType() + "\n");
//	            System.out.println("\n" + imageFile.getInputStream() + "\n");
//				System.out.println("\nuser.getUserDetail().gettStrImg() : " + user.getUserDetail().getStrImg() + "\n");
				userService.saveOrUpdateUser(user);
				request.getSession().setAttribute("user", user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/profile";
	}

//	@PostMapping("/saveImage")
//	public String saveImage(@RequestParam("photo") MultipartFile imageFile) throws IOException, ServletException {
//		System.out.println("enter save image");
//		try {
//			if (imageFile != null) {
//	            // prints out some information for debugging
//	            System.out.println(imageFile.getName());
//	            System.out.println(imageFile.getOriginalFilename());
//	            System.out.println(imageFile.getSize());
//	            System.out.println(imageFile.getContentType());
//	            System.out.println(imageFile.getInputStream());
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return "redirect:/profile";
//	}

//	@PostMapping("/saveImage")
//	public String saveImage(HttpServletRequest request) throws IOException, ServletException {
//		Part filePart = request.getPart("photo");
//		if (filePart != null) {
//            // prints out some information for debugging
//            System.out.println(filePart.getName());
//            System.out.println(filePart.getSize());
//            System.out.println(filePart.getContentType());
//		}
//		return "redirect:/profile";
//	}

}
