package com.ecommerce.application.controller;
import com.ecommerce.application.repository.UserRepository;
import java.util.List;
import com.ecommerce.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String viewHomePage1() {
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
	
	@GetMapping("/users")
	public String listUsers(Model model) {
	    List<User> listUsers = userRepo.findAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}
}
