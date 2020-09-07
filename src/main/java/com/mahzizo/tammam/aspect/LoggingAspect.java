package com.mahzizo.tammam.aspect;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.mahzizo.tammam.model.user.User;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(public String getLoginPage(..))")
	private void forLoginController() {	}
	
	@Pointcut("execution(public String getRegisterPage(..))")
	private void forRegisterController() {	}
	
	@Pointcut("execution(public String getRegisterPage(..))")
	private void forHomeController() {	}
	
	@Pointcut("execution(public String getProfilePage(..))")
	private void forProfileController() {	}
	
//	@Before("forLoginController() || forRegisterController() || forHomeController() || forProfileController()")
//	public void beforeLogin(JoinPoint joinPoint) {
//		Object[] args = joinPoint.getArgs();
//		for(Object tempArg:args) {
//			if(tempArg instanceof HttpServletRequest) {
//				HttpServletRequest request =  (HttpServletRequest) tempArg;
//				if(request.getSession().getAttribute("user") == null) {
//					request.getSession().setAttribute("user", new User());
//				}
//				if(request.getSession().getAttribute("isLogin") == null) {
//					request.getSession().setAttribute("isLogin", false);
//				}
//			}
//		}		
//	}
	
	
	
	
	@Before("forLoginController() || forRegisterController() || forHomeController() || forProfileController()")
	public void beforeLogin(JoinPoint joinPoint) {
		
		System.out.println("\nIm Before\n");
		
		Object[] args = joinPoint.getArgs();
		for(Object tempArg:args) {
			if(tempArg instanceof HttpServletRequest) {
				HttpServletRequest request =  (HttpServletRequest) tempArg;
				System.out.println("\ntempArg instanceof HttpServletRequest " + request.getAttributeNames().toString() + "\n");				
				Enumeration<String> attrs =  request.getSession().getAttributeNames();
				while(attrs.hasMoreElements()) {
				    System.out.println(attrs.nextElement());
				}
				
				try {
					System.out.println((User)request.getSession().getAttribute("user"));
					System.out.println((boolean)request.getSession().getAttribute("isLogin"));
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				
				if(request.getSession().getAttribute("user") == null) {
					request.getSession().setAttribute("user", new User());
					System.out.println("\request.getSession().setAttribute(\"user\", User.getInstance())\n");
				}
				if(request.getSession().getAttribute("isLogin") == null) {
					request.getSession().setAttribute("isLogin", false);
					System.out.println("\nrequest.getSession().setAttribute(\"isLogin\", false)\n");
				}
			}
		}
		
	}
	
			
}
