package com.init.use_your_words2.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.init.use_your_words2.models.Equipe;
import com.init.use_your_words2.models.Joueur;
import com.init.use_your_words2.models.Partie;

public interface IJoueurRepository extends JpaRepository<Joueur, Integer> {
	
	@Query(nativeQuery = true, value = "select top 1 * from joueur order by id desc")
	public Joueur findLastJoueur();
	
	@Query(nativeQuery = true, value = "update joueur set score = score + :compteur where joueur_partie_id = :partie and name = ':nom'")
	public void UpdateJoueurAfterMancheTerminée(@Param("compteur") int compteur, @Param("partie") int partie, @Param("nom") String nom);

	@Query(nativeQuery = true, value = "select top 3 * from joueur where joueur_partie_id = :partie order by score desc")
	public List<Joueur> findTop3BestScorePartie(@Param("partie") int partie);
	
	@Query(nativeQuery = true, value = "select * from joueur where joueur.name = :name AND joueur.joueur_partie_id = :partie ")
	public Joueur findByNameAndPartie(@Param("name") String name, @Param("partie") int partie);
}
