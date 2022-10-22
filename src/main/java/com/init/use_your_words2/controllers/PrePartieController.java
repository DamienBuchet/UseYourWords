package com.init.use_your_words2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.init.use_your_words2.interfaces.IJoueurRepository;

@Controller
public class PrePartieController {

private IJoueurRepository IJRepo;
	
	@GetMapping("/prepartie")
	public String PrePartieGet(Model model, HttpSession session)
	{		
		model.addAttribute("JoueursOrdi1", "ordi 1");
		model.addAttribute("JoueursOrdi2", "ordi 2");
		model.addAttribute("JoueursOrdi3", "ordi 3");
		model.addAttribute("JoueursOrdi4", "ordi 4");
		model.addAttribute("JoueursOrdi5", "ordi 5");
		model.addAttribute("pseudo", session.getAttribute("pseudoSession"));
		return "prepartie";
	}
	
	@PostMapping("/prepartie")
	public String PrePartiePost(@RequestParam String debut, HttpSession session, Model model)
	{
		if (debut != null)
		{
			
			return "redirect:partie";
		}
		else
		{
			return "prepartie";
		}
	}
}