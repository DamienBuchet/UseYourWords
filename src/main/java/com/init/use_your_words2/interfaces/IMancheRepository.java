package com.init.use_your_words2.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.init.use_your_words2.models.Manche;
import com.init.use_your_words2.models.Partie;

public interface IMancheRepository extends JpaRepository<Manche, Integer> {

	@Query(nativeQuery = true, value = "select top 1 * from manche order by id desc")
	public Manche findLastManche();
	
	@Query(nativeQuery = true, value = "select count(id) from manche where manche_partie_id = :partie")
	public int CountManchesForExitPartie(@Param("partie") Integer partie);
}
