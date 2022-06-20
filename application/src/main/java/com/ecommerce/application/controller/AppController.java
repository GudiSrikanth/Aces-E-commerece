package com.ecommerce.application.controller;

import com.ecommerce.application.repository.UserRepository;
import com.ecommerce.application.service.ProductService;

import java.util.List;
import com.ecommerce.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("")
	public String viewHomePage() {
		return "homepage";
	}
 
	@GetMapping("/homepage")
	public String homePage() {
		return "homepage";
	}

	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/registered")
	public String processRegister(User user) {
		userRepo.save(user);
		return "registered";
	}

	@GetMapping("/categories")
	public String listCategories() {

		return "categories";
	}

	@GetMapping("/coupon")
	public String listCoupons() {

		return "coupon";
	}

	@GetMapping("/electronics")
	public String listElectronics() {

		return "electronics";
	}

	@GetMapping("/menapparel")
	public String listMensApparel() {

		return "menapparel";
	}

	@GetMapping("/womenapparel")
	public String listWomensApparel() {

		return "womenapparel";
	}

	@GetMapping("/kidsapparel")
	public String listKidsApparel() {

		return "kidsapparel";
	}

	@GetMapping("/furniture")
	public String listFurniture() {

		return "furniture";
	}

	@GetMapping("/signin")
	public String showLoginPage() {
		return "signin";
	}

	@GetMapping("/resetpswd")
	public String showResetPswdPage() {

		return "resetpswd";
	}


	@GetMapping("/about")
	public String listAbout() {

		return "about";
	}
	@GetMapping("/index")
	public String index() {

		return "index";
	}
	
	@GetMapping("/checkout")
	public String checkout() {

		return "checkout";
	}

	@GetMapping("/contactus")
	public String listContactUs() {

		return "contactus";
	}

	@PostMapping("/signin")
	public String login(@ModelAttribute(name = "loginForm") User user, Model m) {
		String email = user.getEmail();
		String pass = user.getPassword();
		//System.out.println("from form :" + email + "\n" + pass);
		User loginUser = userRepo.findByEmail(email);
		//System.out.println("from database: " + loginUser.getEmail() + "\n" + loginUser.getPassword());
		if (email.equals(loginUser.getEmail()) && pass.equals(loginUser.getPassword())) {
			m.addAttribute("uname", email);
			m.addAttribute("pass", pass);
			return "categories";
		}
		m.addAttribute("error", "Incorrect Username & Password");
		return "signin";

	}
}
