package com.mahzizo.tammam.helper;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.mahzizo.tammam.model.user.User;

public class HelperMethods {
	
//	private static byte[] imageData;
//	private static byte[] imageData1;
	
	@Autowired
	private static EntityManagerFactory emf;
	
	public static User getUser(HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		if(user == null) {
			request.getSession().setAttribute("user", new User());
		}
		return user;
	}
	
	public static boolean getIsLogin(HttpServletRequest request) {
		boolean isLogin = (boolean) request.getSession().getAttribute("isLogin");
		if(request.getSession().getAttribute("isLogin") == null) {
			request.getSession().setAttribute("isLogin", false);
		}
		return isLogin;
	}
	
	public static String getStringImage(Blob blob) {
		String base64Encoded = "resources/images/men.png";
		if(blob != null) {
			try {
//				Blob blob2 = blob;
				int blobLength = (int) blob.length();  
				byte[] imageData = blob.getBytes(1, blobLength);
				byte[] encodeBase64 = Base64.encodeBase64(imageData);
				base64Encoded = new String(encodeBase64, "UTF-8");
				InputStream is = new BufferedInputStream(new ByteArrayInputStream(imageData));
				String mimeType = URLConnection.guessContentTypeFromStream(is);
				base64Encoded = "data:" + mimeType + ";base64," + base64Encoded;
//				blob.free();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (IllegalStateException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return base64Encoded;
	}
	
	public static String getBase64Encoded(MultipartFile imageFile) {
		String base64Encoded = "resources/images/men.png";
		try {
			byte[] imageData = imageFile.getBytes();
			byte[] encodeBase64 = Base64.encodeBase64(imageData);
			base64Encoded = new String(encodeBase64, "UTF-8");
			String mimeType = imageFile.getContentType();
//			System.out.println("\n\n" + Arrays.equals(imageData, imageData1) + "\n\n");
			base64Encoded = "data:" + mimeType + ";base64," + base64Encoded;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64Encoded;
	}
	
	
	public static Blob getBlobImage(MultipartFile imageFile) {
		Blob blob = null;
		EntityManager em = emf.createEntityManager();
	    Session session = (Session) em.getDelegate();
	    try {
			blob = Hibernate.getLobCreator(session).createBlob(imageFile.getInputStream(), imageFile.getSize());
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return blob;
	}
	
	
	
	
}
