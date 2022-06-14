package com.ecommerce.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.application.model.Product;
import com.ecommerce.application.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
    private ProductService service;
	
	@RequestMapping("/products")
	public String viewHomePage(Model model) {
	    List<Product> listProducts = service.listAll();
	    model.addAttribute("listProducts", listProducts);
	     
	    return "categories";
	}
}
