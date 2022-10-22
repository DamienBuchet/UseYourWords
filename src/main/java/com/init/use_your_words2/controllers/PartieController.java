package com.init.use_your_words2.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.init.use_your_words2.interfaces.IJoueurManchePartieRepository;
import com.init.use_your_words2.interfaces.IJoueurRepository;
import com.init.use_your_words2.interfaces.IMancheRepository;
import com.init.use_your_words2.interfaces.IPartieRepository;
import com.init.use_your_words2.interfaces.IPropositionRepository;
import com.init.use_your_words2.interfaces.IScoreBoardRepository;
import com.init.use_your_words2.models.Joueur;
import com.init.use_your_words2.models.Manche;
import com.init.use_your_words2.models.Partie;
import com.init.use_your_words2.models.Proposition;
import com.init.use_your_words2.models.ScoreBoard;
import com.init.use_your_words2.models.TypeManche;
import com.init.use_your_words2.repositories.JoueurRepository;
import com.init.use_your_words2.repositories.ScoreboardRepository;

@Controller
public class PartieController {

	@Autowired
	private IPropositionRepository IPRepo;
	//private PropositionRepository PRepo;
	
	@Autowired
	private IPartieRepository IPartieRepo;
	//private PartieRepository PartieRepo;
	
	@Autowired
	private IJoueurRepository IJRepo;
	
	@Autowired
	private JoueurRepository JRepo;
	
	@Autowired
	private IMancheRepository IMRepo;
	//private MancheRepository MRepo;
	
	@Autowired
	private IJoueurManchePartieRepository IJMPRepo;
	//private JoueurManchePartieRepository JMPRepo;
	
	@Autowired
	//private IScoreBoardRepository ISBRepo;
	private ScoreboardRepository SBRepo;
	
	@GetMapping("/partie")
	public String PartieGet(Model model, HttpSession session)
	{		
		Partie partie = IPartieRepo.findLastPartie();
		
		TypeManche typemanche = TypeManche.getRandom();
		
		model.addAttribute("typemanche", typemanche);
		
		model.addAttribute("pseudo", session.getAttribute("pseudoSession"));
		
		int mancheCount = IMRepo.CountManchesForExitPartie(partie.getId());		
		
		model.addAttribute("JoueursOrdi1", "ordi 1");
		model.addAttribute("JoueursOrdi2", "ordi 2");
		model.addAttribute("JoueursOrdi3", "ordi 3");
		model.addAttribute("JoueursOrdi4", "ordi 4");
		model.addAttribute("JoueursOrdi5", "ordi 5");
		
		if (mancheCount >= 5)
		{
			model.addAttribute("listescore", IJRepo.findTop3BestScorePartie(partie.getId()));
			Joueur j = (IJRepo.findById((Integer) session.getAttribute("JoueurSession"))).get();
            		UseYourWords2Application.jaxbObjectToXML(j);
			return "scoreboard";
			
		} else
		{
			Manche manche = new Manche();
			manche.setPartie(partie);
			manche.setTypeManche(typemanche);
			IMRepo.save(manche);
			
			return "partie";
		}
	}
	
	@PostMapping("/partie")
	public String PartiePost(@RequestParam(value = "vote", required = false) String vote, @RequestParam(value = "choix", required = false) String choix, Model model, HttpSession session)
	{
		int voteInt = Integer.parseInt(vote);
		List<Integer> votes = new ArrayList<Integer>();
		
		Optional<Joueur> jforProposition = IJRepo.findById((Integer) session.getAttribute("JoueurSession"));
		
		Manche lastmanche = IMRepo.findLastManche();
		
		Proposition thePropositions = new Proposition(voteInt, lastmanche, jforProposition.get());
		
		IPRepo.save(thePropositions);
		
		try
		{
			votes.add(voteInt);
		}
		catch(NumberFormatException e)
		{
			votes.add(1);
		}
		
		for (int i = 0; i < 5; i++) {
			
			Random r = new Random();
			votes.add(r.nextInt((6-1) + 1) + 1);
		}

		int compteur1 = 0, compteur2 = 0, compteur3 = 0, compteur4 = 0, compteur5 = 0, compteur6 = 0;
		
		for (Integer integer : votes) {
			
			switch(integer) {
			
			case 1:
				compteur1++;
				break;
			
			case 2:
				compteur2++;
				break;
				
			case 3:
				compteur3++;
				break;
				
			case 4:
				compteur4++;
				break;
				
			case 5:
				compteur5++;
				break;
				
			case 6:
				compteur6++;
				break;
				
			default:
				break;
			}
		}
		
		model.addAttribute("compteur1", compteur1);
		model.addAttribute("compteur2", compteur2);
		model.addAttribute("compteur3", compteur3);
		model.addAttribute("compteur4", compteur4);
		model.addAttribute("compteur5", compteur5);
		model.addAttribute("compteur6", compteur6);
		
		Partie partieid = IPartieRepo.findLastPartie();
		
		JRepo.UpdateJoueurAfterMancheTerminée(compteur1, partieid, session.getAttribute("pseudoSession").toString());
		JRepo.UpdateJoueurAfterMancheTerminée(compteur2, partieid, "ordi 1");
		JRepo.UpdateJoueurAfterMancheTerminée(compteur3, partieid, "ordi 2");
		JRepo.UpdateJoueurAfterMancheTerminée(compteur4, partieid, "ordi 3");
		JRepo.UpdateJoueurAfterMancheTerminée(compteur5, partieid, "ordi 4");
		JRepo.UpdateJoueurAfterMancheTerminée(compteur6, partieid, "ordi 5");
		
		Joueur j = IJRepo.findByNameAndPartie(session.getAttribute("pseudoSession").toString(), partieid.getId());
		SBRepo.UpdateScoreBoardAfterPartieTerminée(compteur1, j.getId());
		
		Joueur j1 = IJRepo.findByNameAndPartie("ordi 1", partieid.getId());
		SBRepo.UpdateScoreBoardAfterPartieTerminée(compteur2, j1.getId());
		
		Joueur j2 = IJRepo.findByNameAndPartie("ordi 2", partieid.getId());
		SBRepo.UpdateScoreBoardAfterPartieTerminée(compteur3, j2.getId());
		
		Joueur j3 = IJRepo.findByNameAndPartie("ordi 3", partieid.getId());
		SBRepo.UpdateScoreBoardAfterPartieTerminée(compteur4, j3.getId());
		
		Joueur j4 = IJRepo.findByNameAndPartie("ordi 4", partieid.getId());
		SBRepo.UpdateScoreBoardAfterPartieTerminée(compteur5, j4.getId());
		
		Joueur j5 = IJRepo.findByNameAndPartie("ordi 5", partieid.getId());
		SBRepo.UpdateScoreBoardAfterPartieTerminée(compteur6, j5.getId());
		
		model.addAttribute("JoueursOrdi1", "ordi 1");
		model.addAttribute("JoueursOrdi2", "ordi 2");
		model.addAttribute("JoueursOrdi3", "ordi 3");
		model.addAttribute("JoueursOrdi4", "ordi 4");
		model.addAttribute("JoueursOrdi5", "ordi 5");
		
		model.addAttribute("pseudo", session.getAttribute("pseudoSession"));
		
		return "affichage_vote";
	}

}
