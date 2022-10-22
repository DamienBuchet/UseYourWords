package com.init.use_your_words2.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.use_your_words2.models.Equipe;
import com.init.use_your_words2.models.JoueurManchePartie;

public interface IJoueurManchePartieRepository extends JpaRepository<JoueurManchePartie, Integer> {

	
}
