package com.init.use_your_words2.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.init.use_your_words2.models.Partie;

public interface IPartieRepository extends JpaRepository<Partie, Integer> {

	@Query(nativeQuery = true, value = "select top 1 * from partie order by id desc")
	public Partie findLastPartie();

}
