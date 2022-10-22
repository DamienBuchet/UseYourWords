package com.init.use_your_words2.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.init.use_your_words2.models.Equipe;
import com.init.use_your_words2.models.Partie;

public interface IEquipeRepository extends JpaRepository<Equipe, Integer>{

	@Query(nativeQuery = true, value = "select top 1 * from equipe order by id desc")
	public Equipe findLastEquipe();
}
