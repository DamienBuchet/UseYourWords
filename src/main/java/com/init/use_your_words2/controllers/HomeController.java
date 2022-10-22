package com.init.use_your_words2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.init.use_your_words2.interfaces.IJoueurRepository;

@Controller
public class HomeController {

	private IJoueurRepository IJRepo;
	
	@GetMapping("/")
	public String RacineGet()
	{
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String LoginGet()
	{
		return "login";
	}
	
	@PostMapping("/login")
	public String LoginPost(@RequestParam String pseudo, @RequestParam String pwd, HttpSession session, Model model) {
			
		String mailverif = "root@root.fr";
		String pwdverif = "root";
		
		if (!pseudo.equals(mailverif) || !pwd.equals(pwdverif)) {
			model.addAttribute("error", true);
			return "login";
		}
		else
		{
			session.setAttribute("utilisateurSession", pseudo);
			return "redirect:menu";
		}
	}
}