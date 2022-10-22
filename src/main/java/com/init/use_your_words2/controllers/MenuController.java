package com.init.use_your_words2.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.init.use_your_words2.interfaces.IEquipeRepository;
import com.init.use_your_words2.interfaces.IJoueurRepository;
import com.init.use_your_words2.interfaces.IPartieRepository;
import com.init.use_your_words2.interfaces.IScoreBoardRepository;
import com.init.use_your_words2.models.Equipe;
import com.init.use_your_words2.models.Joueur;
import com.init.use_your_words2.models.Partie;
import com.init.use_your_words2.models.ScoreBoard;
import com.init.use_your_words2.repositories.JoueurRepository;
import com.init.use_your_words2.repositories.PartieRepository;

@Controller
public class MenuController {

	@Autowired
	private IJoueurRepository IJRepo;
	//private JoueurRepository JRepo;
	
	@Autowired
	private IPartieRepository IPRepo;
	//private PartieRepository PRepo;
	
	@Autowired
	private IEquipeRepository IERepo;
	//private EquipeRepository ERepo;
	
	@Autowired
	private IScoreBoardRepository ISBRepo;
	//private EquipeRepository ERepo;
	
	@GetMapping("/menu")
	public String MenuGet()
	{		
		return "menu";
	}
	
	@PostMapping("/menu")
	public String MenuPost(@RequestParam(value = "pseudo", required = false) String pseudo, @RequestParam(value = "start", required = false) String start, @RequestParam(value = "join", required = false) String join, HttpSession session, Model model)
	{		
		session.setAttribute("pseudoSession", pseudo);
		
		Partie p = new Partie();
		IPRepo.save(p);
		
		Equipe e = new Equipe();
		e.setName("Equipe 1");
		IERepo.save(e);
		
		Partie lastpartie = IPRepo.findLastPartie();
		
		Joueur j1 = new Joueur();
		j1.setName(pseudo);
		j1.setPartie(lastpartie);
		Equipe lastequipe = IERepo.findLastEquipe();
		j1.setEquipe(lastequipe);
		IJRepo.save(j1);
		
		Joueur lastj = IJRepo.findLastJoueur();
		ScoreBoard sb = new ScoreBoard();
		sb.setJoueur(lastj);
		sb.setScoretotal(0);
		ISBRepo.save(sb);
		
		Equipe e2 = new Equipe();
		e2.setName("Equipe 2");
		IERepo.save(e2);
		
		Equipe lastequipe2 = IERepo.findLastEquipe();
		
		Joueur lastjoueur = IJRepo.findLastJoueur();
		
		String [] pseudos_ordi = new String[] {"ordi 1", "ordi 2", "ordi 3", "ordi 4", "ordi 5"};

		ScoreBoard sc = new ScoreBoard();
		sc.setJoueur(IJRepo.findByNameAndPartie(session.getAttribute("pseudoSession").toString(), lastpartie.getId()));
		sc.setScoretotal(0);
		
		for (int i = 0; i < pseudos_ordi.length; i++) {
			
			Joueur j_ordi = new Joueur();
			j_ordi.setName(pseudos_ordi[i]);
			j_ordi.setPartie(lastpartie);
			
			if (i >= 2)
			{
				j_ordi.setEquipe(lastequipe2);
			} else
			{
				j_ordi.setEquipe(lastequipe);
			}
			
			IJRepo.save(j_ordi);
			
			Joueur lastj_ordi = IJRepo.findLastJoueur();
			ScoreBoard sb_ordi = new ScoreBoard();
			sb_ordi.setJoueur(lastj_ordi);
			sb_ordi.setScoretotal(0);
			ISBRepo.save(sb_ordi);
		}	
		
		if (start != null)
		{						
			model.addAttribute("pseudo", pseudo);
			
			session.setAttribute("JoueurSession", lastjoueur.getId());
			
			return "redirect:prepartie";
		}
		else if(join != null)
		{
			model.addAttribute("JoueursOrdi", pseudos_ordi);
			
			model.addAttribute("pseudo", pseudo);
			
			session.setAttribute("JoueurSession", lastjoueur.getId());

			return "redirect:prepartie";
		}
		else
		{
			return "menu";
		}
	}
	
	@GetMapping("/leaderboard")
	public String getLeaderBoardPage(Model model)
	{	
//		System.out.println("je suis la ok");
		try {
		model.addAttribute("scores", ISBRepo.findAllTriéParScore());
//		System.out.println(ISBRepo.findAllTriéParScore());
		} catch (Exception e) {
			model.addAttribute("scores", null);
		}
//		System.out.println("je suis la ");
		return "leaderboard";
	}
	
	@GetMapping("/{page}")
	public String getPage(@PathVariable String page) 
	{
		
		return page;
	

	}
	
}
