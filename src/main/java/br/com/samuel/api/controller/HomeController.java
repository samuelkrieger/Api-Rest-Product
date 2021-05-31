package br.com.samuel.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.samuel.api.model.response.ProductResponse;
import br.com.samuel.api.service.ProductService;



@Controller
@RequestMapping("/home")
public class HomeController {
	

	 @Autowired
	 private ProductService Service;
	 
	 @GetMapping()
	 public String home(Model model,Pageable pageable) {
		    Page<ProductResponse> products =Service.getAll(pageable);
			model.addAttribute("products", products);
			return "home"; 
		}
		
	 
	 
	 
}
